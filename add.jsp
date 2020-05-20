<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/CSS" rel="stylesheet" href="CSS/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
</head>
<body>
    <form class="add-title" action="addTitle" method="POST">
        <input class="input" type="text" required name="Name" placeholder="Title">
        <textarea class="input" required rows="10" cols="45" name="Description" placeholder="Description"></textarea>
        <input class="input" type="submit" value="Submit">
    </form>
    <form class="add-episode" action="addEpisode" method="POST" name="addEpisode">
        <input class="input" required type="text" name="Name" Placeholder="Name">
        <textarea class="input" required rows="10" cols="45" name="Description" placeholder="Description"></textarea>
        <input class="input" required type="number" name="Length" placeholder="Length" step="any">
        <input class="input" type="text" name="IDTitleText" id="IDTitleText" placeholder="Search Title">
                        <select class="input" required name="IDTitle" id="IDTitle">
                            <c:forEach var="Titles" items="${Titles}">
                                <option value="${Titles.iDTitle}">${Titles.name}</option>
                            </c:forEach>
                        </select>
        <input class="input" type="submit" value="Submit">
    </form>
    <div class="main-page">
        <a href="/">Main page</a>
    </div>
    
    <script type="text/javascript" src="JS/EpisodeSearch.js"></script>
</body>
</html>