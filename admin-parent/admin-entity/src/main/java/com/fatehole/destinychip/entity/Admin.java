package com.fatehole.destinychip.entity;

import java.util.Date;

public class Admin {
    private Integer id;

    private String loginAccount;

    private String username;

    private String password;

    private String email;

    private Date createTime;

    public Admin(Integer id, String loginAccount, String username, String password, String email, Date createTime) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", loginAccount='" + loginAccount + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}