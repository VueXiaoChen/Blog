package com.example.blog.domain;

public class VideoAddress {
    private Long videoid;

    private String videotag;

    private String videosource;

    private String videoaddress;

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
        sb.append(", videoimg=").append(videoimg);
        sb.append("]");
        return sb.toString();
    }
}