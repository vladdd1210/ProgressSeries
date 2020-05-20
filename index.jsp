<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/CSS" rel="stylesheet" href="CSS/style.css">
    <script type="text/javascript" src="JS/changetype.js"></script>
</head>
<header>
    <div class="header">
    <div class="top-menue">
        <div class="left-menue">
            <a href="/">Postav'te 60</a>
        </div>
        <div class="right-menue">
            <a href="/Profile">${sessionScope.sessionLogin}</a>
        <c:if test = "${Permission == 1}">
            <a href="/add">Add Title</a>
        </c:if>
            <a href="/logOut">Log Out</a>
        </div>
    </div>
</div>
</header>
<body class="body">

<div class="main-body">


    <div class="left-collumn">
        <c:forEach var="Titles" items="${Titles}">
        <span>
        <div class="titles">
            <a href="/show?IDTitle=${Titles.iDTitle}">${Titles.name}</a>
        </div>
        </span>
        </c:forEach>
        </span>
    </div>
    <form action="changeEpisode" method="GET" class="right-collumn" id="changeEpisode">
        <input type="hidden" name="iDTitle" value="${IDTitle}">
        <c:forEach var="Episodes" items="${Episodes}">
            <span>
                <div class="descriptions">
                        <input type="radio" name="watching" onchange="redirect(${Episodes.iDEpisode})" value="${Episodes.iDEpisode}" <c:if test="${Episodes.iDEpisode == IDEpisode}">checked</c:if>>
                        <a href="/showDescription?iDEpisode=${Episodes.iDEpisode}&iDTitle=${IDTitle}">${Episodes.name}</a>
                </div>
             </span>
        </c:forEach>
    </form>
</div>

</body>
</html>