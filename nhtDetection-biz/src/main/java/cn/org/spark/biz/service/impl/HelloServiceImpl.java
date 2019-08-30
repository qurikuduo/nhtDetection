package cn.org.spark.biz.service.impl;

import cn.org.spark.biz.service.HelloService;
import cn.org.spark.dao.NhtInfoMapper;
import cn.org.spark.model.NhtInfo;
import cn.org.spark.model.NhtInfoExample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Anonymous on 2019/8/27.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private NhtInfoMapper nhtInfoMapper;
    InetAddressValidator inetAddressValidator =InetAddressValidator.getInstance();
        @Override
        public String test() {
            List<NhtInfo> nhtInfoList=null;
            NhtInfoExample nhtInfoExample=new NhtInfoExample();
            NhtInfoExample.Criteria criteria=nhtInfoExample.createCriteria();
            // Return max 10 IP's detail in database
            criteria.andIdBetween(0L,10L);
            nhtInfoList = nhtInfoMapper.selectByExample(nhtInfoExample);
            if(nhtInfoList!=null)
            {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                return  gson.toJson(nhtInfoList);
            }
            else
            {
                return "test";
            }
        }

}
