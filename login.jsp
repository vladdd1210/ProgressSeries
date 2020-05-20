<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/CSS" rel="stylesheet" href="CSS/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <div class="add-title1">
    <div class="reg">
        <a href="/register.jsp">Sign Up</a>
    </div>
             <form class="form" action="log" method="POST">
                <input type="text" name="login" placeholder="Login" required>
                <input type="password" name="password" placeholder="Password" required>
             <input class="submit" type="submit" value="Submit">
            </form>
            <c:if test="${wrongLoginOrPassword == true}"><p style="color: red;">Wrong login or password!</p></c:if>
            <c:if test="${successfulRegistration == true}"><p style="color: Lime;">You have successfully registred! Now log in!</p></c:if>
            </div>
</body>
</html>