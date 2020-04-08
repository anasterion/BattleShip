<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BattleShip - setup your ships</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-display-middle">
    <form action="/setup" method="post">
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
                        <td>
                            <c:set var="addr" value="${col}${row}"/>
                            <input class="w3-check" type="checkbox" name="cells" value="${addr}" style="top: 0" <c:if
                                    test="${sessionScope.player.allyField.getState(addr) == 'SHIP'}">checked</c:if>>
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
            <button class="w3-btn w3-green w3-round w3-large" type="submit">Start</button>
        </div>
    </form>
</div>
</body>
</html>
