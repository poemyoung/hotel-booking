package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.HotelResult;

import java.util.List;

public interface SearchMapper {

    List<HotelResult> searchByConditions(String location, String checkIn,String checkOut,int num);

}
