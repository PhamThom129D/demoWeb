<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/authenticate/register.css">
</head>
<body class="container">
<div class="register-box">
    <h2>Sign Up</h2>
    <form action="/login?action=signUp" method="post">
        <div class="user-box">
            <input type="text" name="username" required>
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" required>
            <label>Password</label>
        </div>
        <div class="user-box">
            <input type="text" name="phonenumber" required>
            <label>Phone Number</label>
        </div>
        <div class="user-box">
            <input type="text" name="address" required>
            <label>Address</label>
        </div>
        <button type="submit" name="submit" value="SignUp">Sign Up</button>
    </form>
    <a href="login.jsp" class="sign-in-btn">Already have an account? Sign In</a>
</div>
</body>
</html>
