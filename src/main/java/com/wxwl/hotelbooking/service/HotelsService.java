package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelsService {
    @Autowired(required = false)
    HotelsMapper mapper;

    /**
     *搜索核心
     * @param location hotelFormerlyName,hotelName ,hotelTranslatedName,address
     * @param checkIn
     * @param checkOut
     * @return
     */
    public List<Hotels> findHotels(String location, String checkIn,String checkOut,int num){
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
            return hotels;
        }else if(//按照数据库数据内容，检查关键字
            location.contains("Hotel") || location.contains("SiChuan") || location.contains("Chengdu")){
            //优先搜索酒店名
            criteria.andHotelformerlynameLike(dealInput);
            criteria1.andHotelnameLike(dealInput);
            criteria2.andAddressLike(dealInput);
        }else {
            criteria.andAddressLike(dealInput);
            criteria1.andHotelformerlynameLike(dealInput);
            criteria2.andHotelnameLike(dealInput);
        }
        //执行
       example.or(criteria1);
        example.or(criteria2);





        hotels = mapper.selectByExample(example);
        return hotels;
    }

    /**
     * 判断输入字符串是不是英文
     * @return 是不是
     */
    public boolean isEnglish(String input){
        return input.matches("^[a-zA-Z|\\s]*");
    }
}
