package cn.org.sprk.biz.result;

/**
 * Created by Anonymous on 2019/8/30.
 */
public class CheckIPv4Result
{
    private String ipv4Str;
    private boolean isNHT;
    private String msg;
    private int nhtScore;


    public String getIpv4Str() {
        return ipv4Str;
    }

    public void setIpv4Str(String ipv4Str) {
        this.ipv4Str = ipv4Str;
    }

    public boolean isNHT() {
        return isNHT;
    }

    public void setNHT(boolean NHT) {
        isNHT = NHT;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNhtScore() {
        return nhtScore;
    }

    public void setNhtScore(int nhtScore) {
        this.nhtScore = nhtScore;
    }

    @Override
    public String toString() {
        return "CheckIPv4Result{" +
                "ipv4Str='" + ipv4Str + '\'' +
                ", isNHT=" + isNHT +
                ", msg='" + msg + '\'' +
                ", nhtScore=" + nhtScore +
                '}';
    }
}