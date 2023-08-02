package com.example.blog.resp;

public class RedisTestResp {
    private Integer redisid;

    private Integer left;

    private Integer rigth;

    private Integer top;

    private Integer bottom;

    public Integer getRedisid() {
        return redisid;
    }

    public void setRedisid(Integer redisid) {
        this.redisid = redisid;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRigth() {
        return rigth;
    }

    public void setRigth(Integer rigth) {
        this.rigth = rigth;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", redisid=").append(redisid);
        sb.append(", left=").append(left);
        sb.append(", rigth=").append(rigth);
        sb.append(", top=").append(top);
        sb.append(", bottom=").append(bottom);
        sb.append("]");
        return sb.toString();
    }
}
