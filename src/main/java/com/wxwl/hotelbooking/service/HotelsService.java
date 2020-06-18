package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.common.domain.Rooms;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HotelsService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    HotelsMapper mapper;

    @Autowired(required = false)
    SearchMapper sMapper;

    @Autowired
    RedisTemplate redisTemplate;
    /**
     *搜索核心
     * @param location hotelFormerlyName,hotelName ,hotelTranslatedName,address
     * @param checkIn
     * @param checkOut
     * @return
     */
    public List<HotelResult> findHotels(String location, String checkIn,String checkOut,int num,int pageNo,int pageSize){
        List<HotelResult> nullList = new ArrayList<>();
        int page = 1;
        //检查页号是否正确
        if(pageNo <= 0){
            return nullList;
        }else{
            page = (pageNo-1) * pageSize;
        }

        List<Hotels> hotels = findHotelsByString(location);
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
            return nullList;
        }else if(hotels == null){
            //检查酒店列表
            return  nullList;
        }else if(hotels.size() == 0){
            return nullList;
        }
        List<HotelResult> res = sMapper.searchByConditions(checkInTime,checkOutTime,num,hotels,page,pageSize);
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

    /**
     * 根据酒店名找到相应的酒店
     * @param location
     * @return 酒店列表
     */

    public List<Hotels> findHotelsByString(String location){
        if(redisTemplate.hasKey(location)){
            List<Hotels> hotels =redisTemplate.opsForList().range(location,0,-1);
            return hotels;
        }
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
        //将查询出的数据缓存进redis
        ListOperations ops = redisTemplate.opsForList();
        ops.leftPushAll(location,hotels);
        return hotels;
    }

    //查找hotelId酒店下[In,Out]时间段内有空余的房间信息
    public List<Rooms> findRooms(int hotelId, String checkInTime, String checkOutTime){
        java.sql.Date checkIn = null;
        java.sql.Date checkOut = null;
        try{
            checkIn = stringToDate(checkInTime);
            checkOut = stringToDate(checkOutTime);
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }
        //检查时间是否正确
        if(checkIn.compareTo(checkOut) >= 0){
            return new ArrayList<>();
        }
        List<Rooms> res = sMapper.findRooms(hotelId,checkIn,checkOut);
        return res;
    }

    public HotelResult findHotel(int hotelId){
        return sMapper.findHotel(hotelId);  //调用xml的findHotel查询
    }
}
