package model.bo;

import model.bean.Playlist;
import model.bean.Song;
import model.dao.PlaylistDAO;

import java.util.ArrayList;

public class PlaylistBO {
    PlaylistDAO playlistDAO = new PlaylistDAO();

    public ArrayList<Playlist> getAllPlaylist() {
        return playlistDAO.getAllPlaylist();
    }

    public ArrayList<Song> getAllSongByIDList(int idlist) {
        return playlistDAO.getAllSongByIDPlayList(idlist);
    }

    public void addPlayList(int idUser, String nameList) {
        playlistDAO.addPlayList(idUser, nameList);
    }

    public void deletePlayList(int idlist) {
        playlistDAO.removePlayList(idlist);
    }

    public void updatePlayList(int idList, int idUser, String nameList) {
        playlistDAO.updatePlayList(idList, idUser, nameList);
    }

    public void addSongToPlayList(int idSong, int idList) {
        playlistDAO.addSongToPlayList(idSong, idList);
    }

    public void removeSongFromPlayList(int idlist, int idsong) {
        playlistDAO.removeSongFromPlayList(idlist, idsong);
    }
    public Playlist getPlaylistByID(String id){
        return playlistDAO.getPlaylistByID(id);
    }
    public ArrayList<Playlist> getPlayListofUser(int iduser){
        return playlistDAO.getPlayListofUser(iduser);
    }
}
