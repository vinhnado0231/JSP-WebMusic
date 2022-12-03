<%@ page import="java.util.Calendar" %> <%@ page
        import="java.util.GregorianCalendar" %> <%@ page contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web music</title>
    <link rel="stylesheet" href="./index.css" />
    <link rel="stylesheet" href="./home.css" />
    <link rel="stylesheet" href="./user-avt.css" />
    <link rel="shortcut icon" href="./Media/AVATAR/AVT4.png" type="image/png">
    

    <link
            rel="stylesheet"
            href="./Media/fontawesome-free-6.2.1-web/css/all.min.css"
    />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600&display=swap"
            rel="stylesheet"
    />
</head>
<body>
<div class="container-app">
    <header class="header-app">
        <a href="AccountServlet?action=/" class="container-logo">
            <img src="./Media/logo.png" class="logo-app" />
        </a>
        <nav class="nav-app">
            <a
                    href="AccountServlet?action=/"
                    class= "nav-item <%try {if (session.getAttribute("changePage").equals("home")) {%>
                                active-nav
                            <%}} catch (Exception e) {%>
                                active-nav
                            <%}%>"
            >
                Home
            </a>
            <a
                    href="PlaylistServlet?action=generalPlaylist"
                    class= "nav-item <%try {if (session.getAttribute("changePage").equals("generalPlaylist")) {%>
                                active-nav
                            <%}} catch (Exception e) {}%> "
            >
                General playlist
            </a>

            <%try {if ((boolean) session.getAttribute("checkLogin")) {%>
            <a href="./detail-page.jsp" class="nav-item">
                Your playlist
            </a>
            <%}} catch (Exception e) {%> <%}%>

            <%try {if (!(boolean)
                    session.getAttribute("checkLogin")) {
            %>
            <a
                    href="AccountServlet?action=loginForm"
                    class="login-button"
            >
                Login now
            </a>
            <%} else {%>
            <div class="user-avt-container">
                <a
                        href="AccountServlet?action=logout"
                        class="log-out-container"
                >
                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                </a>
                <img
                        src="./Media/AVATAR/AVT1.png"
                        alt="avt"
                        class="user-avt-img"
                />
            </div>
            <%}} catch (Exception e) {%>
            <a
                    href="AccountServlet?action=loginForm"
                    class="login-button"
            >
                Login now
            </a>
            <%}%>
        </nav>
    </header>
    <div class="app-body">
        <div class="container-sub-info">
            <div class="container-icon-sub-info">
                <i class="fa-brands fa-facebook sub-info-icon"></i>
                <i class="fa-brands fa-twitter sub-info-icon"></i>
                <i class="fa-brands fa-instagram sub-info-icon"></i>
            </div>
            <div class="line-decoration"></div>
            <p class="sub-info-content">Follow</p>
        </div>
        <div class="container-app-content">
            <div class="container-home">
                <p class="title sub-title">
                    Life so beautiful with music
                </p>
                <h1 class="title title-home">Web music for</h1>
                <h2 class="title title-primary">Everybody</h2>
                <a
                        href="PlaylistServlet?action=generalPlaylist"
                        class="home-play-music-container"
                >
                    <i
                            class="fa-regular fa-circle-play icon-play-home"
                    ></i>
                    <p class="home-play-music-text">Play music</p>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>