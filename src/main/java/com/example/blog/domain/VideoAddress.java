package com.example.blog.domain;

import java.util.Date;

public class VideoAddress {
    private Long videoid;

    private String videotag;

    private String videosource;

    private String videoaddress;

    private Date updateTime;

    private Date createTime;

    private String videotype;

    private String videostate;

    private String currencytwo;

    private String currencyone;

    private String currencythree;

    private String videoimg;

    private byte[] videofile;

    public Long getVideoid() {
        return videoid;
    }

    public void setVideoid(Long videoid) {
        this.videoid = videoid;
    }

    public String getVideotag() {
        return videotag;
    }

    public void setVideotag(String videotag) {
        this.videotag = videotag;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    public String getVideostate() {
        return videostate;
    }

    public void setVideostate(String videostate) {
        this.videostate = videostate;
    }

    public String getCurrencytwo() {
        return currencytwo;
    }

    public void setCurrencytwo(String currencytwo) {
        this.currencytwo = currencytwo;
    }

    public String getCurrencyone() {
        return currencyone;
    }

    public void setCurrencyone(String currencyone) {
        this.currencyone = currencyone;
    }

    public String getCurrencythree() {
        return currencythree;
    }

    public void setCurrencythree(String currencythree) {
        this.currencythree = currencythree;
    }

    public String getVideoimg() {
        return videoimg;
    }

    public void setVideoimg(String videoimg) {
        this.videoimg = videoimg;
    }

    public byte[] getVideofile() {
        return videofile;
    }

    public void setVideofile(byte[] videofile) {
        this.videofile = videofile;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoid=").append(videoid);
        sb.append(", videotag=").append(videotag);
        sb.append(", videosource=").append(videosource);
        sb.append(", videoaddress=").append(videoaddress);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", videotype=").append(videotype);
        sb.append(", videostate=").append(videostate);
        sb.append(", currencytwo=").append(currencytwo);
        sb.append(", currencyone=").append(currencyone);
        sb.append(", currencythree=").append(currencythree);
        sb.append(", videoimg=").append(videoimg);
        sb.append(", videofile=").append(videofile);
        sb.append("]");
        return sb.toString();
    }
}