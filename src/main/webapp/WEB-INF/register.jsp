<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BattleShip - Register</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:700&display=swap" rel="stylesheet">
</head>
<body>
<div class="w3-card-4 w3-display-middle">
    <div class="w3-container w3-blue-gray">
        <h2>Registration</h2>
    </div>
    <form class="w3-container" action="/battleship" method="post">
        <p>
            <label class="w3-text-blue-gray"><b>Enter your name:</b></label>
            <input class="w3-input w3-border" type="text" required name="name">
        </p>
        <button class="w3-btn w3-blue-gray" type="submit">Start!</button>
        </p>
    </form>
</div>
</body>
</html>
