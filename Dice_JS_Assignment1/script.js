let currentPlayer = 1;
const scores = {
    1: { saved: 0, current: 0 },
    2: { saved: 0, current: 0 }
};

const dice = document.getElementById("dice");
const winnerText = document.getElementById("winner");
const playerNames = {
    1: document.getElementById("name1"),
    2: document.getElementById("name2")
};

const scoreElements = {
    1: {
        saved: document.getElementById("saved1"),
        current: document.getElementById("current1")
    },
    2: {
        saved: document.getElementById("saved2"),
        current: document.getElementById("current2")
    }
};

function rollDice() {
    disableNameEditing();

    // rolling effect for 1 second
    let rollAnimationDuration = 1000;
    // Change dice every 100ms
    let rollInterval = 100; 
    let rollingTime = 0;

    let rollEffect = setInterval(() => {
        let tempRoll = getRandomDiceRoll();
        updateDiceImage(tempRoll);
        rollingTime += rollInterval;

        if (rollingTime >= rollAnimationDuration) {
            // Stop rolling effect
            clearInterval(rollEffect); 

            let finalRoll = getRandomDiceRoll();
            updateDiceImage(finalRoll);

            if (finalRoll === 1) {
                scores[currentPlayer].current = 0;
                switchTurn();
            } else {
                scores[currentPlayer].current += finalRoll;
            }
            updateUI();
        }
    }, rollInterval);
}


function saveScore() {
    scores[currentPlayer].saved += scores[currentPlayer].current;
    scores[currentPlayer].current = 0;

    if (scores[currentPlayer].saved >= 100) {
        declareWinner();
    } else {
        switchTurn();
    }
    updateUI();
}

function switchTurn() {
    currentPlayer = currentPlayer === 1 ? 2 : 1;
    highlightCurrentPlayer();
}

function resetGame() {
    currentPlayer = 1;
    scores[1] = { saved: 0, current: 0 };
    scores[2] = { saved: 0, current: 0 };
    dice.src = "dice1.png";

    enableNameEditing();
    resetNames();
    winnerText.textContent = "";

    updateUI();
}

function getRandomDiceRoll() {
    return Math.floor(Math.random() * 6) + 1;
}

function updateDiceImage(roll) {
    dice.src = `dice${roll}.png`;
}

function updateUI() {
    for (let player of [1, 2]) {
        scoreElements[player].saved.textContent = scores[player].saved;
        scoreElements[player].current.textContent = scores[player].current;
    }
}

function disableNameEditing() {
    playerNames[1].setAttribute("disabled", "true");
    playerNames[2].setAttribute("disabled", "true");
}

function enableNameEditing() {
    playerNames[1].removeAttribute("disabled");
    playerNames[2].removeAttribute("disabled");
}

function resetNames() {
    playerNames[1].value = "Player 1";
    playerNames[2].value = "Player 2";
}

function declareWinner() {
    winnerText.textContent = `${playerNames[currentPlayer].value} Wins! 🎉`;
}

function highlightCurrentPlayer() {
    document.getElementById("player1").style.opacity = currentPlayer === 1 ? "1" : "0.5";
    document.getElementById("player2").style.opacity = currentPlayer === 2 ? "1" : "0.5";
}

document.getElementById("reset").addEventListener("click", resetGame);
