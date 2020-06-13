package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelsServiceImp implements HotelsService{
    @Autowired(required = false)
    HotelsMapper hotelsMapper;

    public ArrayList<Hotels> findHotels(String location, String checkInTime, String checkOutTime, int numOfCustomers){
        HotelsExample hotelsExample = new HotelsExample();

        HotelsExample.Criteria criteria = hotelsExample.createCriteria();
        criteria.andHotelnameLike("%"+location+"%");

        HotelsExample.Criteria criteria1 = hotelsExample.createCriteria();
        criteria1.andHoteltranslatednameLike("%"+location+"%");
        hotelsExample.or(criteria1);

        HotelsExample.Criteria criteria2 = hotelsExample.createCriteria();
        criteria2.andHotelformerlynameLike("%"+location+"%");
        hotelsExample.or(criteria2);

        HotelsExample.Criteria criteria3 = hotelsExample.createCriteria();
        criteria3.andAddressLike("%"+location+"%");
        hotelsExample.or(criteria3);

        List<Hotels> hotels = hotelsMapper.selectByExample(hotelsExample);
        return (ArrayList<Hotels>) hotels;
    }

}
