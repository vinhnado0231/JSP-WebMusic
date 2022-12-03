package model.dao;

import model.bean.Playlist;
import model.bean.Song;

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
                String target=rs.getString("target");
                Playlist list=new Playlist(id,namelist,iduser,target);
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
            String sql="INSERT INTO playlist (idlist, iduser, namelist) VALUES (NULL,\'"+idUser +"\',\'"+nameList+"\')";
            PreparedStatement pst;
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  void removePlayList(int idlist){
        Connection conn=connectDB.getAConnect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql="delete from playlist where idlist= \'"+idlist+"\'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void updatePlayList(int idList,int idUser,String nameList){
        Connection conn=connectDB.getAConnect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql="update playlist set iduser=?,namelist=?  where idlist=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,idUser);
            preparedStatement.setString(2,nameList);
            preparedStatement.setInt(3,idList);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void addSongToPlayList(int idlist,int idsong){
        Connection conn=connectDB.getAConnect();
        try {
            String sql="INSERT INTO `playlist_detail` (`idlist`, `idsong`) VALUES (?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,idlist);
            preparedStatement.setInt(2,idsong);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  void removeSongFromPlayList(int idlist,int idsong){
        Connection conn=connectDB.getAConnect();
        try {
            String sql="DELETE FROM `playlist_detail` WHERE `playlist_detail`.`idlist` = ? AND `playlist_detail`.`idsong` = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,idlist);
            preparedStatement.setInt(2,idsong);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
