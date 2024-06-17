// Variável global para armazenar o saldo
let saldo = 1000.00;

// Função para realizar a aposta
function makeBet() {
    // Obter o valor da aposta e o saldo atual
    let betAmount = parseFloat(document.getElementById('bet-amount').value);
    
    // Verificar se o saldo é suficiente para a aposta
    if (betAmount > saldo) {
        alert('Saldo insuficiente para esta aposta.');
        return;
    }

    // Reduzir o saldo pela aposta realizada
    saldo -= betAmount;
    
    // Atualizar o saldo na interface
    document.getElementById('balance').textContent = saldo.toFixed(2);

    // Exemplo de mensagem de sucesso
    let resultMessage = document.getElementById('result-message');
    resultMessage.textContent = `Aposta de R$ ${betAmount.toFixed(2)} realizada com sucesso.`;
    resultMessage.classList.remove('lose'); // Remover classe de perda, se houver
    resultMessage.classList.add('win'); // Adicionar classe de vitória
}

// Exemplo de função para atualizar o histórico de apostas
function updateBetHistory(bicho, valorAposta) {
    // Aqui você pode adicionar lógica para atualizar o histórico de apostas
    let betHistory = document.getElementById('bet-history');
    let newItem = document.createElement('li');
    newItem.textContent = `Aposta: Bicho ${bicho}, Valor: R$ ${valorAposta.toFixed(2)}`;
    betHistory.appendChild(newItem);
}



function openHistory() {
    document.getElementById("history-section").style.display = "block";
}

function closeHistory() {
    document.getElementById("history-section").style.display = "none";
}

function makeBet() {
    const bichoSelect = document.getElementById("bicho-select");
    const betAmount = document.getElementById("bet-amount").value;
    const selectedBicho = bichoSelect.options[bichoSelect.selectedIndex].text;
    const balanceElement = document.getElementById("balance");
    let balance = parseFloat(balanceElement.innerText);

    // Simulação de um resultado aleatório com maior chance de vitória
    const randomValue = Math.random();
    let resultBicho;
    if (randomValue < 0.2) {
        resultBicho = parseInt(bichoSelect.value); // 20% de chance de ganhar
    } else {
        resultBicho = Math.floor(Math.random() * 25) + 1; // 20% de chance de qualquer bicho
    }

    let resultMessage = `Você apostou no bicho ${selectedBicho}. O bicho sorteado foi ${resultBicho}.`;

    if (parseInt(bichoSelect.value) === resultBicho) {
        resultMessage += " Parabéns, você ganhou!";
        document.getElementById("result-message").className = "result-message win";
        balance += parseFloat(betAmount); // Aumenta o saldo com o valor da aposta
    } else {
        resultMessage += " Que pena, você perdeu.";
        document.getElementById("result-message").className = "result-message lose";
        balance -= parseFloat(betAmount); // Diminui o saldo com o valor da aposta
    }

    // Atualiza o saldo
    balanceElement.innerText = balance.toFixed(2);

    // Atualiza a mensagem de resultado na tela
    document.getElementById("result-message").innerText = resultMessage;

    // Adiciona a aposta ao histórico
    const betHistory = document.getElementById("bet-history");
    const newHistoryItem = document.createElement("li");
    newHistoryItem.textContent = resultMessage;
    betHistory.appendChild(newHistoryItem);
}
