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

    private static String select_all_song_by_idPlayList = "select song.id, song.TenBaiHat, song.CaSi, song.LoiBaiHat, song.SangTac, song.ThoiGian, song.LuotNghe, song.target from song " +
            "inner join playlist_detail on playlist_detail.idsong=song.id " +
            "inner join playlist on playlist.idlist=playlist_detail.idlist " +
            "where playlist.idlist= ?";

    public ArrayList<Song> getAllSongByPlaylist(int idList) {
        ArrayList<Song> listSongs = new ArrayList<>();
        try {
            Connection conn = connectDB.getAConnect();
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

}
