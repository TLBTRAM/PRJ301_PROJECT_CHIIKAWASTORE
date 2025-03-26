<%@page import="utils.AuthUtils"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16WWW">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land</title>

        <style>

            body {
                font-family: Arial, sans-serif;
                background-color: #FFFDDE;
            }

            /* Table Styles */
            .p-table {
                width: 100%;
                border-collapse: collapse; 
                margin: 25px 0;
                font-size: 15px;
                font-family: 'Poppins', sans-serif;
                box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                overflow: hidden;
                background-color: #FFFFFF;
            }

            .p-table thead th {
                background-color: #D7F8AD;
                color: #333;
                text-align: left;
                font-weight: bold;
                padding: 14px 18px;
                text-transform: uppercase;
                border-bottom: 3px solid #B0E57C;
            }

            .p-table tbody tr {
                background-color: #FFFFFF;
                transition: background 0.3s ease-in-out;
            }

            .p-table tbody tr:hover {
                background-color: #f0f0f0;
            }

            .p-table tbody td {
                padding: 14px 18px;
                color: #333;
                border-bottom: 2px solid #D7F8AD; /* Đường kẻ ngang mỏng */
            }

            /* Loại bỏ đường kẻ dưới cùng của bảng */
            .p-table tbody tr:last-child td {
                border-bottom: none;
            }



            /* Search section styles */
            .search-section {
                background-color: #fff;
                border-radius: 8px;
                padding: 20px;
                margin: 20px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
            }

            .search-section form {
                display: flex;
                align-items: center;
                flex-grow: 1;
            }

            .search-section label {
                margin-right: 10px;
                font-weight: bold;
                color: #58C7F4;
            }

            .search-input {
                flex-grow: 1;
                padding: 10px;
                border: 1px;
                border-radius: 4px;
                font-size: 14px;
                margin-right: 10px;
            }

            .search-input:focus {
                border-color: #009879;
                outline: none;
                box-shadow: 0 0 0 2px rgba(0, 152, 121, 0.2);
            }

            .search-btn {
                background-color: #58C7F4;
                color: white;
                border: none;
                border-radius: 4px;
                padding: 10px 15px;
                cursor: pointer;
                font-weight: bold;
                transition: background-color 0.3s;
            }

            .search-btn:hover {
                background-color: #0590C9;
            }

            .view {
                text-align: center;
                margin: 20px 0;
            }

            .view h2 {
                color: #333333;
                font-size: 30px;
                font-family: 'Poppins', sans-serif;
                margin-bottom: 15px;
            }
            
            /* Pagination Controls */
            .pagination {
                margin-top: 20px;
                text-align: center;
            }

            .pagination a {
                padding: 10px 20px; /* Đảm bảo kích thước nút */
                background-color: #FFA5B0;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-weight: bold;
                display: inline-flex;
                align-items: center;
                justify-content: center;
                min-width: 100px; /* Đảm bảo hai nút có cùng độ rộng */
            }

            .pagination a:first-child {
                margin-right: 10px;
            }

            .pagination a:last-child {
                margin-left: 10px;
            }

            .pagination span {
                font-size: 18px;
                font-weight: bold;
                color: #333;
                margin: 0 10px;
            }

            /* Responsive design */
            @media screen and (max-width: 600px) {
                .book-table {
                    font-size: 12px;
                }

                .book-table thead th,
                .book-table tbody td {
                    padding: 8px 10px;
                }
            }
        </style> 
    </head>
    <body> 
        <%@include file="header.jsp" %>
        <div style="min-height: 500px; padding: 10px 20px">

            <%  if (session.getAttribute("user") != null) {
                    UserDTO user = (UserDTO) session.getAttribute("user");
            %>


            <%
                String searchTerm = request.getAttribute("searchTerm") + "";
                searchTerm = searchTerm.equals("null") ? "" : searchTerm;
            %>
            <div class="search-section">
                <form action="MainController">
                    <input type="hidden" name="action" value="search"/>
                    <label for="searchInput">Search Products:</label>
                    <input type="text" id="searchInput" name="searchTerm" value="<%=searchTerm%>" class="search-input" placeholder="Enter product title..."/>
                    <input type="submit" value="Search" class="search-btn"/>
                </form>
            </div>


            <% if (AuthUtils.isAdmin(session)) { %>
            <a href="productForm.jsp" style="display: inline-flex; align-items: center; text-decoration: none; margin-left: 20px; padding: 10px 20px; background-color: #8BF8AD; color: white; border-radius: 5px; font-weight: bold; transition: 0.3s;">
                <img src="assets/images/action/Add.png" style="height: 20px; margin-right: 8px;">
                Add New Product
            </a>
            <% } %>


            <div class="view">
                <img src="assets/images/view.png" alt="Sản phẩm" class="center-image">
                <h2>U U NÀ NÀ Ú NA, U YAHAHA</h2>
            </div>
            
            
            <%
                if (request.getAttribute("products") != null) {
                    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
                    int currentPage = (int) request.getAttribute("currentPage");
                    int totalPages = (int) request.getAttribute("totalPages");
            %>

            <table class="p-table">
                <thead>
                    <tr>
                        <% if (AuthUtils.isAdmin(session)) { %>
                        <th>Mã Sản Phẩm</th>
                        <%}%>
                        <th>Hình</th>
                        <th>Tên sản phẩm</th>
                        <th>Hãng</th>
                        <th>Danh mục</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                            <% if (AuthUtils.isAdmin(session)) { %>
                        <th>Chức năng</th>
                            <%}%>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ProductDTO p : products) {
                    %>
                    <tr>
                        <% if (AuthUtils.isAdmin(session)) {%>
                        <td><%=p.getProductID()%></td>
                        <%}%>
                        <td> <img src="<%=p.getImage()%>" width="150px"/></td>
                        <td><%=p.getTitle()%></td>
                        <td><%=p.getBrand()%></td>
                        <td><%=p.getCategory()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getQuantity()%></td>
                        <%
                            if (AuthUtils.isAdmin(session)) {
                        %>
                        <td>
                            <a href="MainController?action=edit&idEdit=<%=p.getProductID()%>&pageT=<%= currentPage %>&searchTerm=<%= searchTerm %>" style="margin-right: 20px">
                                <img src="assets/images/action/update.png" style="height: 25px"/>
                            </a>

                            <a href="MainController?action=delete&idDelete=<%=p.getProductID()%>&pageT=<%= currentPage %>&searchTerm=<%= searchTerm %>">
                                <img src="assets/images/action/delete.png" style="height: 25px"/>
                            </a>
                        </td>
                        <%}%>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Pagination Controls -->
            <div class="pagination">
                <% if (currentPage > 1) { %>
                    <a href="MainController?action=search&pageT=<%= currentPage - 1 %>&searchTerm=<%= searchTerm %>">Previous</a>
                <% } %>

                <span>Page <%= currentPage %> of <%= totalPages %></span>

                <% if (currentPage < totalPages) { %>
                    <a href="MainController?action=search&pageT=<%= currentPage + 1 %>&searchTerm=<%= searchTerm %>">Next</a>
                <% } %>
            </div>


            <% } %>
            
            
            <%} else { %>
            You do not have permission to access this content.
            <%}%>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>