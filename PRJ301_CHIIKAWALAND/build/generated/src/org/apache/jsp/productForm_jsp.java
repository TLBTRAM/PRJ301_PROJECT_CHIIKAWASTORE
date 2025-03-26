package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.AuthUtils;
import dto.UserDTO;
import dto.ProductDTO;

public final class productForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"assets/images/logo.png\">\r\n");
      out.write("        <title>Chiikawa Land - Add Product</title>\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                font-family: Arial, sans-serif;\r\n");
      out.write("                background-color: #FFFDDE;\r\n");
      out.write("                margin: 0;\r\n");
      out.write("                padding: 0;\r\n");
      out.write("                min-height: 100vh;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            * {\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .page-content {\r\n");
      out.write("                padding: 40px 20px;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: center;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                min-height: calc(100vh - 150px); /* Account for header and footer */\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-container {\r\n");
      out.write("                background-color: white;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("                padding: 30px;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                max-width: 600px;\r\n");
      out.write("                margin: 0 auto;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            h1 {\r\n");
      out.write("                color: #2c3e50;\r\n");
      out.write("                margin-top: 0;\r\n");
      out.write("                margin-bottom: 20px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .form-group {\r\n");
      out.write("                margin-bottom: 15px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            label {\r\n");
      out.write("                display: block;\r\n");
      out.write("                margin-bottom: 5px;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("                color: #333;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"text\"],\r\n");
      out.write("            input[type=\"number\"] {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                border: 1px solid #ddd;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                transition: border-color 0.3s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"text\"]:focus,\r\n");
      out.write("            input[type=\"number\"]:focus {\r\n");
      out.write("                border-color: #3498db;\r\n");
      out.write("                outline: none;\r\n");
      out.write("                box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .error-message {\r\n");
      out.write("                color: #e74c3c;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                margin-top: 5px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .button-group {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: space-between;\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            button, input[type=\"submit\"], input[type=\"reset\"] {\r\n");
      out.write("                padding: 10px 20px;\r\n");
      out.write("                border: none;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                font-weight: 600;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                transition: background-color 0.3s;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"submit\"] {\r\n");
      out.write("                background-color: #2ecc71;\r\n");
      out.write("                color: white;\r\n");
      out.write("                flex: 1;\r\n");
      out.write("                margin-right: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"submit\"]:hover {\r\n");
      out.write("                background-color: #27ae60;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"reset\"] {\r\n");
      out.write("                background-color: #e74c3c;\r\n");
      out.write("                color: white;\r\n");
      out.write("                flex: 1;\r\n");
      out.write("                margin-left: 10px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            input[type=\"reset\"]:hover {\r\n");
      out.write("                background-color: #c0392b;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .error-container {\r\n");
      out.write("                background-color: #fff0f0;\r\n");
      out.write("                border-left: 4px solid #e74c3c;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("                border-radius: 4px;\r\n");
      out.write("                margin-bottom: 20px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .error-container h1 {\r\n");
      out.write("                color: #e74c3c;\r\n");
      out.write("                margin-top: 0;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .back-link {\r\n");
      out.write("                display: block;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                margin-top: 20px;\r\n");
      out.write("                color: #3498db;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            .back-link:hover {\r\n");
      out.write("                text-decoration: underline;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            @media (max-width: 768px) {\r\n");
      out.write("                .form-container {\r\n");
      out.write("                    padding: 20px;\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("                .button-group {\r\n");
      out.write("                    flex-direction: column;\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("                input[type=\"submit\"], input[type=\"reset\"] {\r\n");
      out.write("                    margin: 5px 0;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"page-content\">\r\n");
      out.write("            ");
 if (AuthUtils.isLoggedIn(session)) {
                    UserDTO user = AuthUtils.getUser(session);
                    if (AuthUtils.isAdmin(session)) {

                        
                ProductDTO p = new ProductDTO();
                try {
                    p = (ProductDTO) request.getAttribute("product");
                } catch (Exception e) {
                    p = new ProductDTO();
                }
                if (p == null) {
                    p = new ProductDTO();
                }
                // Get error information
                String txtProductID_error = request.getAttribute("txtProductID_error") + "";
                txtProductID_error = txtProductID_error.equals("null") ? "" : txtProductID_error;
                
                String txtTitle_error = request.getAttribute("txtTitle_error") + "";
                txtTitle_error = txtTitle_error.equals("null") ? "" : txtTitle_error;
                
                String txtBrand_error = request.getAttribute("txtBrand_error") + "";
                txtBrand_error = txtBrand_error.equals("null") ? "" : txtBrand_error;
                
                String txtCategory_error = request.getAttribute("txtCategory_error") + "";
                txtCategory_error = txtCategory_error.equals("null") ? "" : txtCategory_error;
                
                String txtPrice_error = request.getAttribute("txtPrice_error") + "";
                txtPrice_error = txtPrice_error.equals("null") ? "" : txtPrice_error;
                
                String txtQuantity_error = request.getAttribute("txtQuantity_error") + "";
                txtQuantity_error = txtQuantity_error.equals("null") ? "" : txtQuantity_error;
                

            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"form-container\">\r\n");
      out.write("                <h1>Products Information</h1>\r\n");
      out.write("                <form action=\"MainController\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"add\"/>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtProductID\">Product ID:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtProductID\" name=\"txtProductID\" value=\"");
      out.print(p.getProductID());
      out.write("\"/>\r\n");
      out.write("                        ");
 if (!txtProductID_error.isEmpty()) {
      out.write("\r\n");
      out.write("                        <div class=\"error-message\">");
      out.print(txtProductID_error);
      out.write("</div>\r\n");
      out.write("                        ");
 }
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtTitle\">Title:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtTitle\" name=\"txtTitle\" value=\"");
      out.print(p.getTitle());
      out.write("\"/>\r\n");
      out.write("                        ");
 if (!txtTitle_error.isEmpty()) {
      out.write("\r\n");
      out.write("                        <div class=\"error-message\">");
      out.print(txtTitle_error);
      out.write("</div>\r\n");
      out.write("                        ");
 }
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtBrand\">Brand:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"txtBrand\" name=\"txtBrand\" value=\"");
      out.print(p.getBrand());
      out.write("\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
 if (!txtBrand_error.isEmpty()) {
      out.write("\r\n");
      out.write("                        <div class=\"error-message\">");
      out.print(txtBrand_error);
      out.write("</div>\r\n");
      out.write("                    ");
 }
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"txtCategory\">Category:</label>\r\n");
      out.write("                    <select name=\"txtCategory\" id=\"txtCategory\">\r\n");
      out.write("                        <option value=\"0\"> Choose... </option>\r\n");
      out.write("                        <option value=\"1\"> Quiz </option>\r\n");
      out.write("                        <option value=\"2\"> Midterm </option>\r\n");
      out.write("                        <option value=\"3\"> Final </option>\r\n");
      out.write("                        <option value=\"4\"> Final </option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                    ");
 if (!txtCategory_error.isEmpty()) { 
      out.write("\r\n");
      out.write("                        <div class=\"error-message\">");
      out.print(txtCategory_error);
      out.write("</div>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtPrice\">Price:</label>\r\n");
      out.write("                        <input type=\"number\" id=\"txtPrice\" name=\"txtPrice\" value=\"");
      out.print(p.getPrice());
      out.write("\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtQuantity\">Quantity:</label>\r\n");
      out.write("                        <input type=\"number\" id=\"txtQuantity\" name=\"txtQuantity\" value=\"");
      out.print(p.getQuantity());
      out.write("\"/>\r\n");
      out.write("                        ");
 if (!txtQuantity_error.isEmpty()) {
      out.write("\r\n");
      out.write("                        <div class=\"error-message\">");
      out.print(txtQuantity_error);
      out.write("</div>\r\n");
      out.write("                        ");
 }
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"txtImage\">Book Cover Image:</label>\r\n");
      out.write("                        <input type=\"hidden\" id=\"txtImage\" name=\"txtImage\" value=\"");
      out.print(p.getImage());
      out.write("\"/>\r\n");
      out.write("                        <div class=\"upload-container\">\r\n");
      out.write("                            <div class=\"file-upload-wrapper\">\r\n");
      out.write("                                <button type=\"button\" class=\"file-upload-button\">Choose an Image</button>\r\n");
      out.write("                                <input type=\"file\" id=\"imageUpload\" class=\"file-upload-input\" accept=\"image/*\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"file-info\" id=\"fileInfo\">No file selected</div>\r\n");
      out.write("                            <div class=\"progress-bar-container\" id=\"progressContainer\">\r\n");
      out.write("                                <div class=\"progress-bar\" id=\"progressBar\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.txtImage_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <div class=\"error-message\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.txtImage_error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                        </c:if>\r\n");
      out.write("                        <div class=\"image-preview\" id=\"imagePreview\">\r\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty book.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("                            </c:if>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"button-group\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Save\" />\r\n");
      out.write("                        <input type=\"reset\" value=\"Reset\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                \r\n");
      out.write("                <a href=\"MainController?action=search\" class=\"back-link\">Back to Product List</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
} else {
      out.write("\r\n");
      out.write("            <div class=\"form-container error-container\">\r\n");
      out.write("                <h1>403 Error</h1>\r\n");
      out.write("                <p>You do not have permission to access this content!</p>\r\n");
      out.write("                <a href=\"MainController?action=search\" class=\"back-link\">Back to Product List</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}
                } else {
      out.write("\r\n");
      out.write("            <div class=\"form-container error-container\">\r\n");
      out.write("                <h1>Access Denied</h1>\r\n");
      out.write("                <p>Please log in to access this page.</p>\r\n");
      out.write("                <a href=\"login.jsp\" class=\"back-link\">Go to Login</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            // JavaScript để cải thiện trải nghiệm người dùng\r\n");
      out.write("            document.addEventListener('DOMContentLoaded', function () {\r\n");
      out.write("                // Preview image when URL is entered\r\n");
      out.write("                document.getElementById('txtImage').addEventListener('input', function () {\r\n");
      out.write("                    const imageUrl = this.value.trim();\r\n");
      out.write("                    let previewContainer = document.querySelector('.image-preview');\r\n");
      out.write("\r\n");
      out.write("                    if (!previewContainer) {\r\n");
      out.write("                        previewContainer = document.createElement('div');\r\n");
      out.write("                        previewContainer.className = 'image-preview';\r\n");
      out.write("                        this.parentNode.appendChild(previewContainer);\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    if (imageUrl) {\r\n");
      out.write("                        // Check if it's a URL or base64 data\r\n");
      out.write("                        if (imageUrl.startsWith('data:image') || imageUrl.startsWith('http')) {\r\n");
      out.write("                            previewContainer.innerHTML = `<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imageUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Preview\" onerror=\"this.src='assets/images/placeholder.png'; this.alt='Image not available';\">`;\r\n");
      out.write("                        } else {\r\n");
      out.write("                            previewContainer.innerHTML = '<p>Enter a valid image URL or base64 data</p>';\r\n");
      out.write("                        }\r\n");
      out.write("                    } else {\r\n");
      out.write("                        previewContainer.innerHTML = '';\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("         <!-- Thêm jQuery từ CDN -->\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                // Hiển thị tên file khi chọn file\r\n");
      out.write("                $('#imageUpload').change(function() {\r\n");
      out.write("                    const file = this.files[0];\r\n");
      out.write("                    if (file) {\r\n");
      out.write("                        // Kiểm tra xem file có phải là hình ảnh không\r\n");
      out.write("                        if (!file.type.match('image.*')) {\r\n");
      out.write("                            alert('Please select an image file (JPEG, PNG, GIF, etc.)');\r\n");
      out.write("                            this.value = '';\r\n");
      out.write("                            $('#fileInfo').text('No file selected');\r\n");
      out.write("                            return;\r\n");
      out.write("                        }\r\n");
      out.write("                        \r\n");
      out.write("                        // Hiển thị tên file và kích thước\r\n");
      out.write("                        const fileSize = (file.size / 1024).toFixed(2) + ' KB';\r\n");
      out.write("                        $('#fileInfo').text(file.name + ' (' + fileSize + ')');\r\n");
      out.write("                        \r\n");
      out.write("                        // Hiển thị thanh tiến trình và bắt đầu chuyển đổi sang Base64\r\n");
      out.write("                        $('#progressContainer').show();\r\n");
      out.write("                        \r\n");
      out.write("                        // Thiết lập FileReader để đọc file và chuyển đổi sang Base64\r\n");
      out.write("                        const reader = new FileReader();\r\n");
      out.write("                        \r\n");
      out.write("                        reader.onprogress = function(event) {\r\n");
      out.write("                            if (event.lengthComputable) {\r\n");
      out.write("                                const percentLoaded = Math.round((event.loaded / event.total) * 100);\r\n");
      out.write("                                $('#progressBar').css('width', percentLoaded + '%');\r\n");
      out.write("                            }\r\n");
      out.write("                        };\r\n");
      out.write("                        \r\n");
      out.write("                        reader.onload = function(e) {\r\n");
      out.write("                            // Hoàn thành tiến trình\r\n");
      out.write("                            $('#progressBar').css('width', '100%');\r\n");
      out.write("                            \r\n");
      out.write("                            // Lưu trữ dữ liệu Base64 vào input ẩn\r\n");
      out.write("                            const base64String = e.target.result;\r\n");
      out.write("                            $('#txtImage').val(base64String);\r\n");
      out.write("                            \r\n");
      out.write("                            // Hiển thị hình ảnh xem trước\r\n");
      out.write("                            $('#imagePreview').html('<img src=\"' + base64String + '\" alt=\"Preview\">');\r\n");
      out.write("                            \r\n");
      out.write("                            // Ẩn thanh tiến trình sau 1 giây\r\n");
      out.write("                            setTimeout(function() {\r\n");
      out.write("                                $('#progressContainer').hide();\r\n");
      out.write("                                $('#progressBar').css('width', '0%');\r\n");
      out.write("                            }, 1000);\r\n");
      out.write("                        };\r\n");
      out.write("                        \r\n");
      out.write("                        reader.onerror = function() {\r\n");
      out.write("                            alert('Error reading the file. Please try again.');\r\n");
      out.write("                            $('#progressContainer').hide();\r\n");
      out.write("                            $('#progressBar').css('width', '0%');\r\n");
      out.write("                            $('#fileInfo').text('No file selected');\r\n");
      out.write("                        };\r\n");
      out.write("                        \r\n");
      out.write("                        // Bắt đầu đọc file và chuyển đổi sang Base64\r\n");
      out.write("                        reader.readAsDataURL(file);\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $('#fileInfo').text('No file selected');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                // Xử lý nút Reset\r\n");
      out.write("                $('#resetBtn').click(function() {\r\n");
      out.write("                    $('#imagePreview').empty();\r\n");
      out.write("                    $('#fileInfo').text('No file selected');\r\n");
      out.write("                    $('#txtImage').val('');\r\n");
      out.write("                    $('#progressContainer').hide();\r\n");
      out.write("                    $('#progressBar').css('width', '0%');\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                  // Để chọn lại file đã tải lên trước đó (nếu có)\r\n");
      out.write("                const existingImageSrc = $('#imagePreview img').attr('src');\r\n");
      out.write("                if (existingImageSrc) {\r\n");
      out.write("                    $('#txtImage').val(existingImageSrc);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
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
