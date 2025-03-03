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
        height: 80px;
        width: 500px;
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

    .search-bar {
        display: flex;
        align-items: center;
        background: #fff;
        border-radius: 20px;
        padding: 0.5rem 1rem;
    }

    .search-input {
        border: none;
        outline: none;
        padding: 0.2rem;
        width: 200px;
    }

    .search-button {
        background: none;
        border: none;
        cursor: pointer;
        color: #2c3e50;
    }
</style>

<header class="header">
    <%
        int x = 100;
    %>
    <div> 

		<div class="Logo_img"> 
			<img src="assets/images/chiikawa.png" style="height: 100px" />
		</div> 
    <div class="container">
        <nav class="nav">
            <a href="#" class="text_logo">Chiikawa Land</a>

            <ul class="menu">
                <li class="menu-item"><a href="#">Trang chủ</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Sản phẩm</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Giỏ hàng</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Đăng nhập</a></li>
                <li class="menu-item"><a href="#">|</a></li>
                <li class="menu-item"><a href="#">Liên hệ</a></li>
            </ul>
            <div class="search-bar">
                <input type="text" class="search-input" placeholder="Tìm kiếm...">
                <button class="search-button">🔍</button>
            </div>
        </nav>
    </div>
</header>