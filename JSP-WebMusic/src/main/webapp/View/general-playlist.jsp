<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="../app.css" />
        <link
            rel="stylesheet"
            href="../Media/fontawesome-free-6.2.1-web/css/all.min.css"
        />
        <style>
            .general-playlist-container {
                display: flex;
                gap: vaR(--spacing-md);
                flex-direction: column;
                width: 100%;
                align-items: center;
                color: var(--contrast-color);
                font-size: vaR(--font-s-md);
                height: 100%;
                overflow: auto;
            }

            .general-playlist-title {
                font-size: var(--font-s-lg-4);
                text-shadow: 1px 2px 10px black;
            }

            .general-playlist-content {
                display: flex;
                justify-content: center;
                height: 100%;
            }

            .general-playlist {
                display: flex;
                flex-wrap: wrap;
                gap: var(--spacing-md);
            }

            .general-playlist-container::-webkit-scrollbar-track
            {
                cursor: pointer;
                border-radius: 10px;
            }

            .general-playlist-container::-webkit-scrollbar
            {
                margin-right: var(--spacing-vr-sm);
                width: 10px;
                cursor: pointer;
            }

            .general-playlist-container::-webkit-scrollbar-thumb
            {
                border-radius: 6px;
                cursor: pointer;
                background-color: var(--black);
            }

            .general-playlist-add-song {
                margin-top: var(--spacing-md);
            }

            .add-song-container {
                position: relative;
                width: 300px;
                height: 200px;
                display: block;
                border-radius: var(--b-r-md);
                overflow: hidden;
            }

            .overplay-add-song {
                position: absolute;
                top: 0;
                right: 0;
                left: 0;
                bottom: 0;
                background-color: var(--black);
                opacity: 0.8;
                display: flex;
                justify-content: center;
                align-items: center;
                transition: background-color 0.2s ease-in-out;
            }

            .overplay-add-song:hover {
                background-color: var(--sub-color);
            }

            .general-playlist-song {
                position: relative;
                display: flex;
                flex-direction: column;
                width: 300px;
                cursor: pointer;
                margin-top: var(--spacing-md);
            }

            .general-playlist-link-song:hover .overplay-song{
                opacity: 1;
            }

            .general-playlist-song-img-container {
                position: relative;
                border-radius: var(--b-r-md);
                overflow: hidden;
                box-shadow: 1px 0 2px var(--contrast-color);
                height: 200px;
            }

            .overplay-song {
                position: absolute;
                top: 0;
                bottom: 0;
                left: 0;
                right: 0;
                display: flex;
                opacity: 0;
                justify-content: center;
                align-items: center;
                gap: var(--spacing-sm);
                background-color: var(--black-transparent);
                font-size: vaR(--font-s-md);
                transition: opacity 0.2s ease-in-out;
            }

            .icon-play-playlist {
                font-size: var(--font-s-lg-3);
                color: var(--primary-color);
            }

            .general-playlist-img {
                width: 100%;
            }

            .general-playlist-song-info {
                position: relative;
            }

            .general-playlist-song-title {
                margin: var(--spacing-sm) 0;
                text-shadow: 1px 2px 10px black;

            }

            .general-playlist-song-author {
                text-shadow: 1px 2px 10px black;
            }

            .general-playlist-song-time {
                position: absolute;
                top: var(--spacing-vr-sm);
                right: var(--spacing-sm);
                text-shadow: 1px 2px 10px black;
            }

            .button-song {
                position: absolute;
                font-size: var(--font-s-md);
                padding: var(--spacing-vr-sm) var(--spacing-sm);
                width: 60px;
                background-color: var(--primary-color);
                transition:  background-color 0.2s linear;
                cursor: pointer;
                border-radius: var(--b-r-sm);
                bottom: 0;
                right: 0;
                text-align: center;
            }

            .button-song:hover {
                background-color: var(--primary-dark-color);
            }

        </style>
    </head>
    <body>
        <div class="general-playlist-container">
            <h2 class="general-playlist-title">General playlist</h2>
            <div class="general-playlist-content">
                <ul class="general-playlist">
                    <li class="general-playlist-add-song">
                        <a
                            href="./add-form.jsp"
                            class="add-song-container"
                            target="main-content"
                        >
                            <div class="overplay-add-song">
                                <i
                                    class="fa-solid fa-plus icon-play-playlist"
                                ></i>
                            </div>
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                    <li class="general-playlist-song">
                        <a
                            href="./detail-page.jsp"
                            class="general-playlist-link-song"
                            target="main-content"
                        >
                            <div class="general-playlist-song-img-container">
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
                            <div class="general-playlist-song-info">
                                <h2 class="general-playlist-song-title">
                                    Song 1
                                </h2>
                                <p class="general-playlist-song-author">
                                    Author 1
                                </p>
                                <p class="general-playlist-song-time">5:00</p>
                            </div>
                        </a>
                        <a
                            href="./edit-form.jsp"
                            target="main-content"
                            class="button-song"
                        >
                            Edit
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
