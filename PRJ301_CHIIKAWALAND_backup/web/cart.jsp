<%@page import="dto.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Cart</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFFDDE;
            color: #444;
            text-align: center;
        }

        /* 🌸 Khung giỏ hàng */
        .chiikawa-cart-container {
            padding: 20px;
            background: #ffebf0;
            border: 4px solid #ff8fab; /* Viền hồng dễ thương */
            border-radius: 20px;
            max-width: 800px;
            margin: 30px auto;
            box-shadow: 5px 5px 15px rgba(255, 105, 180, 0.3);
        }

        /* 🌟 Tiêu đề giỏ hàng */
        .chiikawa-title {
            color: #ff4d6d;
            font-size: 36px; /* To hơn để dễ đọc */
            font-weight: bold;
            text-shadow: 3px 3px #ffd1dc;
            margin-bottom: 15px;
        }

        /* 🛍️ Bảng giỏ hàng */
        .chiikawa-cart-table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        .chiikawa-cart-table th, 
        .chiikawa-cart-table td {
            padding: 12px;
            border-bottom: 2px dashed #ffb6c1;
            text-align: center;
        }

        .chiikawa-cart-table th {
            background-color: #ffafcc; /* Màu header đậm hơn */
            color: white;
            font-size: 20px;
            font-weight: bold;
        }

        .chiikawa-cart-table td {
            font-size: 18px;
        }

        /* 🛒 Khi giỏ hàng trống */
        .chiikawa-empty-cart {
            font-size: 20px;
            color: #ff6f91;
            font-weight: bold;
            margin-top: 20px;
        }

        /* 💖 Nút bấm dễ thương */
        .chiikawa-button {
            display: inline-block;
            padding: 12px 20px;
            margin-top: 15px;
            background: linear-gradient(45deg, #ff85a2, #ff4d6d);
            color: white;
            text-decoration: none;
            border-radius: 20px;
            font-size: 20px;
            font-weight: bold;
            box-shadow: 3px 3px 10px rgba(255, 105, 180, 0.4);
            transition: all 0.3s ease-in-out;
        }

        .chiikawa-button:hover {
            background: linear-gradient(45deg, #ff4d6d, #ff85a2);
            box-shadow: 5px 5px #ffcbde;
            transform: scale(1.05);
        }

        /* 🎀 Tổng tiền trong giỏ hàng */
        .chiikawa-total {
            margin-top: 15px;
            padding: 12px;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background: #FFAFCC; /* Màu nền pastel hồng dễ thương */
            border-radius: 12px;
            display: inline-block;
            box-shadow: 3px 3px #ff8fab;
            text-shadow: 1px 1px #ff7eb3;
        }

        .chiikawa-price {
            font-size: 22px;
            color: #fff;
            font-weight: bold;
        }

    </style>
    <body>
        <jsp:include page="header.jsp"/>


        <%
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        %>
        <div class="chiikawa-cart-container">
            <h2 class="chiikawa-title">🎀 Giỏ hàng của bạn nè 🎀</h2>

            <% if (cart != null && !cart.isEmpty()) { %>
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
                <% } %>
            </table>

            <%
                double totalPrice = 0;
                for (CartItem item : cart) {
                    totalPrice += item.getPrice() * item.getQuantity();
                }
            %>

            <div class="chiikawa-total">
                <strong>Tổng tiền: </strong> <span class="chiikawa-price"><%= totalPrice%>đ</span>
            </div>
            <br>

            <a href="MainController?action=search" class="chiikawa-button">Tiếp tục mua sắm 🛍️</a>
            <a href="checkout.jsp" class="chiikawa-button">Thanh toán 💕</a>


            <% } else { %>
            <p class="chiikawa-empty-cart">Giỏ của bạn rỗng. 🥺</p>
            <a href="MainController?action=search" class="chiikawa-button">Về Trang Chủ 🏡</a>
            <% } %>
            
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
