<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Order Success</title>
    </head>


    <style>
        /* 💙 Container thông báo thành công */
        .chiikawa-success-container {
            background: #93E0FF;
            padding: 30px;
            border-radius: 20px;
            max-width: 650px; /* 📏 Tăng chiều rộng */
            margin: 60px auto; /* 📏 Tăng khoảng cách trên dưới */
            text-align: center;
            box-shadow: 0 5px 12px rgba(0, 0, 0, 0.15);
        }

        /* 💙 Tiêu đề */
        .chiikawa-title {
            color: white;
            font-size: 28px; /* 📏 Tăng kích thước chữ */
            text-shadow: 3px 3px #6bb8ff;
            font-weight: bold;
        }

        /* 💙 Nội dung thông báo */
        .chiikawa-message {
            font-size: 20px; /* 📏 Tăng kích thước chữ */
            color: #fff;
            margin-top: 15px;
        }

        /* 💙 Nút bấm về trang chủ */
        .chiikawa-button {
            display: inline-block;
            padding: 14px 22px; /* 📏 Tăng kích thước nút */
            margin-top: 20px;
            background-color: #6bb8ff;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            font-size: 20px; /* 📏 Tăng kích thước chữ */
            font-weight: bold;
            box-shadow: 4px 4px #4a94d6;
            transition: all 0.3s ease-in-out;
            border: none;
        }

        .chiikawa-button:hover {
            background-color: #5ca9f2;
            box-shadow: 6px 6px #3b83c2;
            transform: scale(1.07);
        }
    </style>


    <body>
        <jsp:include page="header.jsp"/>

        <div class="chiikawa-success-container">
            <h2 class="chiikawa-title">🎉 Đặt Hàng Thành Công! 🎉</h2>
            <p class="chiikawa-message">Cảm ơn bạn đã mua hàng! Đơn hàng của bạn sẽ sớm được giao. 🚀</p>
            <a href="MainController?action=search" class="chiikawa-button">Về Trang Chủ 🏡</a>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
