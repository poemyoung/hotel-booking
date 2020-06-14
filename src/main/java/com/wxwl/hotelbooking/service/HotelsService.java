package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HotelsService {
    @Autowired(required = false)
    HotelsMapper mapper;

    /**
     *
     * @param location
     * @param checkIn
     * @param checkOut
     * @return
     */
    public List<Hotels> findHotels(String location, Date checkIn,Date checkOut){
        HotelsExample example = new HotelsExample();
        HotelsExample.Criteria criteria = example.createCriteria();
        //
        return null;
    }

    /**
     * 判断输入字符串是不是英文
     * @return 是不是
     */
    public boolean isEnglish(String input){
        return input.matches("^[a-zA-Z|\\s]*");
    }

    public static void main(String[] args) {
        HotelsService a = new HotelsService();
        System.out.println(a.isEnglish("aa 你好"));
    }
}
