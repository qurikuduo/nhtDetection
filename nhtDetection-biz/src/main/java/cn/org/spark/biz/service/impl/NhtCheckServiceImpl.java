package cn.org.spark.biz.service.impl;

import cn.org.spark.biz.service.NhtCheckService;
import cn.org.spark.dao.NhtInfoMapper;
import cn.org.spark.model.NhtInfo;
import cn.org.spark.model.NhtInfoExample;
import cn.org.sprk.biz.result.CheckIPv4Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    public String checkIpV4Str(String ipV4Str){
        CheckIPv4Result checkIPv4Result=new CheckIPv4Result();
        checkIPv4Result.setIpv4Str(ipV4Str);
        checkIPv4Result.setNHT(true);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String resultString=gson.toJson(checkIPv4Result);
        if(StringUtils.isEmpty(ipV4Str))
        {
            return resultString;
        }
        if((null!=ipV4Str)&&(StringUtils.isEmpty(ipV4Str.trim())))
        {
            return resultString;
        }
        ipV4Str=ipV4Str.trim();
        //long ipV4Long=0L;

        if(inetAddressValidator.isValidInet4Address(ipV4Str))
        {
            List<NhtInfo> nhtInfoList=null;
            //ipV4Long= NumberUtils.toLong(ipV4Str,0L);
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
                resultString=gson.toJson(checkIPv4Result);
                return resultString;
            }
            else
            {
                //Not in Database
                //TODO( check from RtbAsia's Interface and Insert or Update to DB)
            }
            return resultString;
        }
        else
        {
            // Invalid IPv4 Address
            return resultString;
        }
    }
}
