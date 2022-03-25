package br.com.adjafsaobraz.adjaf.application.core.domain.user;

public class User {

    private Integer id;
    private String mail;
    private String password;
    private Integer roles;

    public User(Integer id, String mail, String password, Integer roles) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}
