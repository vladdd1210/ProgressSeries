<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/CSS" rel="stylesheet" href="CSS/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
    <div class="add-title1">
<div class="reg">
    <a href="/login.jsp">Sign In</a>
</div>
    <form class="form" action="reg" method="POST">
        <input type="text" name="Login" placeholder="Login" required>
        <input type="password" name="Password" placeholder="Password" required>
        <input type="password" name="Repeat_Password" style="margin-top: 5%;" placeholder="Repeat Password" required>
        <input class="submit" type="submit" value="Submit">
    </form>
    <c:if test="${passwordMismatch == true}"><p style="color: red;">Passwords mismatch!</p></c:if>
            <c:if test="${userExist == true}"><p style="color: red;">A user with this login already exists!</p></c:if>
            <c:if test="${successfulRegistration == true}"><p style="color: Lime;">You have successfully registered!</p></c:if>
            <c:if test="${passwordLength == true}"><p style="color: red;">Password must be at least 8 characters!</p></c:if>
            <c:if test="${loginLength == true}"><p style="color: red;">Login must be at least 6 characters!</p></c:if>
</div>
</body>
</html>