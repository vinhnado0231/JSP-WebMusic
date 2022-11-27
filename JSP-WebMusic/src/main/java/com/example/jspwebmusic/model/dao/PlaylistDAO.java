package com.example.jspwebmusic.model.dao;

import com.example.jspwebmusic.model.bean.Playlist;
import com.example.jspwebmusic.model.bean.Song;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistDAO {
    public PlaylistDAO(){}
    private ConnectDB connectDB=new ConnectDB();
    public ArrayList<Playlist> getAllPlaylist(){
        ArrayList<Playlist> listSongs=new ArrayList<>();
        try {
            Connection conn=connectDB.getAConnect();
            Statement stmt = conn.createStatement();
            String sql = "select * from playlist";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int id=Integer.parseInt(rs.getString("idlist"));
                int iduser=Integer.parseInt(rs.getString("iduser"));
                String namelist=rs.getString("namelist");
                Playlist list=new Playlist(id,namelist,iduser);
                listSongs.add(list);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listSongs;
    }
    public Song getSongbyIdSong(int id){
        Connection conn=connectDB.getAConnect();
        Song baihat=new Song();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            String sql = "select * from song where id=?";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(id));
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                baihat.setIdSong(Integer.parseInt(rs.getString("id")));
                baihat.setCaSi(rs.getString("CaSi"));
                baihat.setTenBaiHat(rs.getString("TenBaiHat"));
                baihat.setLoiBaiHat(rs.getString("LoiBaiHat"));
                baihat.setSangTac(rs.getString("SangTac"));
                baihat.setThoiGian(rs.getString("ThoiGian"));
                baihat.setLuotNghe(Integer.parseInt(rs.getString("LuotNghe")));
                baihat.setTarget(rs.getString("target"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return baihat;
    }
    public ArrayList<Song> getAllSongByIDPlayList(int idList){
        ArrayList<Song> listSong=new ArrayList<>();
        Connection conn=connectDB.getAConnect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "select * from playlist_detail where idlist=?";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(idList));
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                Song baihat=getSongbyIdSong(Integer.parseInt(rs.getString("idsong")));
                listSong.add(baihat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listSong;
    }
    public void addPlayList(int idUser,String nameList){

        Connection conn=connectDB.getAConnect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql="INSERT INTO `playlist` (`idlist`, `iduser`, `namelist`) VALUES (NULL, '?', '?')";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(idUser));
            pst.setString(2, nameList);

           pst.executeUpdate(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
