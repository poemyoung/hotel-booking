package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.HotelsExample;
import com.wxwl.hotelbooking.common.domain.Rooms;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.AdminsMapper;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class HotelsService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired(required = false)
    HotelsMapper mapper;

    @Autowired(required = false)
    SearchMapper sMapper;

    @Autowired(required = false)
    AdminsMapper adminsMapper;

    @Autowired
    RedisTemplate redisTemplate;
    /**
     *搜索核心
     * @param location hotelFormerlyName,hotelName ,hotelTranslatedName,address
     * @param checkIn
     * @param checkOut
     * @return
     */
    public List<HotelResult> findHotels(String location, String checkIn,String checkOut,int num,int pageNo,int pageSize){
        List<HotelResult> nullList = new ArrayList<>();
        int page = 1;
        //检查页号是否正确
        if(pageNo <= 0){
            return nullList;
        }else{
            page = (pageNo-1) * pageSize;
        }

        List<Hotels> hotels = findHotelsByString(location);
        java.sql.Date checkInTime = null;
        java.sql.Date checkOutTime = null;
        try{
            checkInTime = stringToDate(checkIn);
            checkOutTime = stringToDate(checkOut);
        }catch (ParseException e){
              System.out.println(e.getMessage());
              return null;
        }
        //检查时间是否正确
        if(checkInTime.compareTo(checkOutTime) >= 0){
            return nullList;
        }else if(hotels == null){
            //检查酒店列表
            return  nullList;
        }else if(hotels.size() == 0){
            return nullList;
        }
        List<HotelResult> res = sMapper.searchByConditions(checkInTime,checkOutTime,num,hotels,page,pageSize);
        return res;
    }

    /**
     * 判断输入字符串是不是英文
     * @return 是不是
     */
    public boolean isEnglish(String input){
        return input.matches("^[a-zA-Z|\\s]*");
    }

    public java.sql.Date stringToDate(String input) throws ParseException {
        Date utilDate = sdf.parse(input);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //System.out.println(sqlDate);
        return sqlDate;
    }

    /**
     * 根据酒店名找到相应的酒店
     * @param location
     * @return 酒店列表
     */

    public List<Hotels> findHotelsByString(String location){
        if(redisTemplate.hasKey(location)){
            List<Hotels> hotels =redisTemplate.opsForList().range(location,0,-1);
            return hotels;
        }
        String dealInput = "%"+location+"%";
        HotelsExample example = new HotelsExample();
        List<Hotels> hotels = null;
        HotelsExample.Criteria criteria = example.createCriteria();
        HotelsExample.Criteria criteria1 = example.createCriteria();
        HotelsExample.Criteria criteria2 = example.createCriteria();
        //处理location
        if(!isEnglish(location)){
            //中文只搜索译名
            criteria.andHoteltranslatednameLike(dealInput);
            hotels = mapper.selectByExample(example);
        }else if(//按照数据库数据内容，检查关键字
                location.contains("Hotel") || location.contains("SiChuan") || location.contains("Chengdu")){
            //优先搜索酒店名
            criteria.andHotelformerlynameLike(dealInput);
            criteria1.andHotelnameLike(dealInput);
            criteria2.andAddressLike(dealInput);
            example.or(criteria1);
            example.or(criteria2);
            hotels = mapper.selectByExample(example);
        }else {
            criteria.andAddressLike(dealInput);
            criteria1.andHotelformerlynameLike(dealInput);
            criteria2.andHotelnameLike(dealInput);
            example.or(criteria1);
            example.or(criteria2);
            hotels = mapper.selectByExample(example);
        }
        //将查询出的数据缓存进redis
        ListOperations ops = redisTemplate.opsForList();
        ops.leftPushAll(location,hotels);
        return hotels;
    }

    /**
     * 根据酒店id找到相应的酒店并显示其在[in,out]时间段内有空余的房间详情
     * @param hotelId
     * @return rooms:{[]}
     */
    public List<Rooms> findRooms(int hotelId, String checkInTime, String checkOutTime){
        java.sql.Date checkIn = null;
        java.sql.Date checkOut = null;
        try{
            checkIn = stringToDate(checkInTime);
            checkOut = stringToDate(checkOutTime);
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }
        //检查时间是否正确
        if(checkIn.compareTo(checkOut) >= 0){
            return new ArrayList<>();
        }
        List<Rooms> res = sMapper.findRooms(hotelId,checkIn,checkOut);
        return res;
    }

    /**
     * 根据酒店id找到相应的酒店并显示其详情
     * @param hotelId
     * @return hotels:
     */
    public HotelResult findHotel(int hotelId){
        return sMapper.findHotel(hotelId);  //调用xml的findHotel查询
    }


    /**
     * 根据hotelTranslatedName找到相应的酒店hotelId并删除其酒店信息、管理员信息 需先判断本时间内有无正在进行的订单
     * @param name
     * @return Result
     */
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
            int i = mapper.deleteByPrimaryKey(hotels.getHotelid());     //删除hotels表内行
            int j = adminsMapper.deleteByPrimaryKey(hotels.getHoteltranslatedname());   //删除admins表内行
            res.setResultCode(ResultCode.SUCCESS);
            res.setMsg("删除成功！");
            return res;
        }
    }

    public boolean ExistUnfinishedReserve(Hotels hotels){
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

    /**
     * 根据hotelTranslatedName，chainName,brandName找到相应的hotelId,chainId,brandId并将其信息添加到hotels表
     * @param hotel,chainName,brandName
     * @return Hotels
     */
    public Hotels addHotel(Hotels hotel,String chainName,String brandName){
        if(mapper.selectByName(hotel.getHoteltranslatedname()) > 0){    //hotels表中已有该条数据，(酒店管理一对一，实际不存在)
            return null;    //无法添加，只可以修改
        }
        if(brandName == null){  //当brandName为null（表单多选列表填写，实际不存在）
            brandName = "No brand";
        }
        if(chainName == null){  //当chainName为null（表单多选列表填写，实际不存在）
            chainName = "No chain";
        }
        int chainId = mapper.selectChainId(chainName);  //动态sql获取chainId
        int brandId = mapper.selectBrandId(brandName);  //动态sql获取brandId
        int hotelId = adminsMapper.selectByPrimaryKey(hotel.getHoteltranslatedname()).getHotelid(); //通过admins主键translatedName获取注册时生成的hotelId
        hotel.setHotelid(hotelId);
        hotel.setChainid(chainId);
        hotel.setBrandid(brandId);
        int insert = mapper.insert(hotel);
        return hotel;
    }

    /**
     * 根据hotelTranslatedName，chainName,brandName找到相应的hotelId,chainId,brandId并将其信息更新到hotels表
     * @param hotel,chainName,brandName
     * @return ResultCode
     */
    public Hotels updateHotel(Hotels hotel,String chainName,String brandName){
        if(mapper.selectByName(hotel.getHoteltranslatedname()) <= 0){    //hotels表中无该条数据
            return null;    //无法修改，必须先添加
        }
        if(brandName == null){  //当brandName为null（表单多选列表填写，实际不存在）
            brandName = "No brand";
        }
        if(chainName == null){  //当chainName为null（表单多选列表填写，实际不存在）
            chainName = "No chain";
        }
        int chainId = mapper.selectChainId(chainName);  //动态sql获取chainId
        int brandId = mapper.selectBrandId(brandName);  //动态sql获取brandId
        int hotelId = adminsMapper.selectByPrimaryKey(hotel.getHoteltranslatedname()).getHotelid(); //通过admins主键translatedName获取注册时生成的hotelId
        hotel.setHotelid(hotelId);
        hotel.setChainid(chainId);
        hotel.setBrandid(brandId);
        int i = mapper.updateByPrimaryKeySelective(hotel);//选择性更新hotel行信息
        return hotel;
    }
}
