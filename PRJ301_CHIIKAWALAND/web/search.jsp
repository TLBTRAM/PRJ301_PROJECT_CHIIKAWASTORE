<%-- 
    Document   : search
    Created on : 04-03-2025, 01:06:25
    Author     : Admin
--%>

<%@page import="utils.AuthUtils"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16WWW">
        <title>JSP Page</title>

        <style>
            .shelf {
                width: 100%;
                border-collapse: collapse;
                margin: 25px 0;
                font-size: 14px;
                font-family: Arial, sans-serif;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            }

            .shelf thead th {
                background-color: #009879;
                color: #ffffff;
                text-align: left;
                font-weight: bold;
                padding: 12px 15px;
            }

            .shelf tbody tr {
                border-bottom: 1px solid #dddddd;
            }

            .shelf tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }

            .shelf tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }

            .shelf tbody td {
                padding: 12px 15px;
            }

            .shelf tbody tr:hover {
                background-color: #f5f5f5;
                transition: 0.3s ease;
            }

            /* Search section styles */
            .search-section {
                background-color: #fff;
                border-radius: 8px;
                padding: 20px;
                margin-bottom: 20px;
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
                color: #333;
            }

            .search-input {
                flex-grow: 1;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 14px;
                margin-right: 10px;
                transition: border-color 0.3s;
            }

            .search-input:focus {
                border-color: #009879;
                outline: none;
                box-shadow: 0 0 0 2px rgba(0, 152, 121, 0.2);
            }

            .search-btn {
                background-color: #009879;
                color: white;
                border: none;
                border-radius: 4px;
                padding: 10px 15px;
                cursor: pointer;
                font-weight: bold;
                transition: background-color 0.3s;
            }

            .search-btn:hover {
                background-color: #00806a;
            }

            /* Add button styles */
            .add-btn {
                display: inline-block;
                background-color: #007bff;
                color: white;
                text-decoration: none;
                border-radius: 4px;
                padding: 10px 15px;
                margin-bottom: 20px;
                font-weight: bold;
                transition: background-color 0.3s;
            }

            .add-btn:hover {
                background-color: #0069d9;
                text-decoration: none;
            }

            /* Add a nice icon to the add button */
            .add-btn::before {
                content: "+";
                margin-right: 5px;
                font-weight: bold;
            }

            /* Responsive design */
            @media screen and (max-width: 600px) {
                .shelf {
                    font-size: 12px;
                }

                .shelf thead th,
                .shelf tbody td {
                    padding: 8px 10px;
                }
            }
        </style> 
    </head>
    <body> 
        <%@include file="header.jsp" %>
        <div style="min-height: 500px; padding: 10px">
            <%                if (session.getAttribute("user") != null) {
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
                    <input type="text" id="searchInput" name="searchTerm" value="<%=searchTerm%>" class="search-input" placeholder="Enter book title, author or ID..."/>
                    <input type="submit" value="Search" class="search-btn"/>
                </form>
            </div>
            <% if (AuthUtils.isAdmin(session)) {
            %>
            <a href="bookForm.jsp" class="add-btn">
                Add New Products    
            </a> 
            <%}%>

            <%
                if (request.getAttribute("products") != null) {
                    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");

            %>
            <table class="shelf">
                <thead>
                    <tr>
                        <th>Mã hiệu</th>
                        <th>Tên sản phẩm</th>
                        <th>Hãng</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <% if (AuthUtils.isAdmin(session)) {
                            %>
                        <th>Action</th>
                            <%}%>
                    </tr>
                </thead>
                <tbody>
                    <%            for (ProductDTO pdto : products) {
                    %>
                    <tr>
                        <td><%=pdto.getProductID()%></td>
                        <td><%=pdto.getTitle()%></td>
                        <td><%=pdto.getBrand()%></td>
                        <td><%=pdto.getPrice()%></td>
                        <td><%=pdto.getQuantity()%></td>
                        <% 
                            if (AuthUtils.isAdmin(session)) {
                        %>
                        <td><a href="MainController?action=delete&id=<%=pdto.getProductID()%>&searchTerm=<%=searchTerm%>">
                                <img src="assets/images/delete-icon.png" style="height: 25px"/>

                            </a></td>

                        <%}%>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%    }
            } else { %>
            You do not have permission to access this content.
            <%}%>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>