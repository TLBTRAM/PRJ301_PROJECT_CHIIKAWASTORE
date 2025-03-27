<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="assets/images/logo.png">
        <title>Chiikawa Land</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #FFFDDE;
                text-align: center;
                margin: 0;
                padding: 0;
            }

            img.fullscreen {
                width: 95%; 
                height: auto;
                display: block;
                margin: 0 auto;
                border-radius: 10px; 
            }

            .about-section {
                background-color: #FFA5B0;
                color: #333;
                padding: 30px;
                border-radius: 15px;
                max-width: 900px;
                margin: 40px auto;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
                text-align: left;
                border: 2px solid #e58b94;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .about-section:hover {
                transform: scale(1.02);
                box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
            }

            .about-section h2 {
                background-color: #ffccd3;
                padding: 15px;
                border-radius: 10px;
                font-size: 24px;
                font-weight: bold;
                text-align: center;
                margin-bottom: 20px;
                transition: background-color 0.3s ease;
            }

            .about-section h2:hover {
                background-color: #ffb3be;
            }

            .about-section p {
                font-size: 18px;
                line-height: 1.6;
                padding: 15px;
                background: white;
                border-radius: 10px;
                margin-bottom: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease, box-shadow 0.3s ease;
            }

            .about-section p:hover {
                transform: translateX(5px);
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
            }



        </style> 
    </head>


    <body>
        <%@include file="header.jsp" %>

        <div class="about-section">
            <h2>Chào mừng đến với Chiikawa Land!</h2>
            <p>Chiikawa Land là thiên đường dành cho các fan của Chiikawa !</p>
            <p>Chúng tôi chuyên cung cấp các sản phẩm liên quan đến Chiikawa như văn phòng phẩm, quần áo, phụ kiện và nhiều hơn thế nữa.</p>
            <p>Hãy khám phá bộ sưu tập đáng yêu của chúng tôi và mang về những món đồ Chiikawa yêu thích ngay hôm nay !</p>
        </div>

        <img src="assets/images/chi_pc.jpg" class="fullscreen"/>


        <jsp:include page="footer.jsp"/>
    </body>
</html>
