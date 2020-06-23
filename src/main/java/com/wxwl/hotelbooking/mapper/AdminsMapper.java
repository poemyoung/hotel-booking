package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Admins;
import com.wxwl.hotelbooking.common.domain.AdminsExample;
import java.util.List;

import com.wxwl.hotelbooking.common.domain.Hotels;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminsMapper {
    long countByExample(AdminsExample example);

    int deleteByExample(AdminsExample example);

    int deleteByPrimaryKey(String hotelname);

    int insert(Admins record);

    int insertSelective(Admins record);

    List<Admins> selectByExample(AdminsExample example);

    Admins selectByPrimaryKey(String hotelname);

    int updateByExampleSelective(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByExample(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);

    @Select("SELECT COUNT(*) FROM admins WHERE hotelName = #{name}")
    int selectByHotelName(String name);
}