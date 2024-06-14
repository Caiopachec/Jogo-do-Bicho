const sqlite3 = require('sqlite3').verbose();

let db = new sqlite3.Database('./cadastro.db');

db.serialize(() => {
  db.run("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY, nome TEXT, email TEXT, senha TEXT)");

  console.log('Banco de dados e tabela criados com sucesso.');
});

db.close();
