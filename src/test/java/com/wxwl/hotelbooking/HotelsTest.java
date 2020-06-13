package com.wxwl.hotelbooking;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class HotelsTest {
    @Autowired
    HotelsMapper hotelsMapper;

    @Test
    public void selectHotel(){
        Hotels hotels = hotelsMapper.selectByPrimaryKey(8363);
        System.out.println(hotels.toString());
    }
    @Test
    public void setHotels(){
        Integer[] ids = {71800,61521,108444};
        List<Integer> list = Arrays.asList(ids);
        HotelsExample hotelsExample = new HotelsExample();
        hotelsExample.createCriteria().andHotelidIn(list);
        List<Hotels> hotels = hotelsMapper.selectByExample(hotelsExample);
        Iterator iterator = hotels.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
    @Test
    public void selectHotels(){
        String name = "捷江";
        HotelsExample hotelsExample = new HotelsExample();
//        hotelsExample.createCriteria()
//        hotelsExample.createCriteria().andHoteltranslatednameLike("%"+name+"%");
        List<Hotels> hotels = hotelsMapper.selectByExample(hotelsExample);
        System.out.println(hotels.toString());

    }
    @Test
    public void select(){
        String location = "Yinhe Dynasty";
        HotelsExample hotelsExample = new HotelsExample();
        HotelsExample.Criteria criteria = hotelsExample.createCriteria();
        criteria.andHotelnameLike(location);
        HotelsExample.Criteria criteria1 = hotelsExample.createCriteria();
        criteria1.andHoteltranslatednameLike(location);
        HotelsExample.Criteria criteria2 = hotelsExample.createCriteria();
        criteria2.andHotelformerlynameLike(location);
        hotelsExample.or(criteria1);
        hotelsExample.or(criteria2);
        List<Hotels> hotels = hotelsMapper.selectByExample(hotelsExample);
        System.out.println(hotels.size()==0?0:hotels.get(0).toString());
    }
    @Test
    public void test1(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(date));
        System.out.println();

    }
}
