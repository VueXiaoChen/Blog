package com.example.blog.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

public class VideoAddressReq extends PageReq{
    private Long videoid;
    @NotNull(message = "【视频标签】不能为空")
    private String videotag;
    @NotNull(message = "【视频源地址】不能为空")
    private String videosource;
    @NotNull(message = "【视频地址】不能为空")
    private String videoaddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String videoimg;

    private String videotype;

    private String videostate;

    private String currencytwo;

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    private String currencyone;

    private String currencythree;

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

    public byte[] getVideofile() {
        return videofile;
    }

    public void setVideofile(byte[] videofile) {
        this.videofile = videofile;
    }

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

    public String getVideoimg() {
        return videoimg;
    }

    public void setVideoimg(String videoimg) {
        this.videoimg = videoimg;
    }

    @Override
    public String toString() {
        return "VideoAddressReq{" +
                "videoid=" + videoid +
                ", videotag='" + videotag + '\'' +
                ", videosource='" + videosource + '\'' +
                ", videoaddress='" + videoaddress + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", videoimg='" + videoimg + '\'' +
                ", videotype='" + videotype + '\'' +
                ", videostate='" + videostate + '\'' +
                ", currencytwo='" + currencytwo + '\'' +
                ", currencyone='" + currencyone + '\'' +
                ", currencythree='" + currencythree + '\'' +
                ", videofile=" + Arrays.toString(videofile) +
                '}';
    }
}