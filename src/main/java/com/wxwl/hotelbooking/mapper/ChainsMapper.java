package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Chains;
import com.wxwl.hotelbooking.common.domain.ChainsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChainsMapper {
    long countByExample(ChainsExample example);

    int deleteByExample(ChainsExample example);

    int deleteByPrimaryKey(String chainid);

    int insert(Chains record);

    int insertSelective(Chains record);

    List<Chains> selectByExample(ChainsExample example);

    Chains selectByPrimaryKey(String chainid);

    int updateByExampleSelective(@Param("record") Chains record, @Param("example") ChainsExample example);

    int updateByExample(@Param("record") Chains record, @Param("example") ChainsExample example);

    int updateByPrimaryKeySelective(Chains record);

    int updateByPrimaryKey(Chains record);
}