<%@page import="utils.AuthUtils"%>
<%@page import="dto.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Product Detail</title>
        <style>
            * {
                box-sizing: border-box;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            }

            body {
                background-color: #FFFDDE;
                margin: 0;
                padding: 0;
                min-height: 100vh;
            }

            .page-content {
                padding: 40px 20px;
                max-width: 1200px;
                margin: 0 auto;
                min-height: calc(100vh - 150px); /* Account for header and footer */
            }

            /* Breadcrumb - Chiikawa Style */
            .breadcrumb {
                margin-bottom: 20px;
                color: #ff9aa2;
                font-size: 14px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .breadcrumb a {
                color: #ff6392;
                text-decoration: none;
            }

            .breadcrumb a:hover {
                text-decoration: underline;
                color: #ff85a2;
            }

            /* Message Containers - Soft Pastel Colors */
            .message-container {
                padding: 15px;
                border-radius: 10px;
                margin-bottom: 20px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
                box-shadow: 0 3px 10px rgba(255, 182, 193, 0.3);
            }

            .message-container.success {
                background-color: #ffdfdf;
                color: #ff6b6b;
                border-left: 5px solid #ff9aa2;
            }

            .message-container.error {
                background-color: #ffd6e0;
                color: #ff3b6b;
                border-left: 5px solid #ff6392;
            }

            .message-container.info {
                background-color: #fff0f5;
                color: #ff4d8b;
                border-left: 5px solid #ff85a2;
            }

            /* Book Detail Container - Cute and Soft */
            .book-detail-container {
                background-color: #fffaf0;
                border-radius: 12px;
                box-shadow: 0 4px 15px rgba(255, 182, 193, 0.4);
                display: flex;
                overflow: hidden;
                animation: fadeIn 0.6s ease-out;
                margin-bottom: 30px;
                border: 2px dashed #ffb6c1;
                padding: 10px;
            }

            @keyframes fadeIn {
                from { opacity: 0; transform: translateY(10px); }
                to { opacity: 1; transform: translateY(0); }
            }

            @media (max-width: 768px) {
                .book-detail-container {
                    flex-direction: column;
                    text-align: center;
                }
            }

            /* Breadcrumb - Chiikawa Style */
            .breadcrumb {
                margin-bottom: 20px;
                color: #ff9aa2;
                font-size: 14px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .breadcrumb a {
                color: #ff6392;
                text-decoration: none;
            }

            .breadcrumb a:hover {
                text-decoration: underline;
                color: #ff85a2;
            }

            /* Message Containers - Soft Pastel Colors */
            .message-container {
                padding: 15px;
                border-radius: 10px;
                margin-bottom: 20px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
                box-shadow: 0 3px 10px rgba(255, 182, 193, 0.3);
            }

            .message-container.success {
                background-color: #ffdfdf;
                color: #ff6b6b;
                border-left: 5px solid #ff9aa2;
            }

            .message-container.error {
                background-color: #ffd6e0;
                color: #ff3b6b;
                border-left: 5px solid #ff6392;
            }

            .message-container.info {
                background-color: #fff0f5;
                color: #ff4d8b;
                border-left: 5px solid #ff85a2;
            }

            /* Book Detail Container - Cute and Soft */
            .book-detail-container {
                background-color: #fffaf0;
                border-radius: 12px;
                box-shadow: 0 4px 15px rgba(255, 182, 193, 0.4);
                display: flex;
                overflow: hidden;
                animation: fadeIn 0.6s ease-out;
                margin-bottom: 30px;
                border: 2px dashed #ffb6c1;
                padding: 10px;
            }

            @keyframes fadeIn {
                from { opacity: 0; transform: translateY(10px); }
                to { opacity: 1; transform: translateY(0); }
            }

            @media (max-width: 768px) {
                .book-detail-container {
                    flex-direction: column;
                    text-align: center;
                }
            }

            /* Book Image - Chiikawa Style */
            .book-image {
                flex: 0 0 300px;
                background-color: #ffe6e9;
                display: flex;
                align-items: center;
                justify-content: center;
                padding: 20px;
                border-radius: 10px;
            }

            @media (max-width: 768px) {
                .book-image {
                    flex: 0 0 auto;
                }
            }

            .book-cover {
                width: 100%;
                max-height: 400px;
                object-fit: contain;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(255, 182, 193, 0.4);
                transition: transform 0.3s ease;
            }

            .book-cover:hover {
                transform: scale(1.05);
            }

            .no-image {
                width: 100%;
                height: 400px;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #ffd6e0;
                color: #ff85a2;
                font-style: italic;
                border-radius: 10px;
            }

            /* Book Info Section - Soft Pastel Theme */
            .book-info {
                flex: 1;
                padding: 30px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .book-info h1 {
                color: #ff6392;
                margin-top: 0;
                margin-bottom: 15px;
                font-size: 28px;
                line-height: 1.3;
            }

            .book-meta {
                margin-bottom: 25px;
                color: #ff85a2;
                font-size: 16px;
                border-bottom: 1px solid #ffb6c1;
                padding-bottom: 15px;
            }

            .book-meta p {
                margin: 5px 0;
            }

            /* Price Block - Cute and Colorful */
            .book-price-block {
                display: flex;
                align-items: center;
                margin-bottom: 20px;
            }

            .price {
                font-weight: 700;
                font-size: 24px;
                color: #ff4d8b;
                margin-right: 15px;
            }

            .stock-info {
                font-size: 14px;
                font-weight: 600;
                padding: 6px 12px;
                border-radius: 20px;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .in-stock {
                background-color: #ffdfdf;
                color: #ff6b6b;
            }

            .out-of-stock {
                background-color: #ffd6e0;
                color: #ff3b6b;
            }


            /* Book Details - Chiikawa Style */
            .book-details {
                margin-bottom: 25px;
            }

            .detail-item {
                display: flex;
                margin-bottom: 10px;
                align-items: center;
            }

            .label {
                flex: 0 0 150px;
                font-weight: 600;
                color: #ff6392;
            }

            .value {
                flex: 1;
                color: #ff85a2;
            }

            /* Quantity Selector - Cute and Soft */
            .quantity-selector {
                display: flex;
                align-items: center;
                margin-bottom: 20px;
            }

            .quantity-selector label {
                margin-right: 15px;
                font-weight: 600;
                color: #ff6392;
            }

            .quantity-control {
                display: flex;
                align-items: center;
            }

            .quantity-btn {
                width: 36px;
                height: 36px;
                background-color: #ffdfdf;
                border: none;
                font-size: 18px;
                cursor: pointer;
                display: flex;
                align-items: center;
                justify-content: center;
                transition: background-color 0.2s, transform 0.2s;
                border-radius: 50%;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .quantity-btn:hover {
                background-color: #ffb6c1;
                transform: scale(1.1);
            }

            .quantity-control input {
                width: 50px;
                height: 36px;
                text-align: center;
                border: 2px solid #ffb6c1;
                font-size: 16px;
                padding: 0;
                border-radius: 8px;
                background-color: #fffaf0;
            }

            /* Cart Form */
            .cart-form {
                margin-bottom: 20px;
            }

            /* Action Buttons - Pastel and Playful */
            .action-buttons {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                margin-bottom: 20px;
            }

            .btn {
                padding: 12px 24px;
                border: none;
                border-radius: 10px;
                font-size: 16px;
                font-weight: 600;
                cursor: pointer;
                text-decoration: none;
                display: inline-flex;
                align-items: center;
                justify-content: center;
                transition: background-color 0.3s, transform 0.2s;
                font-family: 'Comic Sans MS', cursive, sans-serif;
            }

            .btn:hover {
                transform: translateY(-3px);
            }

            .btn-primary {
                background-color: #ff85a2;
                color: white;
            }

            .btn-primary:hover {
                background-color: #ff6392;
            }

            .btn-secondary {
                background-color: #ffdfdf;
                color: #ff4d8b;
            }

            .btn-secondary:hover {
                background-color: #ffb6c1;
            }

            .btn-danger {
                background-color: #ff6b6b;
                color: white;
            }

            .btn-danger:hover {
                background-color: #ff3b6b;
            }

            .add-to-cart, .buy-now {
                flex: 1;
            }

            .icon {
                margin-right: 8px;
            }

            /* Out of Stock Message - Cute Style */
            .out-of-stock-message {
                background-color: #fffaf0;
                padding: 15px;
                border-radius: 10px;
                margin-bottom: 20px;
                border-left: 5px solid #ffb6c1;
                color: #ff4d8b;
            }

            .notify-btn {
                margin-top: 10px;
            }

            /* Customer Actions - Playful Links */
            .customer-actions {
                display: flex;
                gap: 20px;
                margin-top: 10px;
            }

            .action-link {
                background: none;
                border: none;
                color: #ff6392;
                cursor: pointer;
                font-size: 14px;
                display: flex;
                align-items: center;
                padding: 5px 0;
            }

            .action-link:hover {
                text-decoration: underline;
                color: #ff4d8b;
            }


            /* Additional Info Tabs - Chiikawa Style */
            .additional-info {
                background-color: #fff8f0;
                border-radius: 12px;
                box-shadow: 0 4px 12px rgba(255, 182, 193, 0.3);
                margin-bottom: 30px;
                overflow: hidden;
            }

            .info-tabs {
                display: flex;
                border-bottom: 2px solid #ffccd5;
            }

            .tab-btn {
                padding: 15px 20px;
                background: none;
                border: none;
                font-size: 16px;
                font-weight: 600;
                cursor: pointer;
                position: relative;
                color: #ff6b81;
                transition: color 0.3s ease-in-out;
                font-family: "Nunito", sans-serif;
            }

            .tab-btn:hover, .tab-btn.active {
                color: #ff3b6b;
            }

            .tab-btn.active:after {
                content: '';
                position: absolute;
                bottom: -2px;
                left: 0;
                right: 0;
                height: 3px;
                background-color: #ff3b6b;
                border-radius: 5px;
            }

            .tab-content {
                padding: 20px;
                background-color: #fff0f6;
                border-radius: 10px;
            }

            .tab-pane {
                display: none;
            }

            .tab-pane.active {
                display: block;
                animation: fadeIn 0.3s ease-out;
            }

            .tab-pane h2 {
                color: #ff3b6b;
                margin-top: 0;
            }

            /* Product Details Table */
            .details-table {
                width: 100%;
                border-collapse: collapse;
                font-family: "Poppins", sans-serif;
            }

            .details-table th, .details-table td {
                padding: 12px;
                text-align: left;
                border-bottom: 2px solid #ffccd5;
            }

            .details-table th {
                color: #ff6b81;
                font-weight: 700;
            }

            /* Reviews Section */
            .reviews-container {
                padding: 10px 0;
            }

            /* Related Books Section */
            .related-books {
                margin-bottom: 40px;
            }

            .related-books h2 {
                color: #ff3b6b;
                margin-bottom: 20px;
            }

            .related-books-slider {
                display: flex;
                gap: 20px;
                overflow-x: auto;
                padding: 10px 0 20px;
            }

            .related-book-placeholder {
                flex: 0 0 180px;
                background-color: #fff0f6;
                padding: 15px;
                border-radius: 12px;
                box-shadow: 0 2px 8px rgba(255, 182, 193, 0.3);
            }

            .book-cover-placeholder {
                height: 180px;
                background-color: #ffccd5;
                border-radius: 10px;
                margin-bottom: 10px;
            }

            .book-title-placeholder, .book-author-placeholder {
                height: 14px;
                background-color: #ffccd5;
                border-radius: 10px;
            }

            /* Error Container */
            .error-container {
                background-color: #ffe4e1;
                border-left: 6px solid #ff3b6b;
                padding: 30px;
                border-radius: 12px;
                margin-bottom: 20px;
                text-align: center;
                box-shadow: 0 2px 12px rgba(255, 182, 193, 0.3);
                animation: fadeIn 0.5s ease-out;
            }

            .error-container h1 {
                color: #ff3b6b;
                margin-top: 0;
            }

            /* Modal Styles */
            .modal-content {
                background-color: #fff0f6;
                border-radius: 12px;
                padding: 30px;
                width: 90%;
                max-width: 500px;
                box-shadow: 0 4px 20px rgba(255, 182, 193, 0.3);
            }

            .modal-close {
                font-size: 24px;
                color: #ff6b81;
                cursor: pointer;
                transition: color 0.2s;
            }

            .modal-close:hover {
                color: #ff3b6b;
            }

            .modal-success .success-icon {
                background-color: #ff6b81;
            }

            /* Share Options */
            .share-btn {
                border-radius: 10px;
                font-weight: 700;
            }

            .share-btn.facebook { background-color: #ff6b81; }
            .share-btn.twitter { background-color: #ff3b6b; }
            .share-btn.email { background-color: #ffccd5; }
            .share-btn.link { background-color: #ff85a2; }


            /* Admin Bar - Chiikawa Style */
            .admin-bar {
                position: fixed;
                bottom: 0;
                left: 0;
                right: 0;
                background-color: #ffdfdf;
                color: #5b5b5b;
                z-index: 90;
                padding: 12px 0;
                border-radius: 12px 12px 0 0;
                box-shadow: 0 -2px 8px rgba(0, 0, 0, 0.1);
                font-family: 'Poppins', sans-serif;
            }

            .admin-bar-container {
                max-width: 1200px;
                margin: 0 auto;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 0 20px;
            }

            .admin-message {
                font-weight: 700;
                font-size: 16px;
            }

            .admin-actions {
                display: flex;
                gap: 10px;
            }

            .admin-btn {
                padding: 10px 18px;
                background-color: #ffb6c1;
                color: white;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-weight: 700;
                text-decoration: none;
                transition: background-color 0.3s, transform 0.2s;
            }

            .admin-btn:hover {
                background-color: #ff99aa;
                transform: translateY(-2px);
            }

            /* Responsive Adjustments */
            @media (max-width: 500px) {
                .admin-bar-container {
                    flex-direction: column;
                    gap: 10px;
                    text-align: center;
                }
            }

            /* Loading Spinner - Chiikawa Style */
            .loading-spinner {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(255, 223, 223, 0.8);
                display: flex;
                align-items: center;
                justify-content: center;
                z-index: 9999;
            }

            .spinner {
                width: 50px;
                height: 50px;
                border: 5px solid #ffeff1;
                border-radius: 50%;
                border-top: 5px solid #ff99aa;
                animation: spin 1s linear infinite;
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }

            /* Notification Toast - Chiikawa Style */
            .toast {
                position: fixed;
                top: 20px;
                right: 20px;
                padding: 12px 20px;
                background-color: #ffb6c1;
                color: white;
                border-radius: 12px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
                z-index: 1000;
                font-weight: 700;
                display: none;
                animation: toastFadeIn 0.3s, toastFadeOut 0.3s 2s forwards;
            }

            @keyframes toastFadeIn {
                from { opacity: 0; transform: translateY(-20px); }
                to { opacity: 1; transform: translateY(0); }
            }

            @keyframes toastFadeOut {
                from { opacity: 1; transform: translateY(0); }
                to { opacity: 0; transform: translateY(-20px); }
            }

            /* Cute Button Effects */
            .admin-btn:active {
                transform: scale(0.95);
            }

            /* Read More Button */
            .read-more-btn {
                background: none;
                border: none;
                color: #ff99aa;
                font-weight: 700;
                cursor: pointer;
                margin-top: 10px;
                font-family: 'Poppins', sans-serif;
            }

            .read-more-btn:hover {
                text-decoration: underline;
            }

            /* Tab Animation */
            @keyframes fadeInTab {
                from { opacity: 0; transform: translateY(10px); }
                to { opacity: 1; transform: translateY(0); }
            }

            .tab-pane.active {
                animation: fadeInTab 0.3s ease-out;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="page-content">

            <% if (request.getAttribute("message") != null) {%>
            <div class="message-container <%= request.getAttribute("messageType")%>">
                <p><%= request.getAttribute("message")%></p>
            </div>
            <% } %>

            <% ProductDTO product = (ProductDTO) request.getAttribute("productDetail"); %>
            <% if (product == null) { %>
            <div class="error-container">
                <h1>Product Not Found</h1>
                <p>The product you are looking for does not exist or has been removed.</p>
                <a href="MainController?action=search" class="back-link">Return to Product List</a>
            </div>
            <% } else { %>

            <div class="book-detail-container">
                <div class="book-image">
                    <% if (product.getImage() != null && !product.getImage().isEmpty()) {%>
                    <img src="<%= product.getImage()%>" alt="<%= product.getTitle()%>" class="book-cover">
                    <% } else { %>
                    <div class="no-image">
                        <span>No Image Available</span>
                    </div>
                    <% }%>
                </div>

                <div class="book-info">
                    <h1><%= product.getTitle()%></h1>
                    <div class="book-meta">
                        <p class="author">Hãng : <strong><%= product.getBrand()%></strong></p>
                        <p class="publish-year">Danh mục : <strong><%= product.getCategory()%></strong></p>
                    </div>

                    <div class="book-price-block">
                        <span class="price"><%= product.getPrice()%>đ</span>
                        <% if (product.getQuantity() > 0) { %>
                        <span class="stock-info in-stock">Còn hàng</span>
                        <% } else { %>
                        <span class="stock-info out-of-stock">Hết hàng</span>
                        <% }%>
                    </div>

                    <div class="book-details">
                        <% if (AuthUtils.isAdmin(session)) {%>
                        <div class="detail-item">
                            <span class="label">Mã sản phẩm :</span>
                            <span class="value"><%= product.getProductID()%></span>
                        </div>
                        <% }%>
                        <div class="detail-item">
                            <span class="label">Số lượng có sẵn :</span>
                            <span class="value"><%= product.getQuantity()%></span>
                        </div>
                    </div>

                    <% if (product.getQuantity() > 0) {%>
                    <form action="MainController" method="post" class="cart-form">
                        <input type="hidden" name="action" value="addToCart">
                        <input type="hidden" name="productID" value="<%= product.getProductID()%>">

                        <div class="quantity-selector">
                            <label for="quantity">Số lượng :</label>
                            <div class="quantity-control">
                                <button type="button" class="quantity-btn minus" id="decreaseQty">-</button>
                                <input type="number" id="quantity" name="quantity" value="1" min="1" max="<%= product.getQuantity()%>">
                                <button type="button" class="quantity-btn plus" id="increaseQty">+</button>
                            </div>
                        </div>

                        <div class="action-buttons">
                            <button type="submit" class="btn btn-primary add-to-cart">
                                <span class="icon">🍡</span> Thêm vào giỏ hàng
                            </button>
                            <button type="button" class="btn btn-secondary buy-now" id="buyNowBtn">
                                <span class="icon">💕</span> Mua ngay
                            </button>
                        </div>
                    </form>
                    <% } else { %>
                    <div class="out-of-stock-message">
                        <p>Sorry, this product is currently out of stock.</p>
                        <button type="button" class="btn btn-secondary notify-btn">
                            Notify Me When Available
                        </button>
                    </div>
                    <% } %>
                </div>
            </div>
            <% } %>

            <% if (AuthUtils.isAdmin(session)) {%>
            <div class="admin-bar">
                <div class="admin-bar-container">
                    <span class="admin-message">Bạn đã đăng nhập với tư cách là Quản trị viên</span>
                    <div class="admin-actions">
                        <a href="MainController?action=edit&idEdit=<%= product.getProductID()%>" class="admin-btn">Chỉnh sửa sản phẩm</a>
                        <a href="MainController?action=delete&idDelete=<%=product.getProductID()%>" class="admin-btn">Xóa sản phẩm</a>
                    </div>
                </div>
            </div>


            <% }%>
        </div>

        <jsp:include page="footer.jsp"/>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="assets/js/detail.js"></script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const decreaseBtn = document.getElementById("decreaseQty");
                const increaseBtn = document.getElementById("increaseQty");
                const quantityInput = document.getElementById("quantity");

                decreaseBtn.addEventListener("click", function () {
                    let currentValue = parseInt(quantityInput.value);
                    let minValue = parseInt(quantityInput.min);
                    if (currentValue > minValue) {
                        quantityInput.value = currentValue - 1;
                    }
                });

                increaseBtn.addEventListener("click", function () {
                    let currentValue = parseInt(quantityInput.value);
                    let maxValue = parseInt(quantityInput.max);
                    if (currentValue < maxValue) {
                        quantityInput.value = currentValue + 1;
                    }
                });
            });


            document.addEventListener("DOMContentLoaded", function () {
                document.getElementById("buyNowBtn").addEventListener("click", function () {
                    let quantity = document.getElementById("quantity").value;
                    let productId = document.querySelector("input[name='productId']").value;

                    let form = document.createElement("form");
                    form.method = "POST";
                    form.action = "MainController";

                    let actionInput = document.createElement("input");
                    actionInput.type = "hidden";
                    actionInput.name = "action";
                    actionInput.value = "buyNow";

                    let productIdInput = document.createElement("input");
                    productIdInput.type = "hidden";
                    productIdInput.name = "productId";
                    productIdInput.value = productId;

                    let quantityInput = document.createElement("input");
                    quantityInput.type = "hidden";
                    quantityInput.name = "quantity";
                    quantityInput.value = quantity;

                    form.appendChild(actionInput);
                    form.appendChild(productIdInput);
                    form.appendChild(quantityInput);
                    document.body.appendChild(form);
                    form.submit();
                });
            });

        </script>
    </body>
</html>
