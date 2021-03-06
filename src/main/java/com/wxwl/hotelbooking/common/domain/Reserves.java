package com.wxwl.hotelbooking.common.domain;


import com.wxwl.hotelbooking.service.ReservesService;

import java.util.Date;

public class Reserves {
    private Integer id;

    private Integer hotelid;

    private Integer roomid;

    private Date createat;

    private String username;

    private String userphone;

    private String useremail;

    private Date checkinat;

    private Date checkoutat;

    private ReservesService.PayWay pay;

    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Date getCheckinat() {
        return checkinat;
    }

    public void setCheckinat(Date checkinat) {
        this.checkinat = checkinat;
    }

    public Date getCheckoutat() {
        return checkoutat;
    }

    public void setCheckoutat(Date checkoutat) {
        this.checkoutat = checkoutat;
    }

    public ReservesService.PayWay getPay() {
        return pay;
    }

    public void setPay(ReservesService.PayWay pay) {
        this.pay = pay == null ? null : pay;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Reserves(Integer id, Integer hotelid, Integer roomid, Date createat, String username, String userphone, String useremail, Date checkinat, Date checkoutat, ReservesService.PayWay pay, Long price) {
        this.id = id;
        this.hotelid = hotelid;
        this.roomid = roomid;
        this.createat = createat;
        this.username = username;
        this.userphone = userphone;
        this.useremail = useremail;
        this.checkinat = checkinat;
        this.checkoutat = checkoutat;
        this.pay = pay;
        this.price = price;
    }
}