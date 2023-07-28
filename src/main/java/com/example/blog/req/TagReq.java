package com.example.blog.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TagReq extends PageReq {
    private Integer tagId;
    @NotBlank(message = "【博客标签】不能为空")
    private String tagName;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append("]");
        return sb.toString();
    }
}