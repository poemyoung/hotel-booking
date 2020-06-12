package com.hotelbooking.hotelbooking.mapper;

import com.hotelbooking.hotelbooking.common.domain.HotelsExample;
import com.hotelbooking.hotelbooking.common.domain.Hotels;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsMapper {
    long countByExample(HotelsExample example);

    int deleteByExample(HotelsExample example);

    int deleteByPrimaryKey(Integer hotelid);

    int insert(Hotels record);

    int insertSelective(Hotels record);

    List<Hotels> selectByExample(HotelsExample example);

    Hotels selectByPrimaryKey(Integer hotelid);

    int updateByExampleSelective(@Param("record") Hotels record, @Param("example") HotelsExample example);

    int updateByExample(@Param("record") Hotels record, @Param("example") HotelsExample example);

    int updateByPrimaryKeySelective(Hotels record);

    int updateByPrimaryKey(Hotels record);
}