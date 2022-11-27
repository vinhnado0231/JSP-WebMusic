package com.example.jspwebmusic.model.bo;

import com.example.jspwebmusic.model.bean.Song;
import com.example.jspwebmusic.model.dao.SongDAO;

import java.util.ArrayList;

public class SongBO {
    private SongDAO songDAO = new SongDAO();

    public ArrayList<Song> getAllSongByPlaylist(int idList){
        return songDAO.getAllSongByPlaylist(idList);
    }
}
