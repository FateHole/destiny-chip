package com.fatehole.destinychip.entity.po;

public class MemberPO {
    private Integer id;

    private String loginAccount;

    private String username;

    private String password;

    private String email;

    private Integer authStatus;

    private Integer userType;

    private String realName;

    private String cardNumber;

    private Integer accountType;

    public MemberPO(Integer id, String loginAccount, String username, String password, String email, Integer authStatus, Integer userType, String realName, String cardNumber, Integer accountType) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authStatus = authStatus;
        this.userType = userType;
        this.realName = realName;
        this.cardNumber = cardNumber;
        this.accountType = accountType;
    }

    public MemberPO() {
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

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}