package com.example.jspwebmusic.model.bean;

public class Playlist {
    private int idList;
    private String nameList;
    private int idUser;
    public Playlist(){

    }
    public Playlist(int idList,String name,int idUser){
        this.idList=idList;
        this.idUser=idUser;
        this.nameList=name;
    }
    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
