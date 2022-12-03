package model.bo;

import model.bean.User;
import model.dao.UserDAO;

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
    public User getUserByIdaccount(int IdAccount){
        return userDAO.getUserByIdaccount(IdAccount);
    }
}

