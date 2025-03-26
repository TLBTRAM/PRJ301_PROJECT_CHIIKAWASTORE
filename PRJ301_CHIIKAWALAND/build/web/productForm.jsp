<%@page import="utils.AuthUtils"%>
<%@page import="dto.UserDTO"%>
<%@page import="dto.ProductDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land - Product</title>
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #FFFDDE;
                margin: 0;
                padding: 0;
                min-height: 100vh;
            }

            .page-content {
                padding: 40px 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: calc(100vh - 150px); /* Account for header and footer */
            }

            .form-container {
                background-color: white;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                padding: 30px;
                width: 100%;
                max-width: 600px;
                margin: 0 auto;
            }

            h1 {
                color: #2c3e50;
                margin-top: 0;
                margin-bottom: 20px;
                text-align: center;
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: 600;
                color: #333;
            }
            
            select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
                background-color: white;
                transition: border-color 0.3s;
            }

            select:focus {
                border-color: #FFA5B0;
                outline: none;
                box-shadow: 0 0 5px rgba(255, 165, 176, 0.7); 
            }

            input[type="text"],
            input[type="number"],
            textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
                transition: border-color 0.3s;
            }

            input[type="text"]:focus,
            input[type="number"]:focus,
            textarea:focus {
                border-color: #FFA5B0;
                outline: none;
                box-shadow: 0 0 5px rgba(255, 165, 176, 0.7); 
            }

            .error-message {
                color: #e74c3c;
                font-size: 14px;
                margin-top: 5px;
            }


            .button-group {
                display: flex;
                gap: 10px; /* Khoảng cách giữa các nút */
            }

            .btn-save, .btn-reset {
                padding: 12px 24px;
                border: none;
                border-radius: 6px;
                font-size: 16px;
                font-weight: bold;
                cursor: pointer;
                transition: background-color 0.3s, transform 0.2s;
                flex: 1;
                text-transform: uppercase;
            }

            .btn-save {
                background-color: #2ecc71;
                color: white;
            }

            .btn-save:hover {
                background-color: #27ae60;
                transform: scale(1.05);
            }

            .btn-reset {
                background-color: #e74c3c;
                color: white;
            }

            .btn-reset:hover {
                background-color: #c0392b;
                transform: scale(1.05);
            }

            .error-container {
                background-color: #fff0f0;
                border-left: 4px solid #e74c3c;
                padding: 20px;
                border-radius: 4px;
                margin-bottom: 20px;
            }

            .error-container h1 {
                color: #e74c3c;
                margin-top: 0;
            }

            .back-link {
                display: block;
                text-align: center;
                margin-top: 20px;
                color: #3498db;
                text-decoration: none;
            }

            .back-link:hover {
                text-decoration: underline;
            }

            @media (max-width: 768px) {
                .form-container {
                    padding: 20px;
                }

                .button-group {
                    flex-direction: column;
                }

                input[type="submit"], input[type="reset"] {
                    margin: 5px 0;
                }
            }

            .image-preview {
                margin-top: 10px;
                max-width: 100%;
            }

            .image-preview img {
                max-width: 100%;
                max-height: 200px;
                border: 1px solid #ddd;
                border-radius: 4px;
                padding: 5px;
            }

            .success-message {
                background-color: #d4edda;
                color: #155724;
                padding: 10px;
                border-radius: 4px;
                margin-bottom: 15px;
                border-left: 4px solid #28a745;
            }
            
            .upload-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 100%;
                margin-top: 10px;
            }
            
            .file-upload-wrapper {
                position: relative;
                width: 100%;
                height: 40px;
                overflow: hidden;
                margin-bottom: 10px;
            }
            
            .file-upload-input {
                position: absolute;
                top: 0;
                right: 0;
                margin: 0;
                padding: 0;
                font-size: 20px;
                cursor: pointer;
                opacity: 0;
                height: 100%;
                width: 100%;
            }
            
            .file-upload-button {
                width: 100%;
                height: 40px;
                background-color: #FFA5B0;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                display: flex;
                align-items: center;
                justify-content: center;
                font-weight: 600;
            }
            
            .file-upload-button:hover {
                background-color: #2980b9;
            }
            
            .file-info {
                margin-top: 5px;
                font-size: 14px;
                color: #666;
            }
            
            .progress-bar-container {
                width: 100%;
                height: 10px;
                background-color: #f1f1f1;
                border-radius: 5px;
                margin-top: 10px;
                display: none;
            }
            
            .progress-bar {
                height: 100%;
                background-color: #4CAF50;
                border-radius: 5px;
                width: 0%;
                transition: width 0.3s;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="page-content">
            <% if (AuthUtils.isLoggedIn(session)) {
                    UserDTO user = AuthUtils.getUser(session);
                    if (AuthUtils.isAdmin(session)) {

                        
                
                    ProductDTO p = new ProductDTO();
                    if (request.getAttribute("product") == null) {
                        request.setAttribute("product", new ProductDTO());
                        p = new ProductDTO();
                    } else {
                        p = (ProductDTO) request.getAttribute("product");
                    }
                    
                    String action = request.getAttribute("action")+"";
                    if(!action.equals("update")){
                        action="add";
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
                

            %>
            
            <div class="form-container">
                
                <h1 style="display: flex; align-items: center; justify-content: center;">
                    <img src="assets/images/edit.png" style="height: 90px; margin-right: 15px; transform: scaleX(-1);">
                    Products Information
                    <img src="assets/images/edit.png" style="height: 90px; margin-left: 15px;">
                </h1>
                
                <form action="MainController" method="post">
                    <input type="hidden" name="action" value="<%=action%>"/>

                    <div class="form-group">
                        <label for="txtProductID">Product ID:</label>
                        <input type="text" id="txtProductID" name="txtProductID" value="<%= p.getProductID() %>" <%= (p.getProductID() != null && !p.getProductID().isEmpty()) ? "readonly" : "" %> />
                        <% if (!txtProductID_error.isEmpty()) {%>
                        <div class="error-message"><%=txtProductID_error%></div>
                        <% }%>
                    </div>

                    <div class="form-group">
                        <label for="txtTitle">Title:</label>
                        <input type="text" id="txtTitle" name="txtTitle" value="<%=p.getTitle()%>"/>
                        <% if (!txtTitle_error.isEmpty()) {%>
                        <div class="error-message"><%=txtTitle_error%></div>
                        <% }%>
                    </div>

                    <div class="form-group">
                        <label for="txtBrand">Brand:</label>
                        <input type="text" id="txtBrand" name="txtBrand" value="<%=p.getBrand()%>"/>
                    </div>
                    <% if (!txtBrand_error.isEmpty()) {%>
                        <div class="error-message"><%=txtBrand_error%></div>
                    <% }%>
                    
                    <div class="form-group">
                        <label for="txtCategory">Category:</label>
                        <select name="txtCategory" id="txtCategory">
                            <option value=""> Choose... </option>
                            <option value="Clothing" <%= (p != null && "Clothing".equals(p.getCategory())) ? "selected" : "" %>> Clothing </option>
                            <option value="Toys" <%= (p != null && "Toys".equals(p.getCategory())) ? "selected" : "" %>> Toys </option>
                            <option value="Phone Cases" <%= (p != null && "Phone Cases".equals(p.getCategory())) ? "selected" : "" %>> Phone Cases </option>
                            <option value="Stationery" <%= (p != null && "Stationery".equals(p.getCategory())) ? "selected" : "" %>> Stationery </option>
                            <option value="Other" <%= (p != null && "Other".equals(p.getCategory())) ? "selected" : "" %>> Other </option>
                        </select>
                        <% if (txtCategory_error != null && !txtCategory_error.isEmpty()) { %>
                            <div class="error-message"><%=txtCategory_error%></div>
                        <% } %>
                    </div>

                    <div class="form-group">
                        <label for="txtPrice">Price:</label>
                        <input type="number" id="txtPrice" name="txtPrice" value="<%=p.getPrice()%>"/>
                        <% if (!txtPrice_error.isEmpty()) {%>
                        <div class="error-message"><%=txtPrice_error%></div>
                        <% }%>
                    </div>

                    <div class="form-group">
                        <label for="txtQuantity">Quantity:</label>
                        <input type="number" id="txtQuantity" name="txtQuantity" value="<%=p.getQuantity()%>"/>
                        <% if (!txtQuantity_error.isEmpty()) {%>
                        <div class="error-message"><%=txtQuantity_error%></div>
                        <% }%>
                    </div>
                    
                    <div class="form-group">
                        <label for="txtImage">Image:</label>
                        <input type="hidden" id="txtImage" name="txtImage" value="<%= p.getImage() %>"/>

                        <div class="upload-container">
                            <div class="file-upload-wrapper">
                                <button type="button" class="file-upload-button">Choose an Image</button>
                                <input type="file" id="imageUpload" class="file-upload-input" accept="image/*"/>
                            </div>
                            <div class="file-info" id="fileInfo">No file selected</div>
                            <div class="progress-bar-container" id="progressContainer">
                                <div class="progress-bar" id="progressBar"></div>
                            </div>
                        </div>

                        <div class="image-preview" id="imagePreview">
                            <% 
                                String imageUrl = p.getImage();
                                if (imageUrl != null && !imageUrl.isEmpty()) { 
                            %>
                                <img src="<%= imageUrl %>" alt="Product Image"/>
                            <% } %>
                        </div>
                    </div>

                    <div class="button-group">
                        <input type="submit" id="btnSave" class="btn-save" value="Save" />
                        <input type="reset" id="btnReset" class="btn-reset" value="Reset"/>
                    </div>
                        
                </form>
                
                <a href="MainController?action=search" class="back-link">Back to Product List</a>
            </div>
            <%} else {%>
            <div class="form-container error-container">
                <h1>403 Error</h1>
                <p>You do not have permission to access this content!</p>
                <a href="MainController?action=search" class="back-link">Back to Product List</a>
            </div>
            <%}
                } else {%>
            <div class="form-container error-container">
                <h1>Access Denied</h1>
                <p>Please log in to access this page.</p>
                <a href="login.jsp" class="back-link">Go to Login</a>
            </div>
            <%}%>
        </div>

        <jsp:include page="footer.jsp"/>
        
        
        <script>
            // JavaScript để cải thiện trải nghiệm người dùng
            document.addEventListener('DOMContentLoaded', function () {
                // Preview image when URL is entered
                document.getElementById('txtImage').addEventListener('input', function () {
                    const imageUrl = this.value.trim();
                    let previewContainer = document.querySelector('.image-preview');

                    if (!previewContainer) {
                        previewContainer = document.createElement('div');
                        previewContainer.className = 'image-preview';
                        this.parentNode.appendChild(previewContainer);
                    }

                    if (imageUrl) {
                        // Check if it's a URL or base64 data
                        if (imageUrl.startsWith('data:image') || imageUrl.startsWith('http')) {
                            previewContainer.innerHTML = `<img src="${imageUrl}" alt="Preview" onerror="this.src='assets/images/placeholder.png'; this.alt='Image not available';">`;
                        } else {
                            previewContainer.innerHTML = '<p>Enter a valid image URL or base64 data</p>';
                        }
                    } else {
                        previewContainer.innerHTML = '';
                    }
                });
            });
        </script>
        
         <!-- Thêm jQuery từ CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        
        <script>
            $(document).ready(function() {
                // Hiển thị tên file khi chọn file
                $('#imageUpload').change(function() {
                    const file = this.files[0];
                    if (file) {
                        // Kiểm tra xem file có phải là hình ảnh không
                        if (!file.type.match('image.*')) {
                            alert('Please select an image file (JPEG, PNG, GIF, etc.)');
                            this.value = '';
                            $('#fileInfo').text('No file selected');
                            return;
                        }
                        
                        // Hiển thị tên file và kích thước
                        const fileSize = (file.size / 1024).toFixed(2) + ' KB';
                        $('#fileInfo').text(file.name + ' (' + fileSize + ')');
                        
                        // Hiển thị thanh tiến trình và bắt đầu chuyển đổi sang Base64
                        $('#progressContainer').show();
                        
                        // Thiết lập FileReader để đọc file và chuyển đổi sang Base64
                        const reader = new FileReader();
                        
                        reader.onprogress = function(event) {
                            if (event.lengthComputable) {
                                const percentLoaded = Math.round((event.loaded / event.total) * 100);
                                $('#progressBar').css('width', percentLoaded + '%');
                            }
                        };
                        
                        reader.onload = function(e) {
                            // Hoàn thành tiến trình
                            $('#progressBar').css('width', '100%');
                            
                            // Lưu trữ dữ liệu Base64 vào input ẩn
                            const base64String = e.target.result;
                            $('#txtImage').val(base64String);
                            
                            // Hiển thị hình ảnh xem trước
                            $('#imagePreview').html('<img src="' + base64String + '" alt="Preview">');
                            
                            // Ẩn thanh tiến trình sau 1 giây
                            setTimeout(function() {
                                $('#progressContainer').hide();
                                $('#progressBar').css('width', '0%');
                            }, 1000);
                        };
                        
                        reader.onerror = function() {
                            alert('Error reading the file. Please try again.');
                            $('#progressContainer').hide();
                            $('#progressBar').css('width', '0%');
                            $('#fileInfo').text('No file selected');
                        };
                        
                        // Bắt đầu đọc file và chuyển đổi sang Base64
                        reader.readAsDataURL(file);
                    } else {
                        $('#fileInfo').text('No file selected');
                    }
                });
                
                // Xử lý nút Reset
                $('#resetBtn').click(function() {
                    $('#imagePreview').empty();
                    $('#fileInfo').text('No file selected');
                    $('#txtImage').val('');
                    $('#progressContainer').hide();
                    $('#progressBar').css('width', '0%');
                });
                
                  // Để chọn lại file đã tải lên trước đó (nếu có)
                const existingImageSrc = $('#imagePreview img').attr('src');
                if (existingImageSrc) {
                    $('#txtImage').val(existingImageSrc);
                }
            });
        </script>
        
    </body>
</html>