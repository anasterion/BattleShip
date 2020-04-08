<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BattleShip - Wait Opponent</title>
    <meta http-equiv="refresh" content="5">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="w3-container w3-display-middle">
    <h1 class="open-sans-font w3-center">Hello, ${sessionScope.player.name}!</h1>
    <h3 class="open-sans-font w3-center">Waiting for your opponent to connect...</h3>
    <div class="w3-center">
        <i class="fa fa-spinner fa-spin fa-3x"></i>
    </div>
</div>
</body>
</html>
