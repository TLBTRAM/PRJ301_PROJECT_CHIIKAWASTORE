package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.AuthUtils;
import dto.ProductDTO;
import java.util.List;
import dto.UserDTO;
import dto.UserDTO;
import utils.AuthUtils;

public final class dashBoard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-16WWW\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"assets/images/logo.png\">\r\n");
      out.write("        <title>Chiikawa Land</title>\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("\r\n");
      out.write("            body {\r\n");
      out.write("                font-family: Arial, sans-serif;\r\n");
      out.write("                background-color: #FFFDDE;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Table Styles */\r\n");
      out.write("            .p-table {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                border-collapse: collapse; \r\n");
      out.write("                margin: 25px 0;\r\n");
      out.write("                font-size: 15px;\r\n");
      out.write("                font-family: 'Poppins', sans-serif;\r\n");
      out.write("                box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\r\n");
      out.write("                border-radius: 10px;\r\n");
      out.write("                overflow: hidden;\r\n");
      out.write("                background-color: #FFFFFF;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .p-table thead th {\r\n");
      out.write("                background-color: #D7F8AD;\r\n");
      out.write("                color: #333;\r\n");
      out.write("                text-align: left;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                padding: 14px 18px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                border-bottom: 3px solid #B0E57C;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .p-table tbody tr {\r\n");
      out.write("                background-color: #FFFFFF;\r\n");
      out.write("                transition: background 0.3s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .p-table tbody tr:hover {\r\n");
      out.write("                background-color: #f0f0f0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .p-table tbody td {\r\n");
      out.write("                padding: 14px 18px;\r\n");
      out.write("                color: #333;\r\n");
      out.write("                border-bottom: 2px solid #D7F8AD; /* Đường kẻ ngang mỏng */\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Loại bỏ đường kẻ dưới cùng của bảng */\r\n");
      out.write("            .p-table tbody tr:last-child td {\r\n");
      out.write("                border-bottom: none;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            /* Search section styles */\r\n");
      out.write("            .search-section {\r\n");
      out.write("                background-color: #fff;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("                margin: 20px;\r\n");
      out.write("                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n");
      out.write("                display: flex;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-section form {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                flex-grow: 1;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-section label {\r\n");
      out.write("                margin-right: 10px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                color: #58C7F4;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-input {\r\n");
      out.write("                flex-grow: 1;\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                border: 1px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                margin-right: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-input:focus {\r\n");
      out.write("                border-color: #009879;\r\n");
      out.write("                outline: none;\r\n");
      out.write("                box-shadow: 0 0 0 2px rgba(0, 152, 121, 0.2);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-btn {\r\n");
      out.write("                background-color: #58C7F4;\r\n");
      out.write("                color: white;\r\n");
      out.write("                border: none;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                padding: 10px 15px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                transition: background-color 0.3s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .search-btn:hover {\r\n");
      out.write("                background-color: #0590C9;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .view {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                margin: 20px 0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .view h2 {\r\n");
      out.write("                color: #333333;\r\n");
      out.write("                font-size: 30px;\r\n");
      out.write("                font-family: 'Poppins', sans-serif;\r\n");
      out.write("                margin-bottom: 15px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Responsive design */\r\n");
      out.write("            @media screen and (max-width: 600px) {\r\n");
      out.write("                .book-table {\r\n");
      out.write("                    font-size: 12px;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                .book-table thead th,\r\n");
      out.write("                .book-table tbody td {\r\n");
      out.write("                    padding: 8px 10px;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </style> \r\n");
      out.write("    </head>\r\n");
      out.write("    <body> \r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    * {\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .header {\r\n");
      out.write("        background-color: #FFD0D8;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        font-size: 24px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        max-width: 1200px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        padding: 0 1rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .nav {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: space-between;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .text_logo {\r\n");
      out.write("        color: #010409;\r\n");
      out.write("        font-family: 'Baloo', sans-serif;\r\n");
      out.write("        font-size: 1.5rem;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .Logo_img img{\r\n");
      out.write("        height: 80px;\r\n");
      out.write("        width: 500px;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    .menu {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        list-style: none;\r\n");
      out.write("        gap: 2rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu-item a {\r\n");
      out.write("        color: #010409;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        font-size: 1rem;\r\n");
      out.write("        transition: color 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .menu-item a:hover {\r\n");
      out.write("        color: #3498db;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /* Styles for welcome and login logout */\r\n");
      out.write("    .user-section {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        gap: 1rem;\r\n");
      out.write("        margin-left: 1.5rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .welcome-text {\r\n");
      out.write("        color: #000000;\r\n");
      out.write("        font-size: 0.95rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .user-name {\r\n");
      out.write("        color: #58C7F4;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logout-btn {\r\n");
      out.write("        background-color: #e74c3c;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        padding: 0.4rem 0.8rem;\r\n");
      out.write("        font-size: 0.85rem;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        transition: background-color 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logout-btn:hover {\r\n");
      out.write("        background-color: #c0392b;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .login-b {\r\n");
      out.write("        background-color: #58C7F4;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        padding: 0.4rem 0.8rem;\r\n");
      out.write("        font-size: 0.85rem;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        transition: background-color 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-b:hover {\r\n");
      out.write("        background-color: #0590C9;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<header class=\"header\">\r\n");
      out.write("    ");


    
      out.write("\r\n");
      out.write("    <div> \r\n");
      out.write("\r\n");
      out.write("        <div class=\"Logo_img\"> \r\n");
      out.write("            <img src=\"assets/images/chiikawa.png\" style=\"height: 100px\" />\r\n");
      out.write("        </div> \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <nav class=\"nav\">\r\n");
      out.write("                <a href=\"#\" class=\"text_logo\">Chiikawa Land</a>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"menu\">\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">Trang chủ</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">|</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">Sản phẩm</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">|</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">Giỏ hàng</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">|</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">Đăng nhập</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">|</a></li>\r\n");
      out.write("                    <li class=\"menu-item\"><a href=\"#\">Liên hệ</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                ");
  if (AuthUtils.isLoggedIn(session)) {
                        UserDTO userHeader = AuthUtils.getUser(session);
                
      out.write("\r\n");
      out.write("                <div class=\"user-section\">\r\n");
      out.write("                    <span class=\"welcome-text\">Xin chào, <span class=\"user-name\">");
      out.print(userHeader.getFullName());
      out.write("</span>!</span>\r\n");
      out.write("                    <form action=\"MainController\" method=\"post\" style=\"margin: 0;\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"logout\"/>\r\n");
      out.write("                        <input type=\"submit\" value=\"Đăng xuất\" class=\"logout-btn\"/>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}else{
      out.write("\r\n");
      out.write("                    <a href=\"login.jsp\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Đăng nhập\" class=\"login-b\"/>\r\n");
      out.write("                    </a>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("        <div style=\"min-height: 500px; padding: 10px 20px\">\r\n");
      out.write("\r\n");
      out.write("            ");
  if (session.getAttribute("user") != null) {
                    UserDTO user = (UserDTO) session.getAttribute("user");
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");

                String searchTerm = request.getAttribute("searchTerm") + "";
                searchTerm = searchTerm.equals("null") ? "" : searchTerm;
            
      out.write("\r\n");
      out.write("            <div class=\"search-section\">\r\n");
      out.write("                <form action=\"MainController\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"search\"/>\r\n");
      out.write("                    <label for=\"searchInput\">Search Products:</label>\r\n");
      out.write("                    <input type=\"text\" id=\"searchInput\" name=\"searchTerm\" value=\"");
      out.print(searchTerm);
      out.write("\" class=\"search-input\" placeholder=\"Enter product title...\"/>\r\n");
      out.write("                    <input type=\"submit\" value=\"Search\" class=\"search-btn\"/>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
 if (AuthUtils.isAdmin(session)) { 
      out.write("\r\n");
      out.write("            <a href=\"productForm.jsp\" style=\"display: inline-flex; align-items: center; text-decoration: none; margin-left: 20px; padding: 10px 20px; background-color: #8BF8AD; color: white; border-radius: 5px; font-weight: bold; transition: 0.3s;\">\r\n");
      out.write("                <img src=\"assets/images/action/Add.png\" style=\"height: 20px; margin-right: 8px;\">\r\n");
      out.write("                Add New Product\r\n");
      out.write("            </a>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"view\">\r\n");
      out.write("                <img src=\"assets/images/view.png\" alt=\"Sản phẩm\" class=\"center-image\">\r\n");
      out.write("                <h2>U U NÀ NÀ Ú NA, U YAHAHA</h2>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");

                if (request.getAttribute("products") != null) {
                    List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");

                    // Xác định trang hiện tại (default = 1)
                    int pageTable = 1;
                    int pageSize = 10; // Số sản phẩm trên mỗi trang
                    int totalProducts = products.size();
                    int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

                    if (request.getParameter("pageTable") != null) {
                        pageTable = Integer.parseInt(request.getParameter("pageTable"));
                    }

                    // Tính toán chỉ số bắt đầu và kết thúc
                    int startIndex = (pageTable - 1) * pageSize;
                    int endIndex = Math.min(startIndex + pageSize, totalProducts);

                    // Lấy danh sách con từ products
                    List<ProductDTO> pageProducts = products.subList(startIndex, endIndex);
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <table class=\"p-table\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        ");
 if (AuthUtils.isAdmin(session)) { 
      out.write("\r\n");
      out.write("                        <th>Mã hiệu</th>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        <th>Hình</th>\r\n");
      out.write("                        <th>Tên sản phẩm</th>\r\n");
      out.write("                        <th>Hãng</th>\r\n");
      out.write("                        <th>Danh mục</th>\r\n");
      out.write("                        <th>Giá</th>\r\n");
      out.write("                        <th>Số lượng</th>\r\n");
      out.write("                            ");
 if (AuthUtils.isAdmin(session)) { 
      out.write("\r\n");
      out.write("                        <th>Chức năng</th>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");

                        for (ProductDTO p : pageProducts) {
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        ");
 if (AuthUtils.isAdmin(session)) {
      out.write("\r\n");
      out.write("                        <td>");
      out.print(p.getProductID());
      out.write("</td>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                        <td> <img src=\"");
      out.print(p.getImage());
      out.write("\" width=\"150px\"/></td>\r\n");
      out.write("                        <td>");
      out.print(p.getTitle());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(p.getBrand());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(p.getCategory());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(p.getPrice());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(p.getQuantity());
      out.write("</td>\r\n");
      out.write("                        ");

                            if (AuthUtils.isAdmin(session)) {
                        
      out.write("\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <a href=\"MainController?action=edit&id=");
      out.print(p.getProductID());
      out.write("&page=");
      out.print(page);
      out.write("&searchTerm=");
      out.print(searchTerm);
      out.write("\" style=\"margin-right: 20px\">\r\n");
      out.write("                                <img src=\"assets/images/action/update.png\" style=\"height: 25px\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("\r\n");
      out.write("                            <a href=\"MainController?action=delete&id=");
      out.print(p.getProductID());
      out.write("&page=");
      out.print(page);
      out.write("&searchTerm=");
      out.print(searchTerm);
      out.write("\">\r\n");
      out.write("                                <img src=\"assets/images/action/delete.png\" style=\"height: 25px\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            <!-- Pagination Controls -->\r\n");
      out.write("            <div style=\"margin-top: 20px; text-align: center;\">\r\n");
      out.write("                ");
 if (pageTable > 1) {
      out.write("\r\n");
      out.write("                <a href=\"?pageTable=");
      out.print( pageTable - 1);
      out.write("\">Previous</a>\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                Page ");
      out.print( pageTable);
      out.write(" of ");
      out.print( totalPages);
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");
 if (pageTable < totalPages) {
      out.write("\r\n");
      out.write("                <a href=\"?pageTable=");
      out.print( pageTable + 1);
      out.write("\">Next</a>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            ");
} else { 
      out.write("\r\n");
      out.write("            You do not have permission to access this content.\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
