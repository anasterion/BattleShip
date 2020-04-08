<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BattleShip - Wait Fire</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-display-middle">
    <form action="/game" method="post">
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
                            <input class="w3-radio" type="radio" name="cell" value="${addr}" style="top: 0">
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${not empty requestScope.message}">
            <div class="w3-panel w3-red">
                <h3 class="w3-center">${requestScope.message}</h3>
            </div>
        </c:if>
        <div class="w3-padding w3-center">
            <button class="w3-btn w3-red w3-round w3-large" type="submit">Fire!</button>
        </div>
    </form>

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
