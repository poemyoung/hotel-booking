package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Admins;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.Users;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.AdminsMapper;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Random;

@Service
public class SignService {

    @Autowired(required = false)
    UsersMapper usersMapper;

    @Autowired(required = false)
    AdminsMapper adminsMapper;

    @Autowired(required = false)
    HotelsMapper hotelsMapper;

    @Transactional
    public boolean userSignUp(String phone,String pwd){
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

    @Transactional
    public ResultCode userSignIn(String phone, String pwd){
        System.out.println(phone);
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

    @Transactional
    public boolean adminSignUp(String hotel,String pwd){
        if(adminsMapper.selectByHotelName(hotel) > 0){
            return false;
        }
        //随机生成hotelID
        int id;
        Random random = new Random(System.nanoTime());
        StringBuilder idBuilder = new StringBuilder();
        while (true) {
            for (int i = 0; i < 6; i++) {
                int value = random.nextInt(6);
                idBuilder.append(value);
            }
            id = Integer.parseInt(idBuilder.toString());
            if(hotelsMapper.selectByPrimaryKey(id)== null)break;
        }
        Hotels hotels = new Hotels();
        hotels.setHotelid(id);
        hotels.setHoteltranslatedname(hotel);
        hotels.setChainid(0);
        Admins admins = new Admins();
        admins.setCreateat(new Date(System.currentTimeMillis()));
        admins.setHotelid(id);
        admins.setHotelname(hotel);
        admins.setCreateat(new Date(System.currentTimeMillis()));
       boolean tmp = adminsMapper.insert(admins) > 0 && hotelsMapper.insert(hotels) > 0;
       return tmp;
    }

    @Transactional
    public ResultCode adminLoginIn(String hotel,String password){
        Admins admins = adminsMapper.selectByPrimaryKey(hotel);
        if(admins == null){
            return ResultCode.USER_NOT_EXIST;
        }
        if(admins.getPwd().equals(password)){
            return ResultCode.SUCCESS;
        }else {
            return ResultCode.USER_LOGIN_ERROR;
        }
    }

}
