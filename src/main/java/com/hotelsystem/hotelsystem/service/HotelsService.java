package com.hotelsystem.hotelsystem.service;

import com.hotelsystem.hotelsystem.common.domain.Hotels;

import java.util.ArrayList;
import java.util.List;

public interface HotelsService {

    public ArrayList<Hotels> findHotels(String location,String checkInTime,String checkOutTime,int numOfCustomers);
}


