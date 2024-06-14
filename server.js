const express = require('express');
const bodyParser = require('body-parser');
const sqlite3 = require('sqlite3').verbose();
const path = require('path');

const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Servir arquivos estáticos (HTML, CSS, JS) da pasta 'public'
app.use(express.static(path.join(__dirname, 'public')));

// Rota explícita para servir o arquivo index.html (login)
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'login.html'));
});

// Rota para servir a página do jogo
app.get('/jogo-do-bicho', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'jogo.html'));
});

// Rota para servir a página de cadastro
app.get('/cadastro', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'registro.html'));
});

// Conectar ao banco de dados SQLite
let db = new sqlite3.Database('./cadastro.db');

app.post('/cadastro', (req, res) => {
  const { nome, email, senha, confirma_senha } = req.body;

  if (senha !== confirma_senha) {
    return res.status(400).send('As senhas não coincidem.');
  }

  const stmt = db.prepare("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)");
  stmt.run(nome, email, senha, (err) => {
    if (err) {
      console.error('Erro ao salvar os dados:', err.message);
      return res.status(500).send('Erro ao salvar os dados: ' + err.message);
    }

    // Fechando a declaração preparada após o INSERT
    stmt.finalize();

    // Redirecionamento após o cadastro bem-sucedido
    res.writeHead(302, {
      'Location': '/jogo-do-bicho'
    });
    res.end();
  });
});

// Rota para processar o login
app.post('/login', (req, res) => {
  const { email, senha } = req.body;

  db.get("SELECT * FROM usuarios WHERE email = ? AND senha = ?", [email, senha], (err, row) => {
    if (err) {
      return res.status(500).json({ success: false, message: 'Erro no servidor: ' + err.message });
    }
    if (row) {
      res.json({ success: true });
    } else {
      res.json({ success: false, message: 'Usuário ou senha incorreta' });
    }
  });
});

// Iniciar o servidor
app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
