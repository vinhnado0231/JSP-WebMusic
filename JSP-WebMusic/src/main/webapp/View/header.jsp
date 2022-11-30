<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="./header2.css" />
        <link rel="stylesheet" href="../app.css" />
    </head>
    <body>
        <header class="header-app">
            <div class="container-logo">
                <img src="../Media/logo.png" class="logo-app" />
            </div>
            <nav class="nav-app">
                <a
                    href="./home.jsp"
                    target="main-content"
                    class="nav-item active-nav"
                >
                    Home
                </a>
                <a
                    href="./general-playlist.jsp"
                    target="main-content"
                    class="nav-item"
                >
                    General playlist
                </a>
                <a
                    href="./detail-page.jsp"
                    target="main-content"
                    class="nav-item"
                >
                    Your playlist
                </a>
                <a
                    href="./loginform.jsp"
                    target="main-content"
                    class="login-button"
                >
                    Login now
                </a>
            </nav>
        </header>
    </body>
</html>
