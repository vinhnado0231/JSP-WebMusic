package com.example.jspwebmusic.model.bo;

import com.example.jspwebmusic.model.bean.Playlist;
import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.dao.PlaylistDAO;

import java.util.ArrayList;

public class PlaylistBO {
    PlaylistDAO playlistDAO=new PlaylistDAO();
    public ArrayList<Playlist> getAllPlaylist(){
        return playlistDAO.getAllPlaylist();
    }
    public ArrayList<Song> getAllSongByIDList(int idlist){
        return playlistDAO.getAllSongByIDPlayList(idlist);
    }
    public void addPlayList(int idUser,String nameList){
        playlistDAO.addPlayList(idUser,nameList);
    }

}
