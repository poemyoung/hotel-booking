package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelsService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    @Autowired
    HotelsMapper mapper;

    @Autowired(required = false)
    SearchMapper sMapper;
    /**
     *搜索核心
     * @param location hotelFormerlyName,hotelName ,hotelTranslatedName,address
     * @param checkIn
     * @param checkOut
     * @return
     */
    public List<HotelResult> findHotels(String location, String checkIn,String checkOut,int num){
        String dealInput = "%"+location+"%";
        HotelsExample example = new HotelsExample();
        List<Hotels> hotels = null;
        HotelsExample.Criteria criteria = example.createCriteria();
        HotelsExample.Criteria criteria1 = example.createCriteria();
        HotelsExample.Criteria criteria2 = example.createCriteria();
        //处理location
        if(!isEnglish(location)){
            //中文只搜索译名
            criteria.andHoteltranslatednameLike(dealInput);
            hotels = mapper.selectByExample(example);
        }else if(//按照数据库数据内容，检查关键字
            location.contains("Hotel") || location.contains("SiChuan") || location.contains("Chengdu")){
            //优先搜索酒店名
            criteria.andHotelformerlynameLike(dealInput);
            criteria1.andHotelnameLike(dealInput);
            criteria2.andAddressLike(dealInput);
            example.or(criteria1);
            example.or(criteria2);
            hotels = mapper.selectByExample(example);
        }else {
            criteria.andAddressLike(dealInput);
            criteria1.andHotelformerlynameLike(dealInput);
            criteria2.andHotelnameLike(dealInput);
            example.or(criteria1);
            example.or(criteria2);
            hotels = mapper.selectByExample(example);
        }

        java.sql.Date checkInTime = null;
        java.sql.Date checkOutTime = null;
        try{
            checkInTime = stringToDate(checkIn);
            checkOutTime = stringToDate(checkOut);
        }catch (ParseException e){
              System.out.println(e.getMessage());
              return null;
        }
        //检查时间是否正确
        if(checkInTime.compareTo(checkOutTime) >= 0){
            return new ArrayList<>();
        }else if(hotels == null){
            //检查酒店列表
            return  new ArrayList<>();
        }else if(hotels.size() == 0){
            return new ArrayList<>();
        }
        List<HotelResult> res = sMapper.searchByConditions(checkInTime,checkOutTime,num,hotels);
        return res;
    }

    /**
     * 判断输入字符串是不是英文
     * @return 是不是
     */
    public boolean isEnglish(String input){
        return input.matches("^[a-zA-Z|\\s]*");
    }

    public java.sql.Date stringToDate(String input) throws ParseException {
        Date utilDate = sdf.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
}
