<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="../app.css" />
        <style>
            .header-app {
                display: flex;
                justify-content: space-between;
                align-items: center;
                font-size: var(--font-s-md-1);
                height: 100%;
                margin-right: var(--spacing-lg);
                color: vaR(--contrast-color);
                overflow: hidden;

            }

            .container-logo {
                width: 200px;
                margin-top: vaR(--spacing-md);
            }

            .logo-app {
                width: 100%;
                object-fit: cover;
            }

            .nav-app {
                display: flex;
                gap: var(--spacing-lg);
                align-items: center;
            }

            .nav-item {
                text-transform: uppercase;
                position: relative;
                text-align: center;
                display: flex;
                justify-content: center;
                text-shadow: 1px 2px 10px black;
            }

            .nav-item::before {
                content: "";
                position: absolute;
                bottom: -3px;
                width: 0;
                border-bottom: 2px solid vaR(--primary-color);
                transition: width 0.1s linear;
            }

            .nav-item:hover.nav-item::before{
                width: 100%;
            }

            .active-nav.nav-item::before {
                width: 100%;
            }

            .login-button {
                padding: var(--spacing-sm) var(--spacing-md);
                margin-left: var(--spacing-md);
                color: white;
                font-size: var(--font-s-md-1);
                border-radius: var(--b-r-mch);
                background-color: var(--primary-color);
                transition: background-color 0.1s ease-out;
            }

            .login-button:hover {
                background-color: var(--primary-dark-color);
            }

        </style>
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
                    href="/AccountServlet?generalPlaylist=1"
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
