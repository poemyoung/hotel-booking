package com.wxwl.hotelbooking.mapper;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.domain.Hotels;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface SearchMapper {

    List<HotelResult> searchByConditions(Date checkIn, Date checkOut, Integer num, List<Hotels> hotelList);

}
