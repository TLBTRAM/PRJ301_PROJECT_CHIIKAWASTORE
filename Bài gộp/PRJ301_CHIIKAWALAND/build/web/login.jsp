<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Login</title>
        <style>
            /* Tổng thể */
            body {
                font-family: Arial, sans-serif;
                background-color: #FFFDDE;
            }

            /* Khu vực đăng nhập */
            .login-container {
                min-height: 500px;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #FFFDDE;
                padding: 20px;
            }

            .login-form {
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

            /* Nút đăng nhập */
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
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="login-container">
            <div class="login-form">
                <h2 class="form-title">Đăng nhập</h2>
                <form action="MainController" method="post">
                    <input type="hidden" name="action" value="login" />

                    <div class="form-group">
                        <label for="userId">Tên đăng nhập</label>
                        <input type="text" id="userId" name="txtUserID" required />
                    </div>

                    <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <input type="password" id="password" name="txtPassword" required />
                    </div>

                    <button type="submit" class="submit-btn">Đăng nhập</button>

                    <%
                        String message = request.getAttribute("message") + "";
                    %>

                    <div style="color:red">
                        <%=message.equals("null") ? "" : message%>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
