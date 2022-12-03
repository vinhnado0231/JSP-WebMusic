package model.dao;

import model.bean.User;

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
    private final String get_user_by_idaccount="select * from user where idaccount=?";

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
                String avt = rs.getString("avt");
                return new User(iduser, name, gmail, idaccount, idrole, avt);
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserByIdaccount(int IdAccount) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(get_user_by_idaccount);
            preparedStatement.setInt(1, IdAccount);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int iduser = Integer.parseInt(rs.getString("iduser"));
                String name = rs.getString("name");
                String gmail = rs.getString("gmail");
                int idaccount = Integer.parseInt(rs.getString("idaccount"));
                int idrole = Integer.parseInt(rs.getString("idrole"));
                String avt = rs.getString("avt");
                return new User(iduser, name, gmail, idaccount, idrole, avt);
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
