<%@ page import="model.bean.Song" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bo.PlaylistBO" %>
<%@ page import="model.bean.Playlist" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="detail-page6.css" />
        <link rel="stylesheet" href="./index.css" />
        <link rel="stylesheet" href="./user-avt.css" />
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link
            rel="shortcut icon"
            href="images/favicon.ico"
            type="image/x-icon"
        />

        <link
            rel="stylesheet"
            href="../Media/fontawesome-free-6.2.1-web/css/all.min.css"
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
                    <a href="./detail-page.jsp" class="nav-item <%try {if (session.getAttribute("changePage").equals("yourPlaylist")) {%>
                                active-nav
                            <%}} catch (Exception e) {}%>/">
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
                    <%Song songNow = (Song) session.getAttribute("songNow");%>
                    <div style="display: none;" class="container-index-song"><%=songNow.getIdSong()-1%></div>
                    <div class="detail-page-container">
                        <div class="detail-page-container-player">
                            <div class="wrapper">
                                <div class="details">
                                    <div class="track-art">
                                        <img src="" alt="track-art" class="track-art-img">
                                    </div>
                                    <div class="track-name">Track Name</div>
                                    <div class="track-artist">Track Artist</div>
                                </div>

                                <div class="slider_container">
                                    <div class="current-time">00:00</div>
                                    <input
                                        type="range"
                                        min="1"
                                        max="100"
                                        value="0"
                                        class="seek_slider"
                                        onchange="seekTo()"
                                    />
                                    <div class="total-duration">00:00</div>
                                </div>

                                <div class="slider_container">
                                    <i class="fa fa-volume-down"></i>
                                    <input
                                        type="range"
                                        min="1"
                                        max="100"
                                        value="99"
                                        class="volume_slider"
                                        onchange="setVolume()"
                                    />
                                    <i class="fa fa-volume-up"></i>
                                </div>

                                <div class="buttons">
                                    <div
                                        class="detail-song-icon random-track"
                                        onclick=""
                                    >
                                        <i
                                            class="fas fa-random fa-2x"
                                            title="random"
                                        ></i>
                                    </div>
                                    <div
                                        class="detail-song-icon prev-track"
                                        onclick=""
                                    >
                                        <i
                                            class="fa fa-step-backward fa-2x"
                                        ></i>
                                    </div>
                                    <div
                                        class="detail-song-icon playpause-track"
                                        onclick="playpauseTrack()"
                                    >
                                        <i class="fa fa-play-circle fa-5x"></i>
                                    </div>
                                    <div
                                        class="detail-song-icon next-track"
                                        onclick=""
                                    >
                                        <i class="fa fa-step-forward fa-2x"></i>
                                    </div>
                                    <div
                                        class="detail-song-icon repeat-track"
                                        onclick=""
                                    >
                                        <i
                                            class="fa fa-repeat fa-2x"
                                            title="repeat"
                                        ></i>
                                    </div>
                                </div>
                            </div>
                            <div class="detail-page-info">
                                <h2 class="detail-page-info-title">Lyric</h2>
                                <%
                                    String[] lyric =  songNow.getLoiBaiHat().split("\\.");
                                    %>
                                <div class="detail-page-info-lyric">
                                        <% for( int i = 0; i < lyric.length; i++) {%>
                                             <p class="lyric-item"><%=lyric[i]%></p>
                                        <%}%>
                                </div>

                            </div>
                        </div>
                        <ul class="list-song">
                            <% ArrayList<Song> playlistSong = (ArrayList<Song>) session.getAttribute("playlistDetailNow");
                                for(int i = 0;i < playlistSong.size(); i++){
                            %>
                            <li class="list-song-item">
                                <a

                                        href="PlaylistServlet?action=detailPage&&idSongNow=<%=playlistSong.get(i).getIdSong()%>"
                                        class="general-playlist-link-song"
                                >
                                    <div
                                            class="list-song-item-img-container"
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
                                    <div class="list-song-item-info">
                                        <h2
                                                class="list-song-item-title"
                                        >
                                            <%=playlistSong.get(i).getTenBaiHat()%>
                                        </h2>
                                        <p
                                                class="list-song-item-author"
                                        >
                                            <%=playlistSong.get(i).getCaSi()%>
                                        </p>
                                        <p
                                                class="list-song-item-time"
                                        >
                                            <%=playlistSong.get(i).getThoiGian()%>
                                        </p>
                                    </div>
                                </a>

                            </li>
                            <%  }%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script language="JavaScript" src="detail-page5.js"></script>
</html>
