<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/CSS" rel="stylesheet" href="CSS/style.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body> 
    <div class="add-title1">
    <div class="reg">
    <a href="/">Main Page</a>
</div>
    <form class="form" action="addToList" method="POST" name="addEpisode">
        <input class="input" type="text" name="IDTitleText" id="IDTitleText" placeholder="Search Title">
        <select class="input" required name="IDTitle" id="IDTitle">
            <c:forEach var="Titles" items="${Titles}">
                <option value="${Titles.iDTitle}">${Titles.name}</option>
            </c:forEach>
        </select>
<input class="submit" type="submit" value="Submit" style="margin-top: 5%;">
    </form>  
    <c:if test="${successfulyAdded == true}"><p style="color: red;">Successfuly Added!</p></c:if>
    <c:if test="${alreadyHave == true}"><p style="color: red;">You are already watching this title!</p></c:if>
    <c:if test="${noEpisodes == true}"><p style="color: red;">No such episode!</p></c:if>
    <script type="text/javascript" src="JS/EpisodeSearch.js"></script>
</div>
</body>
</html>