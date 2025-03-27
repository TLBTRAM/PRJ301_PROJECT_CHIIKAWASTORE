<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Register</title>
    </head>
    <style>
        /* Tổng thể */
        body {
            font-family: Arial, sans-serif;
            background-color: #FFFDDE;
        }

        /* Khu vực đăng ký */
        .register-container {
            min-height: 500px;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #FFFDDE;
            padding: 20px;
        }

        .register-form {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        /* Tiêu đề */
        .form-title {
            font-size: 24px;
            font-weight: bold;
            color: #444;
            margin-bottom: 20px;
            text-align: center;
        }

        /* Nhóm nhập liệu */
        .form-group {
            margin-bottom: 18px;
            text-align: left;
        }

        .form-group label {
            font-size: 14px;
            font-weight: 600;
            color: #555;
            display: block;
            margin-bottom: 6px;
        }

        .form-group input {
            width: 100%;
            padding: 12px;
            border: 2px solid #FFC8D2;
            border-radius: 8px;
            font-size: 16px;
            transition: 0.3s;
        }

        .form-group input:focus {
            border-color: #FF6699;
            outline: none;
        }

        /* Nút đăng ký */
        .submit-btn {
            background: linear-gradient(to right, #FF6699, #FF4081);
            color: white;
            padding: 12px 0;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            width: 100%;
            transition: 0.3s;
        }

        .submit-btn:hover {
            background: linear-gradient(to right, #FF4081, #E65C87);
        }

        /* Đăng nhập link */
        .login-link {
            text-align: center;
            margin-top: 12px;
        }

        .login-link a {
            color: #FF4081;
            text-decoration: none;
            font-weight: bold;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <%@include file="header.jsp" %>

    
    
    <div class="register-container">
        <div class="register-form">
            <h2 class="form-title">Đăng ký tài khoản</h2>
            <form action="MainController" method="post">
                <input type="hidden" name="action" value="register" />

                <div class="form-group">
                    <label for="userID">Tên đăng kí</label>
                    <input type="text" id="userID" name="txtUserID" required />
                </div>

                <div class="form-group">
                    <label for="fullName">Họ tên</label>
                    <input type="text" id="fullName" name="txtFullName" required />
                </div>

                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input type="password" id="password" name="txtPassword" required />
                </div>

                <button type="submit" class="submit-btn">Đăng ký</button>

                <%
                    String error_Password = request.getAttribute("error_Password") + "";
                    String error_Register = request.getAttribute("error_Register") + "";
                %>

                <div style="color:red; padding-top: 10px">
                    <%=error_Password.equals("null") ? "" : error_Password%>
                </div>
                <div style="color:red; padding-top: 10px">
                    <%=error_Register.equals("null") ? "" : error_Register%>
                </div>

                <div class="login-link">
                    <p>Đã có tài khoản ? <a href="login.jsp">Đăng nhập ngay</a> </p>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</body>
</html>