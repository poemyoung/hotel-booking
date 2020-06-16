package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Rooms;
import com.wxwl.hotelbooking.common.domain.RoomsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomsMapper {
    long countByExample(RoomsExample example);

    int deleteByExample(RoomsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rooms record);

    int insertSelective(Rooms record);

    List<Rooms> selectByExample(RoomsExample example);

    Rooms selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rooms record, @Param("example") RoomsExample example);

    int updateByExample(@Param("record") Rooms record, @Param("example") RoomsExample example);

    int updateByPrimaryKeySelective(Rooms record);

    int updateByPrimaryKey(Rooms record);
}