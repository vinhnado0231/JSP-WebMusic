package com.example.jspwebmusic.model.bean;

public class Song {
    private long idSong;
    private String tenBaiHat;
    private String caSi;
    private String loiBaiHat;
    private String sangTac;
    private String thoiGian;
    private long luotNghe;
    private String target;

    public long getIdSong() {
        return idSong;
    }

    public void setIdSong(long idSong) {
        this.idSong = idSong;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getLoiBaiHat() {
        return loiBaiHat;
    }

    public void setLoiBaiHat(String loiBaiHat) {
        this.loiBaiHat = loiBaiHat;
    }

    public String getSangTac() {
        return sangTac;
    }

    public void setSangTac(String sangTac) {
        this.sangTac = sangTac;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public long getLuotNghe() {
        return luotNghe;
    }

    public void setLuotNghe(long luotNghe) {
        this.luotNghe = luotNghe;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Song(String tenBaiHat, String caSi, String loiBaiHat, String sangTac, String thoiGian, long luotNghe, String target) {
        this.tenBaiHat = tenBaiHat;
        this.caSi = caSi;
        this.loiBaiHat = loiBaiHat;
        this.sangTac = sangTac;
        this.thoiGian = thoiGian;
        this.luotNghe = luotNghe;
        this.target = target;
    }

    public Song() {
    }
}
