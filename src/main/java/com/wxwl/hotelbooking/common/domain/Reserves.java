package com.wxwl.hotelbooking.common.domain;

import java.util.Date;

public class Reserves {
    private Integer id;

    private Integer hotelid;

    private Integer roomid;

    private String createat;

    private String username;

    private String userphone;

    private String useremail;

    private Date checkinat;

    private Date checkoutat;

    private String pay;

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

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat == null ? null : createat.trim();
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}