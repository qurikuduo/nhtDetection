package cn.org.spark.biz.service;

import cn.org.sprk.biz.result.CheckIPv4Result;

/**
 * Created by Anonymous on 2019/8/30.
 */
public interface NhtCheckService {

    /**
     * @param ipV4Str  An IPv4 written in dot-decimal notation
     * @return If return true, it means that the given IP is a NHT IP, false means Not a NHT IP.
     */
    CheckIPv4Result checkIpV4Str(String ipV4Str);

}
