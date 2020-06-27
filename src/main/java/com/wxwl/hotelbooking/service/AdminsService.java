package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Admins;
import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.domain.ReservesExample;
import com.wxwl.hotelbooking.mapper.AdminsMapper;
import com.wxwl.hotelbooking.mapper.ReservesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminsService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    ReservesMapper reservesMapper;

    @Autowired(required = false)
    AdminsMapper adminsMapper;

    public java.sql.Date stringToDate(String input) throws ParseException {
        Date utilDate = sdf.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //System.out.println(sqlDate);
        return sqlDate;
    }

    //获取所有订单
    public List<Reserves> getReserves(int hotelId, String checkIn){
        ReservesExample reservesExample = new ReservesExample();
        java.sql.Date checkInTime = null;
        if(checkIn != null) {
            try {
                checkInTime = stringToDate(checkIn);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                return null;
            }
            reservesExample.createCriteria().andHotelidEqualTo(hotelId).andCheckinatGreaterThan(checkInTime);
        }else{
            reservesExample.createCriteria().andHotelidEqualTo(hotelId);
        }
        List<Reserves> reserves = reservesMapper.selectByExample(reservesExample);
        return reserves;
    }

    public Admins getAdminInfo(String hotelName){
       Admins admins = adminsMapper.selectByPrimaryKey(hotelName);
       return admins;
    }





}
