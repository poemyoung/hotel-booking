package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.domain.ReservesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservesMapper {
    long countByExample(ReservesExample example);

    int deleteByExample(ReservesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reserves record);

    int insertSelective(Reserves record);

    List<Reserves> selectByExample(ReservesExample example);

    Reserves selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reserves record, @Param("example") ReservesExample example);

    int updateByExample(@Param("record") Reserves record, @Param("example") ReservesExample example);

    int updateByPrimaryKeySelective(Reserves record);

    int updateByPrimaryKey(Reserves record);
}