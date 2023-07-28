package com.example.blog.resp;

import java.util.Date;

public class UserResp {
    private Long userid;

    private String username;

    private String userSex;

    private String email;

    private String phone;

    private String firstname;

    private String avatar;

    private Integer isSuperuser;

    private Date lastLogin;

    private Date userRegisterTime;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(Integer isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", userSex=").append(userSex);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", firstname=").append(firstname);
        sb.append(", avatar=").append(avatar);
        sb.append(", isSuperuser=").append(isSuperuser);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", userRegisterTime=").append(userRegisterTime);
        sb.append("]");
        return sb.toString();
    }
}