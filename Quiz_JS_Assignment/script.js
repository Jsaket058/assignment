let questions = [], currentQuestionIndex = 0, score = 0, timer;
const optionLabels = ["A", "B", "C", "D"];

async function startQuiz() {
    try {
        const category = document.getElementById("category").value;
        const difficulty = document.getElementById("difficulty").value;
        const response = await fetch(`https://opentdb.com/api.php?amount=10&category=${category}&difficulty=${difficulty}&type=multiple`);
        const data = await response.json();

        questions = data.results;
        document.getElementById("start-screen").classList.add("hidden");
        document.getElementById("quiz-screen").classList.remove("hidden");
        currentQuestionIndex = 0;
        score = 0;
        // Ensure score is reset on start
        updateScore();
        fadeInQuiz();
        loadQuestion();
    } catch (error) {
        console.error("Error fetching questions:", error);
    }
}

function loadQuestion() {
    if (currentQuestionIndex >= questions.length) {
        endQuiz();
        return;
    }

    fadeOutQuiz(() => {
        const questionData = questions[currentQuestionIndex];
        document.getElementById("question").innerHTML = questionData.question;

        let options = [...questionData.incorrect_answers, questionData.correct_answer];
        // i can use Fisher-Yates Shuffle Algorithm for shuffling of options , but this basic technique is easy to implement,
        // but can be change as per need in the future
        options.sort(() => Math.random() - 0.5);

        document.getElementById("options").innerHTML = options.map((opt, index) =>
            `<button class='option' onclick='checkAnswer(this, "${opt}", "${questionData.correct_answer}")'>
                ${optionLabels[index]}. ${opt}
            </button>`
        ).join(" ");

        document.getElementById("feedback").innerText = "";
        // Update score display after loading a new question
        updateScore();
        fadeInQuiz();
        startTimer();
    });
}

function startTimer() {
    let timeLeft = 15;
    document.getElementById("timer").innerText = `Time left: ${timeLeft}s`;
    clearInterval(timer);

    timer = setInterval(() => {
        timeLeft--;
        document.getElementById("timer").innerText = `Time left: ${timeLeft}s`;
        if (timeLeft <= 0) {
            clearInterval(timer);
            revealAnswer();
        }
    }, 1000);
}

function checkAnswer(button, selected, correct) {
    clearInterval(timer);
    const options = document.querySelectorAll(".option");

    if (selected === correct) {
        button.classList.add("correct");
        document.getElementById("feedback").innerText = "Correct!";
        score++;
    } else {
        button.classList.add("wrong");
        document.getElementById("feedback").innerText = `Incorrect! The correct answer is: ${correct}`;
        options.forEach(btn => {
            if (btn.innerText.includes(correct)) {
                btn.classList.add("correct");
            }
        });
    }
    // Update score after answering
    updateScore();
    setTimeout(() => {
        nextQuestion();
    }, 1000);
}

function revealAnswer() {
    const options = document.querySelectorAll(".option");
    const correctAnswer = questions[currentQuestionIndex].correct_answer;
    document.getElementById("feedback").innerText = `Time's up! The correct answer was: ${correctAnswer}`;

    options.forEach(btn => {
        if (btn.innerText.includes(correctAnswer)) {
            btn.classList.add("correct");
        }
    });

    setTimeout(() => {
        nextQuestion();
    }, 1000);
}

function nextQuestion() {
    currentQuestionIndex++;
    fadeOutQuiz(() => {
        loadQuestion();
    });
}

function updateScore() {
    document.getElementById("current-score").innerText = `Current Score: ${score}`;
}

function endQuiz() {
    fadeOutQuiz(() => {
        document.getElementById("quiz-screen").classList.add("hidden");
        document.getElementById("end-screen").classList.remove("hidden");
        document.getElementById("final-score").innerText = `Final Score : ${score}`;
        fadeInQuiz();
    });
}

function restartQuiz() {
    currentQuestionIndex = 0;
    score = 0;
    document.getElementById("end-screen").classList.add("hidden");
    document.getElementById("start-screen").classList.remove("hidden");
    // Reset score on restart
    updateScore();
}


function fadeInQuiz() {
    const quizContainer = document.getElementById("quiz-screen");
    quizContainer.style.opacity = "0";
    quizContainer.style.transition = "opacity 0.5s ease-in-out";
    setTimeout(() => {
        quizContainer.style.opacity = "1";
    }, 250);
}

function fadeOutQuiz(callback) {
    const quizContainer = document.getElementById("quiz-screen");
    quizContainer.style.opacity = "1";
    quizContainer.style.transition = "opacity 0.5s ease-in-out";
    quizContainer.style.opacity = "0";
    setTimeout(callback, 300);
}
