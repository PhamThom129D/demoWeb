$(document).ready(function() {
    // Validate fields as the user types
    $('#username').on('input', function() {
        var username = $(this).val();
        var feedback = $('#feedback');
        if (username.length < 3) {
            feedback.text("Tên đăng nhập phải dài ít nhất 3 ký tự").css("color", "red");
        } else {
            feedback.text("Trường dữ liệu hợp lý").css("color", "green");
        }
    });

    $('#password').on('input', function() {
        var password = $(this).val();
        var feedback = $('#passwordFeedback');
        if (password.length < 6) {
            feedback.text("Mật khẩu phải dài ít nhất 6 ký tự").css("color", "red");
        } else {
            feedback.text("Trường dữ liệu hợp lý").css("color", "green");
        }
    });

    $('#rePassword').on('input', function() {
        var rePassword = $(this).val();
        var password = $('#password').val();
        var feedback = $('#rePasswordFeedback');
        if (rePassword !== password) {
            feedback.text("Mật khẩu không khớp").css("color", "red");
        } else {
            feedback.text("Trường dữ liệu hợp lý").css("color", "green");
        }
    });

    $('#phonenumber').on('input', function() {
        var phone = $(this).val();
        var feedback = $('#phonenumberFeedback');
        var phoneRegex = /^[0-9]{10,15}$/;
        if (!phoneRegex.test(phone)) {
            feedback.text("Số điện thoại không hợp lệ").css("color", "red");
        } else {
            feedback.text("Trường dữ liệu hợp lý").css("color", "green");
        }
    });

    $('#address').on('input', function() {
        var address = $(this).val();
        var feedback = $('#addressFeedback');
        if (address.length < 5) {
            feedback.text("Địa chỉ phải dài ít nhất 5 ký tự").css("color", "red");
        } else {
            feedback.text("Trường dữ liệu hợp lý").css("color", "green");
        }
    });

    // Move to Step 2
    $(".next").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var rePassword = $("#rePassword").val();

        if (username.length < 3) {
            alert("Tên đăng nhập không hợp lệ");
            return;
        }
        if (password.length < 6 || password !== rePassword) {
            alert("Mật khẩu không hợp lệ");
            return;
        }

        // Show Step 2 and hide Step 1
        $("#step1").hide();
        $("#step2").show();
    });
});
