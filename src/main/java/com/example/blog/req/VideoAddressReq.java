package com.example.blog.req;

import java.util.Date;

public class VideoAddressReq extends PageReq{
    private Long videoid;

    private String videotag;

    private String videosource;

    private String videoaddress;

    private Date updateTime;

    private Date createTime;

    private String videoimg;

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
        sb.append(", videoimg=").append(videoimg);
        sb.append("]");
        return sb.toString();
    }
}