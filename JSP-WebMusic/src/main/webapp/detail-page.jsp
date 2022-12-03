<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="./detail-page2.css" />
        <link rel="stylesheet" href="./index.css" />
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
                    <div class="detail-page-container">
                        <div class="detail-page-container-player">
                            <div class="wrapper">
                                <div class="details">
                                    <div class="now-playing">
                                        PLAYING x OF y
                                    </div>
                                    <div class="track-art"></div>
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
                                        onclick="randomTrack()"
                                    >
                                        <i
                                            class="fas fa-random fa-2x"
                                            title="random"
                                        ></i>
                                    </div>
                                    <div
                                        class="detail-song-icon prev-track"
                                        onclick="prevTrack()"
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
                                        onclick="nextTrack()"
                                    >
                                        <i class="fa fa-step-forward fa-2x"></i>
                                    </div>
                                    <div
                                        class="detail-song-icon repeat-track"
                                        onclick="repeatTrack()"
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
                            </div>
                        </div>
                        <ul class="list-song">
                            <li class="list-song-item">
                                <a href="./detail-page.jsp">
                                    <div class="list-song-item-img-container">
                                        <div class="overplay-song">
                                            <i
                                                class="fa-regular fa-circle-play icon-play-playlist"
                                            ></i>
                                            <p class="home-play-music-text">
                                                Play music
                                            </p>
                                        </div>
                                        <img
                                            src="../Media/background-image.avif"
                                            alt=""
                                            class="general-playlist-img"
                                        />
                                    </div>
                                    <div class="list-song-item-info">
                                        <h2 class="list-song-item-title">
                                            Song 1
                                        </h2>
                                        <p class="list-song-item-author">
                                            Author 1
                                        </p>
                                        <p class="list-song-item-time">5:00</p>
                                    </div>
                                </a>
                            </li>
                            <li class="list-song-item">
                                <a href="./detail-page.jsp">
                                    <div class="list-song-item-img-container">
                                        <div class="overplay-song">
                                            <i
                                                class="fa-regular fa-circle-play icon-play-playlist"
                                            ></i>
                                            <p class="home-play-music-text">
                                                Play music
                                            </p>
                                        </div>
                                        <img
                                            src="../Media/background-image.avif"
                                            alt=""
                                            class="general-playlist-img"
                                        />
                                    </div>
                                    <div class="list-song-item-info">
                                        <h2 class="list-song-item-title">
                                            Song 1
                                        </h2>
                                        <p class="list-song-item-author">
                                            Author 1
                                        </p>
                                        <p class="list-song-item-time">5:00</p>
                                    </div>
                                </a>
                            </li>
                            <li class="list-song-item">
                                <a href="./detail-page.jsp">
                                    <div class="list-song-item-img-container">
                                        <div class="overplay-song">
                                            <i
                                                class="fa-regular fa-circle-play icon-play-playlist"
                                            ></i>
                                            <p class="home-play-music-text">
                                                Play music
                                            </p>
                                        </div>
                                        <img
                                            src="../Media/background-image.avif"
                                            alt=""
                                            class="general-playlist-img"
                                        />
                                    </div>
                                    <div class="list-song-item-info">
                                        <h2 class="list-song-item-title">
                                            Song 1
                                        </h2>
                                        <p class="list-song-item-author">
                                            Author 1
                                        </p>
                                        <p class="list-song-item-time">5:00</p>
                                    </div>
                                </a>
                            </li>
                            <li class="list-song-item">
                                <a href="./detail-page.jsp">
                                    <div class="list-song-item-img-container">
                                        <div class="overplay-song">
                                            <i
                                                class="fa-regular fa-circle-play icon-play-playlist"
                                            ></i>
                                            <p class="home-play-music-text">
                                                Play music
                                            </p>
                                        </div>
                                        <img
                                            src="../Media/background-image.avif"
                                            alt=""
                                            class="general-playlist-img"
                                        />
                                    </div>
                                    <div class="list-song-item-info">
                                        <h2 class="list-song-item-title">
                                            Song 1
                                        </h2>
                                        <p class="list-song-item-author">
                                            Author 1
                                        </p>
                                        <p class="list-song-item-time">5:00</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script language="Javascript" src="./detail-page.js"></script>
</html>
