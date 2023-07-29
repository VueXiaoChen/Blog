package com.example.blog.resp;

import java.io.Serializable;
import java.util.Date;

//序列化，使用redis之后需要序列化
public class UserLoadingResp implements Serializable {
    private Long userid;

    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

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
    @Override
    public String toString() {
        return "UserLoadingResp{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}