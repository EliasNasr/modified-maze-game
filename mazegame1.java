//Initialized variables
let is_game_running = false; 
let score = 0;
let timer = 10;

//Declared variables
let end;
let start;
let boundaries;
let status_display; 

//create a new element
let coin = document.createElement("coin");
let reset = document.createElement("reset");

document.addEventListener("DOMContentLoaded", loadPage);

function displayScore(message){
    if(message != "")
        status_display.innerHTML = message + "<br/>" + "Your Score is: " + score;
}

function displayTimer(){
    status_display.innerHTML = "your challenging timer is: "+timer+" seconds";
}

function gameOver(){
    if(is_game_running){
        for(let i = 0; i < boundaries.length; i++)
            boundaries[i].style.backgroundColor = "rgb(243, 159, 159)"; 
        if(score > 0)
            score = score - 1;
        displayScore("Game Over!");
        is_game_running = false;
    }
}

function startGame(){
    while(timer >= 0){
        timer --;
        displayTimer();
        if (timer = 0)
            displayTimer("Time out!");
        if (gameOver())
            timer = 10;
        if (endgame())
            displayTimer("you won in: "+(10-timer));
    }
    timer = 10;
    displayScore("");
    is_game_running = true;
    for(let i = 0; i < boundaries.length; i++)
        boundaries[i].style.backgroundColor = "#eeeeee"; 
    reset = document.getElementById("reset");
    reset.addEventListener("click", loadPage);
}

function endGame(){
    if(is_game_running){
        for(let i = 0; i < boundaries.length; i++)
            boundaries[i].style.backgroundColor = "rgb(113 225 141)"; 
        score = score + 5;
        displayScore("You Won!");
        is_game_running = false;
    }
}

function earnCoin(){
    score += 5;
    displayScore("you got a +5");
}

function loadPage(){
    displayTimer();
    end = document.getElementById("end");
    start = document.getElementById("start");
    boundaries = document.getElementsByClassName("boundary");
    status_display =  document.getElementById("status");
    coin = document.getElementById("coin");

    end.addEventListener("mouseover", endGame);
    start.addEventListener("click", startGame);
    coin.addEventListener("mouseover", earnCoin);
    for(let i = 0; i < boundaries.length; i++){
        boundaries[i].addEventListener("mouseover", gameOver);
    }
}