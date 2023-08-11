package com.example.blog.resp;

public class TagBlogResp {
    private Integer tagId;

    private Long blogId;

    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    @Override
    public String toString() {
        return "TagBlogResp{" +
                "tagId=" + tagId +
                ", blogId=" + blogId +
                ", tagName='" + tagName + '\'' +
                '}';
    }

}