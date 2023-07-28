package com.example.blog.resp;

import com.example.blog.req.UserReq;

public class PasswordReq extends UserReq {
    private String password;

    private String key;

    private String hash;

    private String split;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", password=").append(password);
        sb.append(", key=").append(key);
        sb.append(", hash =").append(hash);
        sb.append(", split=").append(split);
        sb.append("]");
        return sb.toString();
    }
}
