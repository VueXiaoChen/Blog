package com.example.blog.req;

import com.example.blog.domain.TagBlog;
import com.example.blog.resp.TagBlogResp;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class BlogReq extends PageReq {
    private Long blogId;
    @NotNull(message = "【博客标题】不能为空")
    private String blogTitle;
    @NotNull(message = "【用户id=>userid】不能为空")
    private Long userid;
    @NotNull(message = "【博客类型】必须选择")
    private Integer typeId;
    private Integer blogStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String coverImage;

    private String blogContent;

    private Integer like;

    private Integer collect;

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

    private Integer subscribe;

    private Integer comment;

    private List<TagBlogResp> tagBlog;

    public List<TagBlogResp> getTagBlog() {
        return tagBlog;
    }

    public void setTagBlog(List<TagBlogResp> tagBlog) {
        this.tagBlog = tagBlog;
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

    @Override
    public String toString() {
        return "BlogReq{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", userid=" + userid +
                ", typeId=" + typeId +
                ", blogStatus=" + blogStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", coverImage='" + coverImage + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", like=" + like +
                ", collect=" + collect +
                ", subscribe=" + subscribe +
                ", comment=" + comment +
                ", tagBlog=" + tagBlog +
                '}';
    }

}