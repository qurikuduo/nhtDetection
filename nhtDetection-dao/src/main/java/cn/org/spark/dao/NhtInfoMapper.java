package cn.org.spark.dao;

import cn.org.spark.model.NhtInfo;
import cn.org.spark.model.NhtInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface NhtInfoMapper {
    long countByExample(NhtInfoExample example);

    int deleteByExample(NhtInfoExample example);

    int insert(NhtInfo record);

    int insertSelective(NhtInfo record);

    List<NhtInfo> selectByExample(NhtInfoExample example);

    int updateByExampleSelective(@Param("record") NhtInfo record, @Param("example") NhtInfoExample example);

    int updateByExample(@Param("record") NhtInfo record, @Param("example") NhtInfoExample example);
}