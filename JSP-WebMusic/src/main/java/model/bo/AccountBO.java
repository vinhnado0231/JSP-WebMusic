package model.bo;

import model.bean.Account;
import model.dao.AccountDAO;

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
    public Account findAccountByIdAccount(int idaccount){
        return accountDAO.findAccountByIdAccount(idaccount);
    }
}
