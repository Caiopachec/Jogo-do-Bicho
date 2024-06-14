document.getElementById('betForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const animal = document.getElementById('animal').value;
    const betType = document.getElementById('betType').value;
    const betAmount = parseFloat(document.getElementById('betAmount').value);
    const randomNumber = Math.floor(Math.random() * 10000); // Sorteio entre 0 e 9999
    const betHistoryList = document.getElementById('historyList');
    const resultDiv = document.getElementById('result');

    let isWinner = false;
    let prizeMultiplier = 0;

    if (betType === 'dezena') {
        isWinner = (randomNumber % 100) === 50; // Exemplo para dezena
        prizeMultiplier = 70;
    } else if (betType === 'centena') {
        isWinner = (randomNumber % 1000) === 150; // Exemplo para centena
        prizeMultiplier = 600;
    } else if (betType === 'milhar') {
        isWinner = randomNumber === 5150; // Exemplo para milhar
        prizeMultiplier = 4000;
    }

    const betResult = {
        animal: animal,
        betType: betType,
        betAmount: betAmount,
        randomNumber: randomNumber,
        isWinner: isWinner
    };

    let resultText = `Número sorteado: ${randomNumber}. `;
    if (isWinner) {
        resultText += `Parabéns! Você ganhou R$${betAmount * prizeMultiplier}!`;
    } else {
        resultText += `Que pena! Você perdeu.`;
    }

    resultDiv.textContent = resultText;
    appendToHistory(betResult);

    function appendToHistory(betResult) {
        const listItem = document.createElement('li');
        listItem.textContent = `Animal: ${betResult.animal}, Tipo de aposta: ${betResult.betType}, Valor: R$${betResult.betAmount}, Número sorteado: ${betResult.randomNumber}, ${betResult.isWinner ? 'Ganhou' : 'Perdeu'}`;
        betHistoryList.appendChild(listItem);
    }
});

document.getElementById('themeToggle').addEventListener('click', function() {
    document.body.classList.toggle('dark-mode');
    this.textContent = document.body.classList.contains('dark-mode') ? 'Modo Claro' : 'Modo Escuro';
});
