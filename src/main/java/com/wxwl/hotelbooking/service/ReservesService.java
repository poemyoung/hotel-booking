package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.*;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.ReservesMapper;
import com.wxwl.hotelbooking.mapper.RoomsMapper;
import com.wxwl.hotelbooking.mapper.SearchMapper;
import com.wxwl.hotelbooking.common.domain.Hotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservesService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    ReservesMapper reservesMapper;

    @Autowired(required = false)
    RoomsMapper roomsMapper;

    @Autowired(required = false)
    HotelsMapper hotelsMapper;

    @Autowired(required = false)
    SearchMapper searchMapper;

    public ReservesResult addReserve(Integer hotelId,Integer roomId,String userName,String userPhone,String userEmail,String checkIn,String checkOut,Integer numOfCustomers,String payway){
        // 检查hotelId
        if( hotelsMapper.selectByPrimaryKey(hotelId) == null)
        {
            System.out.println("hotelId错误！");
            return new ReservesResult();
        }

        // 入住/退订时间: String -> Date
        java.sql.Date checkInTime = null;
        java.sql.Date checkOutTime = null;
        try{
            checkInTime = stringToDate(checkIn);
            checkOutTime = stringToDate(checkOut);
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }

        // 支付方式: String -> enum(PayWay)
        PayWay pay = getEnumFromString(PayWay.class,payway);
        //System.out.println(pay);

        // 检查roomId
        if(roomsMapper.selectByPrimaryKey(roomId) == null)
        {
            System.out.println("roomId错误！");
            return new ReservesResult();
        }
        else if(!roomsMapper.selectByPrimaryKey(roomId).getHotelid().equals(hotelId))
        {
            //System.out.println(roomsMapper.selectByPrimaryKey(roomId).getHotelid() + " " + hotelId);
            System.out.println("该房间不在指定酒店内！");
            return new ReservesResult();
        }
        // 检查room是否可容纳numsOfCustomer个顾客
        else if(roomsMapper.selectByPrimaryKey(roomId).getCapacity() < numOfCustomers)
        {
            System.out.println("入住人数大于房间容量！");
            return  new ReservesResult();
        }

        List<Hotels> hotelsList = new ArrayList<>();
        hotelsList.add(hotelsMapper.selectByPrimaryKey(hotelId));

        // 检查room在入住-退房时间段是否有剩余，未解决
        /*if(searchMapper.searchByConditions(checkInTime,checkOutTime,1,hotelsList,1,1).isEmpty()){
            System.out.println("房间剩余数目不足！");
            return new ReservesResult();
        }*/
        if(!ExistEmptyRooms(hotelId,roomId,checkInTime,checkOutTime))
        {
            System.out.println("房间剩余数目不足！");
            return new ReservesResult();
        }

        // 获取房间price
        long price = roomsMapper.selectByPrimaryKey(roomId).getPrice();

        // 获取creatAt为当前系统时间
        Date createAt= new Date();
        Reserves reserve = new Reserves(0,hotelId,roomId,createAt,userName,userPhone,userEmail,checkInTime,checkOutTime,pay,price);

        // insert新订单记录
        reservesMapper.insert(reserve);

        // 返回自增id
        int id = reserve.getId();
        createAt = reserve.getCreateat();
        //System.out.println(createAt);

        // 检查时间是否正确
        if(checkInTime.compareTo(checkOutTime) >= 0){
            return new ReservesResult();
        }else if(id == 0){
            // 检查id是否正常
            System.out.println("返回自增id失败！");
            return  new ReservesResult();
        }
        ReservesResult res = new ReservesResult(id,hotelId,roomId,createAt,userName,userPhone,userEmail,checkInTime,checkOutTime,payway,price,numOfCustomers);
        return res;
    }

    public java.sql.Date stringToDate(String input) throws ParseException {
        // 字符串 -> util.Date
        Date utilDate = sdf.parse(input);
        // util.Date -> sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public enum PayWay{
        Unionpay,Alipay,WeChatpay;
    }

    public static PayWay getEnumFromString(Class<PayWay> c, String string) {
        if( c != null && string != null ) {
            try {
                // 去除所有空格
                return Enum.valueOf(c, string.replaceAll(" ",""));
            } catch(IllegalArgumentException ex) {
                ex.getMessage();
            }
        }
        return null;
    }

    public boolean ExistEmptyRooms(int hotelId,int roomId,Date checkInAt,Date checkOutAt)
    {
        ReservesExample reservesExample = new ReservesExample();
        reservesExample.createCriteria().andCheckinatBetween(checkInAt,checkOutAt).andCheckoutatBetween(checkInAt,checkOutAt);
        List<Reserves> reservesList = reservesMapper.selectByExample(reservesExample);
        if(reservesList.size() < roomsMapper.selectByPrimaryKey(roomId).getCount())
            return true;
        return false;
    }
}