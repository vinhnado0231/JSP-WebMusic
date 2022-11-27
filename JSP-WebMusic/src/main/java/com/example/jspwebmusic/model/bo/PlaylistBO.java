package com.example.jspwebmusic.model.bo;

import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.dao.PlaylistDAO;

import java.util.ArrayList;

public class PlaylistBO {
    PlaylistDAO playlistDAO=new PlaylistDAO();
    public ArrayList<Song> getAllSong(){
        return playlistDAO.getAllSong();
    }

}
