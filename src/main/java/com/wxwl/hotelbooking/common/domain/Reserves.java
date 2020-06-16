package com.wxwl.hotelbooking.common.domain;

import java.util.Date;

public class Reserves {
    private Integer id;

    private Integer hotelId;

    private Integer roomId;

    private String createAt;

    private String userName;

    private String userPhone;

    private String userEmail;

    private Date checkInAt;

    private Date checkOutAt;

    private String pay;

    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelid() {
        return hotelId;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelId = hotelid;
    }

    public Integer getRoomid() {
        return roomId;
    }

    public void setRoomid(Integer roomid) {
        this.roomId = roomid;
    }

    public String getCreateat() {
        return createAt;
    }

    public void setCreateat(String createat) {
        this.createAt = createat == null ? null : createat.trim();
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userPhone;
    }

    public void setUserphone(String userphone) {
        this.userPhone = userphone == null ? null : userphone.trim();
    }

    public String getUseremail() {
        return userEmail;
    }

    public void setUseremail(String useremail) {
        this.userEmail = useremail == null ? null : useremail.trim();
    }

    public Date getCheckinat() {
        return checkInAt;
    }

    public void setCheckinat(Date checkinat) {
        this.checkInAt = checkinat;
    }

    public Date getCheckoutat() {
        return checkOutAt;
    }

    public void setCheckoutat(Date checkoutat) {
        this.checkOutAt = checkoutat;
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