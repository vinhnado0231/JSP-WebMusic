package com.example.jspwebmusic.model.dao;

import com.example.jspwebmusic.model.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public UserDAO() {
    }

    private final ConnectDB connectDB = new ConnectDB();
    private final Connection conn = connectDB.getAConnect();
    private final String find_user_by_id = "select * from user where iuser=?";
    private final String insert_new_user = "INSERT INTO `user` (`iduser`, `name`, `gmail`, `idaccount`, `idrole`) VALUES (NULL, ?, ?, ?, ?)";
    private final String update_user = "update user set name=?,gmail=?,idaccount=?,idrole=? where iduser=?";

    public User getUserById(int id) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(find_user_by_id);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int iduser = Integer.parseInt(rs.getString("iduser"));
                String name = rs.getString("name");
                String gmail = rs.getString("gmail");
                int idaccount = Integer.parseInt(rs.getString("idaccount"));
                int idrole = Integer.parseInt(rs.getString("idrole"));
                return new User(iduser, name, gmail, idaccount, idrole);
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void createUser(User user) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert_new_user);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGmail());
            preparedStatement.setInt(3, user.getIdaccount());
            preparedStatement.setInt(4, user.getIdrole());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(update_user);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGmail());
            preparedStatement.setInt(3, user.getIdaccount());
            preparedStatement.setInt(4, user.getIdrole());
            preparedStatement.setInt(5, user.getIduser());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
