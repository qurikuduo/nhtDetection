package cn.org.spark.model;

import java.util.Date;

public class NhtInfo {
    private String ip;

    private Long iplong;

    private Integer nhtscore;

    private Date updatetime;

    private Date createtime;

    private String memo;

    private Long id;

    public NhtInfo(String ip, Long iplong, Integer nhtscore, Date updatetime, Date createtime, String memo, Long id) {
        this.ip = ip;
        this.iplong = iplong;
        this.nhtscore = nhtscore;
        this.updatetime = updatetime;
        this.createtime = createtime;
        this.memo = memo;
        this.id = id;
    }

    public NhtInfo() {
        super();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getIplong() {
        return iplong;
    }

    public void setIplong(Long iplong) {
        this.iplong = iplong;
    }

    public Integer getNhtscore() {
        return nhtscore;
    }

    public void setNhtscore(Integer nhtscore) {
        this.nhtscore = nhtscore;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NhtInfo{" +
                "ip='" + ip + '\'' +
                ", iplong=" + iplong +
                ", nhtscore=" + nhtscore +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", memo='" + memo + '\'' +
                ", id=" + id +
                '}';
    }
}