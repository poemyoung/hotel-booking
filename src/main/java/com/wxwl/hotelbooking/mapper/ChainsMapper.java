package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Chains;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChainsMapper {
    int deleteByPrimaryKey(String chainid);

    int insert(Chains record);

    int insertSelective(Chains record);

    Chains selectByPrimaryKey(String chainid);

    int updateByPrimaryKeySelective(Chains record);

    int updateByPrimaryKey(Chains record);

    @Select("SELECT * FROM chains")
    List<Chains> selectAll();
}