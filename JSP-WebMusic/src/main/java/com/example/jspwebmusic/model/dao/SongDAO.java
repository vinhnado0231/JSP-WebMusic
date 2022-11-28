package com.example.jspwebmusic.model.dao;

import com.example.jspwebmusic.model.bean.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongDAO {
    public SongDAO() {
    }

    private final ConnectDB connectDB = new ConnectDB();
    private final Connection conn = connectDB.getAConnect();

    private final static String select_all_song_by_idPlayList = "select song.id, song.TenBaiHat, song.CaSi, song.LoiBaiHat, song.SangTac, song.ThoiGian, song.LuotNghe, song.target from song " +
            "inner join playlist_detail on playlist_detail.idsong=song.id " +
            "inner join playlist on playlist.idlist=playlist_detail.idlist " +
            "where playlist.idlist= ?";

    //    private final static String insert_new_song = "insert into song values TenBaiHat=?,CaSi=?,LoiBaiHat=?,SangTac=?,ThoiGian=?,LuotNghe=?,target=?";
    private final String insert_new_song = "INSERT INTO `song` (`id`, `TenBaiHat`, `CaSi`, `LoiBaiHat`, `SangTac`, `ThoiGian`, `LuotNghe`, `target`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    private final String update_song = "update song set TenBaiHat=?,CaSi=?,LoiBaiHat=?,SangTac=?,ThoiGian=?,LuotNghe=?,target=? where id=?";
    private final String delete_playlist_detail = "delete from playlist_detail where idSong=?";
    private final String delete_song = "delete from song where id=?";
    private final String select_song_by_id = "select * from song where id=?";
    private final String search_song = "select * from song where TenBaiHat like concat('%' , ? ,'%')";

    public ArrayList<Song> getAllSongByPlaylist(int idList) {
        ArrayList<Song> listSongs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(select_all_song_by_idPlayList);
            preparedStatement.setInt(1, idList);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("TenBaiHat");
                String caSi = rs.getString("CaSi");
                String loi = rs.getString("LoiBaiHat");
                String sangTac = rs.getString("SangTac");
                String thoiGian = rs.getString("ThoiGian");
                int luotNghe = Integer.parseInt(rs.getString("LuotNghe"));
                String target = rs.getString("target");
                Song song = new Song(id, name, caSi, loi, sangTac, thoiGian, luotNghe, target);
                listSongs.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listSongs;
    }

    public Song getSongById(int idSong) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(select_song_by_id);
            preparedStatement.setInt(1, idSong);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("TenBaiHat");
                String caSi = rs.getString("CaSi");
                String loi = rs.getString("LoiBaiHat");
                String sangTac = rs.getString("SangTac");
                String thoiGian = rs.getString("ThoiGian");
                int luotNghe = Integer.parseInt(rs.getString("LuotNghe"));
                String target = rs.getString("target");
                return new Song(id, name, caSi, loi, sangTac, thoiGian, luotNghe, target);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void addNewSong(Song song) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert_new_song);
            preparedStatement.setString(1, song.getTenBaiHat());
            preparedStatement.setString(2, song.getCaSi());
            preparedStatement.setString(3, song.getLoiBaiHat());
            preparedStatement.setString(4, song.getSangTac());
            preparedStatement.setString(5, song.getThoiGian());
            preparedStatement.setInt(6, song.getLuotNghe());
            preparedStatement.setString(7, song.getTarget());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSong(Song song) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(update_song);
            preparedStatement.setString(1, song.getTenBaiHat());
            preparedStatement.setString(2, song.getCaSi());
            preparedStatement.setString(3, song.getLoiBaiHat());
            preparedStatement.setString(4, song.getSangTac());
            preparedStatement.setString(5, song.getThoiGian());
            preparedStatement.setInt(6, song.getLuotNghe());
            preparedStatement.setString(7, song.getTarget());
            preparedStatement.setInt(8, song.getIdSong());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSong(int id) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(delete_playlist_detail);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement = conn.prepareStatement(delete_song);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Song> searchSongByName(String nameSong) {
        ArrayList<Song> listSongs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(search_song);
            preparedStatement.setString(1, nameSong);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("TenBaiHat");
                String caSi = rs.getString("CaSi");
                String loi = rs.getString("LoiBaiHat");
                String sangTac = rs.getString("SangTac");
                String thoiGian = rs.getString("ThoiGian");
                int luotNghe = Integer.parseInt(rs.getString("LuotNghe"));
                String target = rs.getString("target");
                Song song = new Song(id, name, caSi, loi, sangTac, thoiGian, luotNghe, target);
                listSongs.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listSongs;
    }
}
