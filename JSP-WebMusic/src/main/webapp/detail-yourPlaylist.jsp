<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.Song" %>
<%@ page import="model.bean.Playlist" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./general-playlist5.css" />
    <link rel="stylesheet" href="./index.css" />
    <link rel="stylesheet" href="./user-avt.css">
    <link
            rel="stylesheet"
            href="../Media/fontawesome-free-6.2.1-web/css/all.min.css"
    />
    <link rel="shortcut icon" href="./Media/AVATAR/logo.png" type="logo/png">
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
            <div class="general-playlist-container">
                <h2 class="general-playlist-title"><%=((Playlist)session.getAttribute("playlistNow")).getNameList()%></h2>
                <div class="general-playlist-content">
                    <ul class="general-playlist">

                        <% ArrayList<Song> playlistSong = (ArrayList<Song>) session.getAttribute("playlistSong");
                            for(int i=0;i<playlistSong.size();i++){


                        %>
                        <li class="general-playlist-song">
                            <a
                                    href="PlaylistServlet?action=detailPage&&idSongNow=<%=playlistSong.get(i).getIdSong()%>"
                            <%--                      href="PlaylistServlet?action=detailPage&&idSongNow=<%=playlistSong.get(i).getIdSong()%>"--%>
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

                                            src="<%=playlistSong.get(i).getTarget()%>"
                                            alt=""
                                            class="general-playlist-img"
                                    />
                                </div>
                                <div class="general-playlist-song-info">
                                    <h2
                                            class="general-playlist-song-title"
                                    >
                                        <%=playlistSong.get(i).getTenBaiHat()%>
                                    </h2>
                                    <p
                                            class="general-playlist-song-author"
                                    >
                                        <%=playlistSong.get(i).getCaSi()%>
                                    </p>
                                    <p
                                            class="general-playlist-song-time"
                                    >
                                        <%=playlistSong.get(i).getThoiGian()%>
                                    </p>
                                </div>
                            </a>
                            <a
                                    href="PlaylistServlet?action=deleteDetailList&&idDel=<%=playlistSong.get(i).getIdSong()%>"
                                    class="button-song"
                            >
                                Delete
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
