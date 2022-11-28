package com.example.jspwebmusic.model.bo;

import com.example.jspwebmusic.model.bean.Account;
import com.example.jspwebmusic.model.dao.AccountDAO;

public class AccountBO {
    private AccountDAO accountDAO = new AccountDAO();

    public Account findAccountByUsername(String username) {
        return accountDAO.findAccountByUsername(username);
    }

    public void createNewAccount(Account account) {
        accountDAO.createNewAccount(account);
    }

    public boolean changePassword(String username, String password) {
        if (checkLogin(username, password)) {
            accountDAO.changePassword(username, password);
            return true;
        }
        return false;
    }

    public boolean checkLogin(String username, String password) {
        return accountDAO.checkLogin(username, password);
    }
}
