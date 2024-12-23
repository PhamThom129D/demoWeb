<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/authenticate/register.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="container">
<div class="register-box">
    <h1  style="color: white">Đăng ký</h1>
    <form id="registerForm" action="/login?action=signUp" method="post" >

        <!-- Step 1: Username and Password -->
        <fieldset id="step1">
            <div class="user-box">
                <input type="text" name="username" id="username" required>
                <label>Tên đăng nhập</label>
                <small id="feedback" class="error"></small>
            </div>

            <div class="user-box">
                <input type="password" name="password" id="password" required>
                <label>Mật khẩu</label>
                <small id="passwordFeedback" class="error"></small>
            </div>

            <div class="user-box">
                <input type="password" id="rePassword" name="rePassword" required>
                <label>Nhập lại mật khẩu</label>
                <small id="rePasswordFeedback" class="error"></small>
            </div>

            <input type="button" class="next action-button" value="Tiếp theo" />
        </fieldset>

        <!-- Step 2: Address and Phone Number -->
        <fieldset id="step2" style="display:none;">
            <div class="user-box">
                <input type="text" name="phonenumber" id="phonenumber" required>
                <label>Số điện thoại</label>
                <small id="phonenumberFeedback" class="error"></small>
            </div>

            <div class="user-box">
                <input type="text" name="address" id="address" required>
                <label>Địa chỉ</label>
                <small id="addressFeedback" class="error"></small>
            </div>

            <button type="submit" name="submit">Đăng ký</button>
        </fieldset>

    </form>
    <a href="/login?action=redirectLogin" class="sign-in-btn">Đã có tài khoản? Đăng nhập</a>
</div>

<script src="/authenticate/register.js"></script>
</body>
</html>
