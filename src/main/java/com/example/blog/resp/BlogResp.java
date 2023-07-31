package com.example.blog.resp;

import com.example.blog.domain.Tag;
import com.example.blog.domain.TagBlog;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class BlogResp {
    private Long blogId;

    private String blogTitle;

    private Long userid;

    private Integer typeId;

    private Integer blogStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String coverImage;

    private String blogContent;

    private List<Tag> tagList;

    @Override
    public String toString() {
        return "BlogResp{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", userid=" + userid +
                ", typeId=" + typeId +
                ", blogStatus=" + blogStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", coverImage='" + coverImage + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", tagList=" + tagList +
                ", like=" + like +
                ", collect=" + collect +
                ", subscribe=" + subscribe +
                ", comment=" + comment +
                '}';
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    private Integer like;

    private Integer collect;

    private Integer subscribe;

    private Integer comment;
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

}