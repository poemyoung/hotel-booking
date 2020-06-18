package com.wxwl.hotelbooking.common.domain;

import java.util.List;

public class RoomsResult {
    private HotelResult hotel;
    private List<Rooms> rooms;

    public HotelResult getHotel() {
        return hotel;
    }

    public RoomsResult setHotel(HotelResult hotel) {
        this.hotel = hotel;
        return this;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public RoomsResult setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
        return this;
    }
}
