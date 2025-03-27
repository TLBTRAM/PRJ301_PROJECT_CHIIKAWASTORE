<%@page import="dto.UserDTO"%>
<%@page import="utils.AuthUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .header {
        background-color: #FFD0D8;
        padding: 15px;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
    }


    .container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 0 1rem;
    }

    .nav {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .text_logo {
        color: #010409;
        font-family: 'Baloo', sans-serif;
        font-size: 1.5rem;
        font-weight: bold;
        text-decoration: none;
    }

    .Logo_img img{
        width: 600px;
        height: auto;
        align-items: center;

    }
    .menu {
        display: flex;
        list-style: none;
        gap: 2rem;
    }

    .menu-item a {
        color: #010409;
        text-decoration: none;
        font-size: 1rem;
        transition: color 0.3s ease;
    }

    .menu-item a:hover {
        color: #3498db;
    }

    /* Styles for welcome and login logout */
    .user-section {
        display: flex;
        align-items: center;
        gap: 1rem;
        margin-left: 1.5rem;
    }

    .welcome-text {
        color: #000000;
        font-size: 0.95rem;
    }

    .user-name {
        color: #58C7F4;
        font-weight: bold;
    }

    .logout-btn {
        background-color: #e74c3c;
        color: white;
        border: none;
        border-radius: 6px;
        padding: 0.6rem 1.2rem;
        font-size: 1rem;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    .logout-btn:hover {
        background-color: #c0392b;
        transform: scale(1.05);
    }

    .login-b {
        background-color: #58C7F4;
        color: white;
        border: none;
        border-radius: 6px;
        padding: 0.6rem 1.2rem;
        font-size: 1rem;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    .login-b:hover {
        background-color: #0590C9;
        transform: scale(1.05);
    }

    /*Audio*/
    .audioContainer {
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 15px; /* Khoảng cách giữa các phần tử */
        padding: 20px 0;
        position: relative; /* Giữ nó dưới các thành phần khác */
        width: 100%;
        bottom: 0;
    }

    .audioButton {
        background-color: #FFFFFF;
        color: #58C7F4;
        font-size: 16px;
        cursor: pointer;
        border-radius: 10px; /* Bo góc đồng đều */
        border: none;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 0; /* Loại bỏ padding để không ảnh hưởng kích thước */
        height: 70px;
        width: 70px;
    }

    .audioButton:hover {
        background-color: #0590C9;
    }

    .audioGif {
        height: 70px;
        width: auto;
        border-radius: 10px; /* Bo góc */
        object-fit: cover; /* Đảm bảo ảnh không bị méo */
    }

</style>

<header class="header">

    <div class="Logo_img"> 
        <img src="assets/images/chiikawa.png"/>
    </div> 


    <div class="container">
        <nav class="nav">
            <a href="UIlogin.jsp" class="text_logo">Chiikawa Land</a>

            <ul class="menu">
                <li class="menu-item"><a href="#">Trang chủ</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Sản phẩm</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Danh mục</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Giỏ hàng</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Liên hệ</a></li>
            </ul>
            <%  if (AuthUtils.isLoggedIn(session)) {
                    UserDTO userHeader = AuthUtils.getUser(session);
            %>
            <div class="user-section">
                <span class="welcome-text">Xin chào, <span class="user-name"><%=userHeader.getFullName()%></span>!</span>
                <form action="MainController" method="post" style="margin: 0;">
                    <input type="hidden" name="action" value="logout"/>
                    <input type="submit" value="Đăng xuất" class="logout-btn"/>
                </form>
            </div>
            <%} else {%>
            <a href="register.jsp">
                <input type="submit" value="Đăng ký" class="login-b"/>
            </a>
            <a href="login.jsp">
                <input type="submit" value="Đăng nhập" class="login-b"/>
            </a>
            <% }%>   
        </nav>

    </div>


    <audio id="myAudio">
        <source src="assets/music/song.mp3" type="audio/mpeg">
    </audio>


    <div class="audioContainer">
        <button class="audioButton" onclick="playAudio()">▶</button>
        <img class="audioGif" src="assets/music/dance.gif">
        <button class="audioButton" onclick="pauseAudio()">⏸</button>
    </div>


    <script>
        var audio = document.getElementById("myAudio");

        function playAudio() {
            audio.play();
        }

        function pauseAudio() {
            audio.pause();
        }
    </script>

</header>