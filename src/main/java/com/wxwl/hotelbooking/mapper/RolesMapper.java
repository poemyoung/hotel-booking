package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.Roles;
import com.wxwl.hotelbooking.common.domain.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
    long countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);
}