package com.hotelbooking.hotelbooking.service;

import com.hotelbooking.hotelbooking.common.domain.Hotels;

import java.util.ArrayList;

public interface HotelsService {

    public ArrayList<Hotels> findHotels(String location, String checkInTime, String checkOutTime, int numOfCustomers);
}


