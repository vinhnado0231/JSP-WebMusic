<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.Song" %>
<%@ page import="model.bean.Playlist" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="./general-playlist2.css" />
        <link rel="stylesheet" href="./index.css" />
        <link
            rel="stylesheet"
            href="../Media/fontawesome-free-6.2.1-web/css/all.min.css"
        />
    </head>
    <body>
        <div class="container-app">
            <header class="header-app">
                <div class="container-logo">
                    <img src="./Media/logo.png" class="logo-app" />
                </div>
                <nav class="nav-app">
                    <a href="./home.jsp" class="nav-item active-nav"> Home </a>
                    <a href="./general-playlist.jsp" class="nav-item">
                        General playlist
                    </a>
                    <a href="./detail-page.jsp" class="nav-item">
                        Your playlist
                    </a>
                    <a href="./loginform.jsp" class="login-button">
                        Login now
                    </a>
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
                    <div class="general-playlist-container">
                        <h2 class="general-playlist-title">General playlist</h2>
                        <div class="general-playlist-content">
                            <ul class="general-playlist">
                                <li class="general-playlist-add-song">
                                    <a
                                        href="./add-form.jsp"
                                        class="add-song-container"
                                    >
                                        <div class="overplay-add-song">
                                            <i
                                                class="fa-solid fa-plus icon-play-playlist"
                                            ></i>
                                        </div>
                                    </a>
                                </li>
                                <% ArrayList<Playlist> playlist = (ArrayList<Playlist>) session.getAttribute("allPlaylist");
                                        for(int i=0;i<playlist.size();i++){


                                %>
                                <li class="general-playlist-song">
                                    <a
                                        href="./detail-page.jsp"
                                        class="general-playlist-link-song"
                                    >
                                        <div
                                            class="general-playlist-song-img-container"
                                        >
                                            <div class="overplay-song">
                                                <i
                                                    class="fa-regular fa-circle-play icon-play-playlist"
                                                ></i>
                                                <p class="home-play-music-text">
                                                    Play music
                                                </p>
                                            </div>
                                            <img

                                                src="<%=playlist.get(i).getTarget()%>"
                                                alt=""
                                                class="general-playlist-img"
                                            />
                                        </div>
                                        <div class="general-playlist-song-info">
                                            <h2
                                                class="general-playlist-song-title"
                                            >
                                                <%=playlist.get(i).getNameList()%>
                                            </h2>
                                            <p
                                                class="general-playlist-song-author"
                                            >
                                                <%=playlist.get(i).getIdUser()%>
                                            </p>
                                            <p
                                                class="general-playlist-song-time"
                                            >
                                                <%=playlist.get(i).getIdList()%>
                                            </p>
                                        </div>
                                    </a>
                                    <a
                                        href="./edit-form.jsp"
                                        class="button-song"
                                    >
                                        Edit
                                    </a>
                                </li>
                               <%  }%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
