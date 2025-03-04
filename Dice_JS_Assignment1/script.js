let currentPlayer = 1;
let scores = {
    1: { saved: 0, current: 0 },
    2: { saved: 0, current: 0 } 
    };
const dice = document.getElementById("dice");

function rollDice() {
    document.getElementById("name1").setAttribute("disabled", "true");
    document.getElementById("name2").setAttribute("disabled", "true");
    let roll = Math.floor(Math.random() * 6) + 1;
    dice.src = `dice${roll}.png`;
    if (roll === 1) {
        scores[currentPlayer].current = 0;
        switchTurn();
    } else {
        scores[currentPlayer].current += roll;
    }
    updateUI();
}

function saveScore() {
    scores[currentPlayer].saved += scores[currentPlayer].current;
    scores[currentPlayer].current = 0;
    if (scores[currentPlayer].saved >= 100) {
        document.getElementById("winner").textContent = document.getElementById(`name${currentPlayer}`).value + " Wins!";
    } else {
        switchTurn();
    }
    updateUI();
}

function switchTurn() {
    currentPlayer = currentPlayer === 1 ? 2 : 1;
}

function updateUI() {
    document.getElementById("saved1").textContent = scores[1].saved;
    document.getElementById("current1").textContent = scores[1].current;
    document.getElementById("saved2").textContent = scores[2].saved;
    document.getElementById("current2").textContent = scores[2].current;
}

function resetGame() {
    currentPlayer = 1;
    scores = { 1: { saved: 0, current: 0 }, 2: { saved: 0, current: 0 } };
    dice.src = "dice1.png";

    let name1 = document.getElementById("name1");
    let name2 = document.getElementById("name2");

    name1.value = "Player 1";
    name2.value = "Player 2";

    name1.removeAttribute("disabled");
    name2.removeAttribute("disabled");

    document.getElementById("winner").textContent = "";
    updateUI();
}

document.getElementById("reset").addEventListener("click", resetGame);