package model.bean;

public class User {
    private int iduser;
    private String name;
    private String gmail;
    private int idaccount;
    private int idrole;
    private String avt;


    public User() {
    }

    public User(int iduser, String name, String gmail, int idaccount, int idrole, String avt) {
        this.iduser = iduser;
        this.name = name;
        this.gmail = gmail;
        this.idaccount = idaccount;
        this.idrole = idrole;
        this.avt = avt;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }
}
