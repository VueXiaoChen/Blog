package com.example.blog.domain;

import java.util.Date;

public class Blog {
    private Long blogId;

    private String blogTitle;

    private Long userid;

    private Integer typeId;

    private Integer blogStatus;

    private Date createTime;

    private Date updateTime;

    private String coverImage;

    private Integer like;

    private Integer collect;

    private Integer subscribe;

    private Integer comment;

    private String blogContent;

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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogId=").append(blogId);
        sb.append(", blogTitle=").append(blogTitle);
        sb.append(", userid=").append(userid);
        sb.append(", typeId=").append(typeId);
        sb.append(", blogStatus=").append(blogStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", coverImage=").append(coverImage);
        sb.append(", like=").append(like);
        sb.append(", collect=").append(collect);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", comment=").append(comment);
        sb.append(", blogContent=").append(blogContent);
        sb.append("]");
        return sb.toString();
    }
}