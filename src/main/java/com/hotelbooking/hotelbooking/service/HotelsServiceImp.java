package com.hotelbooking.hotelbooking.service;

import com.hotelbooking.hotelbooking.common.domain.Hotels;
import com.hotelbooking.hotelbooking.common.domain.HotelsExample;
import com.hotelbooking.hotelbooking.mapper.HotelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelsServiceImp implements HotelsService{
    @Autowired
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
