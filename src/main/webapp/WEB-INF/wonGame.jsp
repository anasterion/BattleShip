<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BattleShip - Game Over</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-display-middle">
    <h1 class="open-sans-font w3-center">Game Over!</h1>
    <h1 class="open-sans-font w3-center">You Won!</h1>
    <form action="/battleship" method="post">
        <input type="hidden" name="name" value="${sessionScope.player.name}">
        <div class="w3-padding w3-center">
            <button class="w3-btn w3-blue w3-round w3-large" type="submit">Start new game</button>
        </div>
    </form>
</div>
</body>
</html>