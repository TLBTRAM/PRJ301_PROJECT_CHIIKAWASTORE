<%@page import="dto.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Check out</title>
    </head>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #FFFDDE;
            color: #444;
            text-align: center;
        }

        /* 🎀 Container thanh toán */
        .chiikawa-checkout-container {
            background: #93E0FF;
            padding: 25px;
            border-radius: 20px;
            max-width: 600px;
            margin: 40px auto;
            text-align: center;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.15);
        }

        /* 🎀 Tiêu đề */
        .chiikawa-title {
            color: #FFF;
            font-size: 28px;
            text-shadow: 2px 2px #5BA8CC;
            font-weight: bold;
        }

        /* 🎀 Bảng giỏ hàng */
        .chiikawa-cart-table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
            margin: 20px 0 ;
        }

        .chiikawa-cart-table th, 
        .chiikawa-cart-table td {
            padding: 12px;
            border-bottom: 2px dashed #5BA8CC;
            text-align: center;
        }

        .chiikawa-cart-table th {
            background-color: #B3E5FF;
            color: #fff;
            font-size: 18px;
        }

        .chiikawa-cart-table td {
            font-size: 16px;
        }

        /* 🎀 Tổng tiền */
        .chiikawa-total {
            font-size: 20px;
            font-weight: bold;
            margin-top: 15px;
            color: #2B79A2;
        }

        .chiikawa-price {
            font-size: 22px;
            color: #1976A5;
            font-weight: bold;
        }

        /* 🎀 Form nhập thông tin */
        .chiikawa-form label {
            font-weight: bold;
            display: block;
            margin-top: 12px;
            color: #fff;
        }

        .chiikawa-form input {
            width: 90%;
            padding: 10px;
            margin: 8px 0;
            border: 2px solid #5BA8CC;
            border-radius: 12px;
            text-align: center;
            font-size: 16px;
            background: #F0FAFF;
            color: #333;
        }

        .chiikawa-form input:focus {
            outline: none;
            border-color: #2B79A2;
        }

        /* 🎀 Nút dễ thương */
        .chiikawa-button {
            display: inline-block;
            padding: 12px 20px;
            margin-top: 20px;
            background-color: #5BA8CC;
            color: white;
            text-decoration: none;
            border: none;
            border-radius: 25px;
            font-size: 18px;
            font-weight: bold;
            box-shadow: 4px 4px #B3E5FF;
            transition: all 0.3s ease-in-out;
        }

        .chiikawa-button:hover {
            background-color: #1976A5;
            box-shadow: 6px 6px #5BA8CC;
            transform: scale(1.07);
        }

        /* 🎀 Khi giỏ hàng trống */
        .chiikawa-empty-cart {
            font-size: 18px;
            color: #1976A5;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>

    <body>
        <jsp:include page="header.jsp"/>

        <%
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            double totalPrice = 0;
            if (cart != null && !cart.isEmpty()) {
                for (CartItem item : cart) {
                    totalPrice += item.getPrice() * item.getQuantity();
                }
            }
            String message = (String) request.getAttribute("message"); // Lấy thông báo từ request
        %>

        <div class="chiikawa-checkout-container">
            <h2 class="chiikawa-title">🛍️ Thanh Toán 🛍️</h2>

            <% if (message != null) {%>
            <p class="chiikawa-message"><%= message%></p>
            <% } %>

            <% if (cart == null || cart.isEmpty()) { %>
            <p class="chiikawa-empty-cart">Giỏ hàng của bạn đang trống! 🥺</p>
            <a href="MainController?action=search" class="chiikawa-button">🔄 Tiếp tục mua sắm</a>
            <% } else { %>
            <table class="chiikawa-cart-table">
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                </tr>
                <% for (CartItem item : cart) {%>
                <tr>
                    <td><%= item.getTitle()%></td>
                    <td><%= item.getQuantity()%></td>
                    <td><%= item.getPrice() * item.getQuantity()%>đ</td>
                </tr>
                <% }%>
            </table>

            <p class="chiikawa-total">✨ Tổng tiền: <span class="chiikawa-price"><%= totalPrice%>đ</span></p>

            <form action="MainController" method="post" class="chiikawa-form">
                <input type="hidden" name="action" value="checkout">

                <label for="name">📛 Họ và tên:</label>
                <input type="text" id="name" name="name" required>

                <label for="address">🏠 Địa chỉ giao hàng:</label>
                <input type="text" id="address" name="address" required>

                <label for="phone">📞 Số điện thoại:</label>
                <input type="tel" id="phone" name="phone" required pattern="[0-9]{10,11}" title="Nhập số điện thoại hợp lệ (10-11 chữ số)">

                <button type="submit" class="chiikawa-button">💳 Xác nhận thanh toán</button>
            </form>

            <a href="MainController?action=search" class="chiikawa-button">🔄 Quay lại mua sắm</a>
            <% }%>
        </div>

    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
