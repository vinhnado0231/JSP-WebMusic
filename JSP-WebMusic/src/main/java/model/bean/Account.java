package model.bean;

public class Account {
    private int idaccount;
    private String username;
    private String password;

    public Account(int idaccount, String username, String password) {
        this.idaccount = idaccount;
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
