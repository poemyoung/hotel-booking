package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Hotels;

import java.util.ArrayList;

public interface HotelsService {

    public ArrayList<Hotels> findHotels(String location, String checkInTime, String checkOutTime, int numOfCustomers);
}


