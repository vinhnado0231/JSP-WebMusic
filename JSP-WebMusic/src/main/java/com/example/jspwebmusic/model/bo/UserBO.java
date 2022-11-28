package com.example.jspwebmusic.model.bo;

import com.example.jspwebmusic.model.bean.User;
import com.example.jspwebmusic.model.dao.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBO {
    private UserDAO userDAO = new UserDAO();
    public UserBO() {
    }
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}

