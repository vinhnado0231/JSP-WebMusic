package com.example.jspwebmusic.model.dao;

import com.example.jspwebmusic.model.bean.Playlist;
import com.example.jspwebmusic.model.bean.Song;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistDAO {
    public PlaylistDAO(){}
    public ArrayList<Playlist> getAllPlaylist(){
        ArrayList<Playlist> listSongs=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/musicdb";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            String sql = "select * from song";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int id=Integer.parseInt(rs.getString("idlist"));
                int iduser=Integer.parseInt(rs.getString("iduser"));
                String namelist=rs.getString("namelist");
                Playlist list=new Playlist(id,namelist,iduser);
                listSongs.add(list);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listSongs;
    }
}
