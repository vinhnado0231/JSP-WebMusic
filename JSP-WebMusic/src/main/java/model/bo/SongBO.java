package model.bo;

import model.bean.Song;
import model.dao.SongDAO;

import java.util.ArrayList;

public class SongBO {
    private SongDAO songDAO = new SongDAO();

    public ArrayList<Song> getAllSongByPlaylist(int idList){
        return songDAO.getAllSongByPlaylist(idList);
    }
    public Song getSongById(int id){
        return songDAO.getSongById(id);
    }

    public void addNewSong(Song song){
        songDAO.addNewSong(song);
    }

    public void updateSong(Song song){
        songDAO.updateSong(song);
    }

    public void deleteSong(int id){
        songDAO.deleteSong(id);
    }
    public ArrayList<Song> searchSong(String name){
        return songDAO.searchSongByName(name);
    }
}
