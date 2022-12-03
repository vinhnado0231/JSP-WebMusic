let now_playing = document.querySelector(".now-playing");
let track_art = document.querySelector(".track-art");
let track_name = document.querySelector(".track-name");
let track_artist = document.querySelector(".track-artist");

let playpause_btn = document.querySelector(".playpause-track");
let next_btn = document.querySelector(".next-track");
let prev_btn = document.querySelector(".prev-track");

let seek_slider = document.querySelector(".seek_slider");
let volume_slider = document.querySelector(".volume_slider");
let curr_time = document.querySelector(".current-time");
let total_duration = document.querySelector(".total-duration");

let randomIcon = document.querySelector(".fa-random");
let curr_track = document.createElement("audio");

const trackArtImg = document.querySelector(".track-art-img");
let indexFromHTML = document.querySelector(".container-index-song");

let track_index = Number(indexFromHTML.textContent);
let isPlaying = false;
let isRandom = false;
let updateTimer;

const music_list = [
    {
        img: "./Media/MUSIC/1.Ritual - Alan Walker/1.png",
        name: "Ritual",
        artist: "Alan Walker",
        music: "./Media/MUSIC/1.Ritual - Alan Walker/Alan Walker - Ritual (Official Music Video).mp3",
    },
    {
        img: "./Media/MUSIC/2.Murder In My Mind - Kordhell/2.png",
        name: "Murder In My Mind",
        artist: "Kordhell",
        music: "./Media/MUSIC/2.Murder In My Mind - Kordhell/KORDHELL - MURDER IN MY MIND (128 kbps).mp3",
    },
    {
        img: "./Media/MUSIC/3.Play - K-391, Alan Walker, Martin Tungev/3.png",
        name: "Play",
        artist: "K-391, Alan Walker, Martin Tungev",
        music: "./Media/MUSIC/3.Play - K-391, Alan Walker, Martin Tungev/Alan Walker, K-391, Tungevaag, Mangoo - PLAY (Alan Walker's Video).mp3",
    },
    {
        img: "./Media/MUSIC/4.Hello World - Alan Walker, Torine/4.png",
        name: "Hello World",
        artist: "Alan Walker",
        music: "./Media/MUSIC/4.Hello World - Alan Walker, Torine/Alan Walker & Torine - Hello World (Official Music Video).mp3",
    },
    {
        img: "./Media/MUSIC/5.BuonKhongTheBuong/5.png",
        name: "Buon Khong The Buong",
        artist: "TrungQuan Idol",
        music: "./Media/MUSIC/5.BuonKhongTheBuong/BuonKhongTheBuong.mp3",
    },
    {
        img: "./Media/MUSIC/6.SauLungCoAiKia/6.png",
        name: "Sau lung co ai kia (Winter Version)",
        artist: "Thieu Bao Tram",
        music: "./Media/MUSIC/6.SauLungCoAiKia/SauLungCoAiKia.mp3",
    },
    {
        img: "./Media/MUSIC/7.KyVongSaiLam/7.png",
        name: "Ky Vong Sai Lam",
        artist: "Tang Phuc, Nguyen Dinh Vu, Yuno Bigboi",
        music: "./Media/MUSIC/7.KyVongSaiLam/KyVongSaiLam.mp3",
    },
    {
        img: "./Media/MUSIC/8.LangYen/8.png",
        name: "Lang Yen (Lang Yen Duoi Vuc Sau OST)",
        artist: "Bui Anh Tuan, Ai Phuong",
        music: "./Media/MUSIC/8.LangYen/LangYen.mp3",
    },
    {
        img: "./Media/MUSIC/9.SuytNuaThi - Andiez/9.png",
        name: "Suyt Nua Thi (Chuyen Di Cua Thanh Xuan OST)",
        artist: "Andiez",
        music: "./Media/MUSIC/9.SuytNuaThi/SuytNuaThi.mp3",
    },
    {
        img: "./Media/MUSIC/10.Nhe/10.png",
        name: "Nhe (Nham Mat Thay Mua He OST)",
        artist: "Uyen Bim (Bet Band)",
        music: "./Media/MUSIC/10.Nhe/Nhe.mp3",
    },
    {
        img: "./Media/MUSIC/11.3107/11.png",
        name: "3107 4",
        artist: " Wn x Erik ft Nau",
        music: "./Media/MUSIC/11.3107 4 - Wn x Erik ft Nâu/3107.mp3",
    },
];

loadTrack(track_index);

function loadTrack(track_index) {
    clearInterval(updateTimer);
    reset();

    curr_track.src = music_list[track_index].music;
    curr_track.load();

    trackArtImg.src = music_list[track_index].img;
    track_name.textContent = music_list[track_index].name;
    track_artist.textContent = music_list[track_index].artist;

    updateTimer = setInterval(setUpdate, 1000);

    curr_track.addEventListener("ended", nextTrack);
}

function reset() {
    curr_time.textContent = "00:00";
    total_duration.textContent = "00:00";
    seek_slider.value = 0;
}
function randomTrack() {
    isRandom ? pauseRandom() : playRandom();
}
function playRandom() {
    isRandom = true;
    randomIcon.classList.add("randomActive");
}
function pauseRandom() {
    isRandom = false;
    randomIcon.classList.remove("randomActive");
}
function repeatTrack() {
    let current_index = track_index;
    loadTrack(current_index);
    playTrack();
}
function playpauseTrack() {
    isPlaying ? pauseTrack() : playTrack();
}
function playTrack() {
    curr_track.play();
    isPlaying = true;
    track_art.classList.add("rotate");
    playpause_btn.innerHTML = '<i class="fa fa-pause-circle fa-5x"></i>';
}
function pauseTrack() {
    curr_track.pause();
    isPlaying = false;
    track_art.classList.remove("rotate");
    playpause_btn.innerHTML = '<i class="fa fa-play-circle fa-5x"></i>';
}
function nextTrack() {
    if (track_index < music_list.length - 1 && isRandom === false) {
        track_index += 1;
    } else if (track_index < music_list.length - 1 && isRandom === true) {
        let random_index = Number.parseInt(Math.random() * music_list.length);
        track_index = random_index;
    } else {
        track_index = 0;
    }
    loadTrack(track_index);
    playTrack();
}
function prevTrack() {
    if (track_index > 0) {
        track_index -= 1;
    } else {
        track_index = music_list.length - 1;
    }
    loadTrack(track_index);
    playTrack();
}
function seekTo() {
    let seekto = curr_track.duration * (seek_slider.value / 100);
    curr_track.currentTime = seekto;
    console.log(seekto);
}
function setVolume() {
    curr_track.volume = volume_slider.value / 100;
    console.log(curr_track.volume);
}
function setUpdate() {
    let seekPosition = 0;
    if (!isNaN(curr_track.duration)) {
        seekPosition = curr_track.currentTime * (100 / curr_track.duration);
        seek_slider.value = seekPosition;

        let currentMinutes = Math.floor(curr_track.currentTime / 60);
        let currentSeconds = Math.floor(
            curr_track.currentTime - currentMinutes * 60
        );
        let durationMinutes = Math.floor(curr_track.duration / 60);
        let durationSeconds = Math.floor(
            curr_track.duration - durationMinutes * 60
        );

        if (currentSeconds < 10) {
            currentSeconds = "0" + currentSeconds;
        }
        if (durationSeconds < 10) {
            durationSeconds = "0" + durationSeconds;
        }
        if (currentMinutes < 10) {
            currentMinutes = "0" + currentMinutes;
        }
        if (durationMinutes < 10) {
            durationMinutes = "0" + durationMinutes;
        }

        curr_time.textContent = currentMinutes + ":" + currentSeconds;
        total_duration.textContent = durationMinutes + ":" + durationSeconds;
    }
}
