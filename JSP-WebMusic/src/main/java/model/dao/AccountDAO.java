package model.dao;

import model.bean.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    public AccountDAO() {
    }

    private final ConnectDB connectDB = new ConnectDB();
    private final Connection conn = connectDB.getAConnect();

    private final String search_account_by_username = "select * from account where username =?";
    private final String insert_new_account = "INSERT INTO `account` (`idaccount`, `username`, `password`) VALUES (NULL, ?, ?);";
    private final String change_password = "UPDATE `account` SET `password` = ? WHERE `account`.`username` = ?";
    private final String check_login = "select * from account where username = ? and password = ?";
    private final String find_account_by_idaccount="select * from account where idaccount=?";

    public Account findAccountByUsername(String username) {
        Account account = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(search_account_by_username);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("idaccount"));
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                account = new Account(id, username1, password);
                return account;
            }
        } catch (Exception e) {

        }
        return account;
    }
    public Account findAccountByIdAccount(int idaccount) {
        Account account = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(find_account_by_idaccount);
            preparedStatement.setInt(1, idaccount);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("idaccount"));
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                account = new Account(id, username1, password);
                return account;
            }
        } catch (Exception e) {

        }
        return account;
    }

    public void createNewAccount(Account account) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insert_new_account);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String username, String password) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(change_password);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String username, String password) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(check_login);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
