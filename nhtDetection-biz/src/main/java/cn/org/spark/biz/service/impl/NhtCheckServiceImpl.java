package cn.org.spark.biz.service.impl;

import cn.org.spark.biz.service.NhtCheckService;
import cn.org.spark.dao.NhtInfoMapper;
import cn.org.spark.model.NhtInfo;
import cn.org.spark.model.NhtInfoExample;
import cn.org.sprk.biz.result.CheckIPv4Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anonymous on 2019/8/30.
 */
@Service
public class NhtCheckServiceImpl implements NhtCheckService {
    @Autowired
    private NhtInfoMapper nhtInfoMapper;
    InetAddressValidator inetAddressValidator =InetAddressValidator.getInstance();
    /**
     * @param ipV4Str  An IPv4 written in dot-decimal notation
     * @return If return true, it means that the given IP is a NHT IP, false means Not a NHT IP.
     */
    @Override
    public CheckIPv4Result checkIpV4Str(String ipV4Str){
        CheckIPv4Result checkIPv4Result=new CheckIPv4Result();
        checkIPv4Result.setIpv4Str(ipV4Str);
        checkIPv4Result.setNHT(true);

        if(StringUtils.isEmpty(ipV4Str))
        {
            return checkIPv4Result;
        }
        if((null!=ipV4Str)&&(StringUtils.isEmpty(ipV4Str.trim())))
        {
            return checkIPv4Result;
        }
        ipV4Str=ipV4Str.trim();

        if(inetAddressValidator.isValidInet4Address(ipV4Str))
        {
            List<NhtInfo> nhtInfoList=null;
            NhtInfoExample nhtInfoExample=new NhtInfoExample();
            NhtInfoExample.Criteria criteria=nhtInfoExample.createCriteria();
            criteria.andIpEqualTo(ipV4Str);
            nhtInfoList = nhtInfoMapper.selectByExample(nhtInfoExample);
            if((nhtInfoList!=null)&&(nhtInfoList.size()>0))
            {
                checkIPv4Result.setNhtScore(nhtInfoList.get(0).getNhtscore());
                if(nhtInfoList.get(0).getNhtscore()>=50)
                {
                    checkIPv4Result.setNHT(false);
                }
                return checkIPv4Result;
            }
            else
            {
                //Not in Database
                //TODO( check from RtbAsia's Interface and Insert or Update to DB)
            }
            return checkIPv4Result;
        }
        else
        {
            // Invalid IPv4 Address
            return checkIPv4Result;
        }
    }
}
