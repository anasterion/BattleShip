<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BattleShip - Wait Fire</title>
    <meta http-equiv="refresh" content="5">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-display-middle">
    <table class="w3-table">
        <tr>
            <td></td>
            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                <th class="w3-center open-sans-font">${col}</th>
            </c:forEach>
        </tr>
        <c:forEach begin="1" end="10" var="row">
            <tr>
                <th class="open-sans-font">${row}</th>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <c:set var="addr" value="${col}${row}"/>
                    <c:set var="ship" value="${sessionScope.player.allyField.getState(addr)}"/>
                    <td class="${ship}">

                    </td>
                </c:forEach>
            </tr>
        </c:forEach>

        <tr>
            <td style="border: none"></td>
        </tr>

        <tr>
            <td></td>
            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                <th class="w3-center open-sans-font">${col}</th>
            </c:forEach>
        </tr>
        <c:forEach begin="1" end="10" var="row">
            <tr>
                <th class="open-sans-font">${row}</th>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <c:set var="addr" value="${col}${row}"/>
                    <c:set var="ship" value="${sessionScope.player.enemyField.getState(addr)}"/>
                    <td class="${ship}">

                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${not empty sessionScope.player.history}">
        <div class="log-box">
            <c:forEach var="logMsg" items="${sessionScope.player.history}">
                <p class="open-sans-font">${logMsg}</p>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
