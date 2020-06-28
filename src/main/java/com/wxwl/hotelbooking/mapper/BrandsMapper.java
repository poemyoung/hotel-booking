package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Brands;
import com.wxwl.hotelbooking.common.domain.BrandsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandsMapper {
    long countByExample(BrandsExample example);

    int deleteByExample(BrandsExample example);

    int deleteByPrimaryKey(String brandid);

    int insert(Brands record);

    int insertSelective(Brands record);

    List<Brands> selectByExample(BrandsExample example);

    Brands selectByPrimaryKey(String brandid);

    int updateByExampleSelective(@Param("record") Brands record, @Param("example") BrandsExample example);

    int updateByExample(@Param("record") Brands record, @Param("example") BrandsExample example);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);
}