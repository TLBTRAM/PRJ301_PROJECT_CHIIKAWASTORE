package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;
import utils.AuthUtils;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"assets/images/logo.png\">\r\n");
      out.write("        <title>Chiikawa Land - Login</title>\r\n");
      out.write("        <style>\r\n");
      out.write("            /* Tổng thể */\r\n");
      out.write("            body {\r\n");
      out.write("                font-family: Arial, sans-serif;\r\n");
      out.write("                background-color: #FFFDDE;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Khu vực đăng nhập */\r\n");
      out.write("            .login-container {\r\n");
      out.write("                min-height: 500px;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: center;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                background-color: #FFFDDE;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .login-form {\r\n");
      out.write("                background: white;\r\n");
      out.write("                padding: 30px;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                max-width: 400px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Tiêu đề */\r\n");
      out.write("            .form-title {\r\n");
      out.write("                font-size: 24px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                color: #444;\r\n");
      out.write("                margin-bottom: 20px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Nhóm nhập liệu */\r\n");
      out.write("            .form-group {\r\n");
      out.write("                margin-bottom: 18px;\r\n");
      out.write("                text-align: left;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group label {\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("                color: #555;\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-bottom: 6px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group input {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 12px;\r\n");
      out.write("                border: 2px solid #FFC8D2;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                transition: 0.3s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group input:focus {\r\n");
      out.write("                border-color: #FF6699;\r\n");
      out.write("                outline: none;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Nút đăng nhập */\r\n");
      out.write("            .submit-btn {\r\n");
      out.write("                background: linear-gradient(to right, #FF6699, #FF4081);\r\n");
      out.write("                color: white;\r\n");
      out.write("                padding: 12px 0;\r\n");
      out.write("                border: none;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                transition: 0.3s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .submit-btn:hover {\r\n");
      out.write("                background: linear-gradient(to right, #FF4081, #E65C87);\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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
      out.write("\r\n");
      out.write("    .login-b {\r\n");
      out.write("        background-color: #58C7F4;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 6px;\r\n");
      out.write("        padding: 0.6rem 1.2rem;\r\n");
      out.write("        font-size: 1rem;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        transition: background-color 0.3s, transform 0.2s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login-b:hover {\r\n");
      out.write("        background-color: #0590C9;\r\n");
      out.write("        transform: scale(1.05);\r\n");
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
} else {
      out.write("\r\n");
      out.write("                <a href=\"login.jsp\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Đăng nhập\" class=\"login-b\"/>\r\n");
      out.write("                </a>\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("        <div class=\"login-container\">\r\n");
      out.write("            <div class=\"login-form\">\r\n");
      out.write("                <h2 class=\"form-title\">Đăng nhập</h2>\r\n");
      out.write("                <form action=\"MainController\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"login\" />\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"userId\">Tên đăng nhập</label>\r\n");
      out.write("                        <input type=\"text\" id=\"userId\" name=\"txtUserID\" required />\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"password\">Mật khẩu</label>\r\n");
      out.write("                        <input type=\"password\" id=\"password\" name=\"txtPassword\" required />\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"submit\" class=\"submit-btn\">Đăng nhập</button>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        String message = request.getAttribute("message") + "";
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div style=\"color:red\">\r\n");
      out.write("                        ");
      out.print(message.equals("null") ? "" : message);
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
