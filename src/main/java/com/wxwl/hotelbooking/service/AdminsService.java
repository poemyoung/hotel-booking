package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.*;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.AdminsMapper;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.ReservesMapper;
import com.wxwl.hotelbooking.mapper.RoomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminsService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    ReservesMapper reservesMapper;

    @Autowired(required = false)
    AdminsMapper adminsMapper;

    @Autowired(required = false)
    HotelsMapper mapper;

    @Autowired(required = false)
    RoomsMapper roomsMapper;

    public java.sql.Date stringToDate(String input) throws ParseException {
        Date utilDate = sdf.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    //获取所有订单
    public List<Reserves> getReserves(int hotelId, String checkIn){
        ReservesExample reservesExample = new ReservesExample();
        java.sql.Date checkInTime = null;
        if(checkIn != null) {
            try {
                checkInTime = stringToDate(checkIn);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                return null;
            }
            reservesExample.createCriteria().andHotelidEqualTo(hotelId).andCheckinatGreaterThan(checkInTime);
        }else{
            reservesExample.createCriteria().andHotelidEqualTo(hotelId);
        }
        List<Reserves> reserves = reservesMapper.selectByExample(reservesExample);
        return reserves;
    }

    public Admins getAdminInfo(String hotelName){
        Admins admins = adminsMapper.selectByPrimaryKey(hotelName);
        return admins;
    }

    /**
     * 根据hotelTranslatedName找到相应的hotelId,chainId,brandId并将其信息更新到hotels表
     * @param hotel
     * @return ResultCode
     */
    //1.3 PUT /admins/hotels		管理员提交表单更新本酒店详细信息
    public Hotels updateHotel(Hotels hotel){
        if(mapper.selectByName(hotel.getHoteltranslatedname()) <= 0){    //hotels表中无该条数据
            return null;    //无法修改，必须先添加
        }
        int hotelId = adminsMapper.selectByPrimaryKey(hotel.getHoteltranslatedname()).getHotelid(); //通过admins主键translatedName获取注册时生成的hotelId
        hotel.setHotelid(hotelId);
        int i = mapper.updateByPrimaryKeySelective(hotel);//选择性更新hotel行信息
        return mapper.selectByPrimaryKey(hotelId);
    }

    /**
     * 根据hotelTranslatedName找到相应的酒店hotelId并删除其酒店信息、管理员信息 需先判断本时间内有无正在进行的订单
     * @param name
     * @return Result
     */
    //1.4 DELETE /admins/hotels	管理员删除本账号、本酒店及下属房间的详细信息
    public Result deleteHotel(String name) {
        Result res = new Result();
        Hotels hotels = mapper.selectByTranslatedName(name);    //动态sql通过translatedName查找hotels行
        if(hotels == null){     //hotels表中无该酒店数据（实际不可能发生）
            res.setResultCode(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据表中未找到本酒店数据！");
            return res; //数据为空
        }
        if(ExistUnfinishedReserve(hotels)){    //存在仍未完成的订单
            res.setResultCode(ResultCode.PERMISSION_NO_ACCESS);
            res.setMsg("仍有未完成订单，尚不可删除！");
            return res;
        }else{
            RoomsExample roomsExample = new RoomsExample();
            roomsExample.createCriteria().andHotelidEqualTo(hotels.getHotelid());
            int i = mapper.deleteByPrimaryKey(hotels.getHotelid());     //删除hotels表内行
            int j = adminsMapper.deleteByPrimaryKey(hotels.getHoteltranslatedname());   //删除admins表内行
            int k = roomsMapper.deleteByExample(roomsExample);  //删除hotel下属房间表内行
            res.setResultCode(ResultCode.SUCCESS);
            res.setMsg("删除成功！");
            return res;
        }
    }

    /**
     * 根据hotelTranslatedName找到相应的hotelId,chainId,brandId并将其信息添加到hotels表
     * @param hotel
     * @return Hotels
     */
    //1.5 POST /admins/hotels	管理员提交表单插入一条本酒店信息
    public Hotels addHotel(Hotels hotel){
        if(mapper.selectByName(hotel.getHoteltranslatedname()) > 0){    //hotels表中已有该条数据，(酒店管理一对一，实际不存在)
            return null;    //无法添加，只可以修改
        }
        int hotelId = adminsMapper.selectByPrimaryKey(hotel.getHoteltranslatedname()).getHotelid(); //通过admins主键translatedName获取注册时生成的hotelId
        hotel.setHotelid(hotelId);
        int insert = mapper.insert(hotel);
        return hotel;
    }

    public boolean ExistUnfinishedReserve(Hotels hotels){   //hotel是否存在仍未完成的订单
        Date date = new Date();
        String dtStr = sdf.format(date);
        try{    //获取当前时间2020-06-25
            date = stringToDate(dtStr);
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return true;
        }
        int id = hotels.getHotelid();
        if(mapper.selectUnfinishedReserves(date,id) > 0){   //未完成订单数量大于0
            return true;
        }else{
            return false;
        }
    }
}
