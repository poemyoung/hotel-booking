package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    Hotels selectByTranslatedName(String name);


    @Select("SELECT COUNT(*) FROM hotels WHERE hotelTranslatedName = #{name}")
    int selectByName(String name);

    @Select("SELECT COUNT(*) FROM reserves WHERE hotelId=#{id} AND #{date}>=checkInAt AND #{date}<=checkOutAt")
    int selectUnfinishedReserves(Date date, Integer id);
}