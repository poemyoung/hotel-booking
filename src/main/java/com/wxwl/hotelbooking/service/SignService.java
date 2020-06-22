package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Users;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Random;

@Service
public class SignService {

    @Autowired(required = false)
    UsersMapper usersMapper;

    public boolean signUp(String phone,String pwd){
        if(usersMapper.selectByPhone(phone) > 0){
            return false;
        }
        //随机生成用户名
        StringBuilder nameBuilder = new StringBuilder("HB_USER_");
        Random random = new Random(System.nanoTime());
        for(int i=0;i<4;i++) {
            int value = random.nextInt(4);
            nameBuilder.append(value);
        }
        String name  = nameBuilder.toString();
        //插入数据库
        Users user = new Users();
        user.setPhone(phone);
        user.setPwd(pwd);
        user.setUsername(name);
        Date time= new java.sql.Date(new java.util.Date().getTime());
        user.setCreateat(time);
        return usersMapper.insert(user) > 0;
    }

    public ResultCode signIn(String phone, String pwd){
        Users user = usersMapper.selectUserByPhone(phone);
        if(user == null){
            return ResultCode.USER_NOT_EXIST;
        }
        if(user.getPwd().equals(pwd)){
            return ResultCode.SUCCESS;
        }else {
            return ResultCode.USER_LOGIN_ERROR;
        }
    }



}
