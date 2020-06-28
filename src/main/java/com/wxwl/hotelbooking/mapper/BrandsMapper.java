package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Brands;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandsMapper {

    int deleteByPrimaryKey(String brandid);

    int insert(Brands record);

    int insertSelective(Brands record);

    Brands selectByPrimaryKey(String brandid);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);

    @Select("SELECT * FROM brands")
    List<Brands> selectAll();
}