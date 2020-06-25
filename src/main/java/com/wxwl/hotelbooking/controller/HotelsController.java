package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.Rooms;
import com.wxwl.hotelbooking.common.domain.RoomsResult;
import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.HotelsService;

import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api("酒店搜索相关Api")
public class HotelsController {
    @Autowired
    HotelsService hotelsService;

    @Autowired
    JwtTokenMsg jwtTokenMsg;

    @ApiOperation(value = "根据条件搜索酒店",notes = "酒店名或地址，入住时间和离店时间")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="location",dataType = "String",required = true,value = "酒店地点或名称",defaultValue = "Chengdu"),
            @ApiImplicitParam(paramType = "query",name = "checkInTime",dataType = "String",required = true,value = "入住时间",defaultValue = "2020-6-12"),
            @ApiImplicitParam(paramType = "query",name="checkOutTime",dataType = "String",required = true,value = "离店时间",defaultValue = "2020-6-13"),
            @ApiImplicitParam(paramType = "query",name="numOfCustomers",dataType = "Integer",required = true,value = "入住人数",defaultValue = "2"),
            @ApiImplicitParam(paramType = "query",name="pageNo",dataType = "Integer",required = true,value = "页号",defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name="pageSize",dataType = "Integer",required = true,value = "每页条数",defaultValue = "-1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("/hotels")
    public Result findHotels(@RequestParam(defaultValue = "Chengdu") String location,
                                             @RequestParam(defaultValue = "2020-6-12") String checkInTime,
                                             @RequestParam(defaultValue = "2020-6-13") String checkOutTime,
                                             @RequestParam(defaultValue = "2") int numOfCustomers,
                                             @RequestParam(defaultValue = "1") int pageNo,
                                             @RequestParam(defaultValue = "-1") int pageSize){
        List<HotelResult> list =  hotelsService.findHotels(location,checkInTime,checkOutTime,numOfCustomers,pageNo,pageSize);
        Result res ;
        if(list == null){
            //内部错误
            res = Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
            res.setMsg("日期格式错误！");
        }else if(list.size() == 0){
            res = Result.failure(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据未找到");
        }else {
            res = Result.success(list);
        }
        return res;
    }

    @ApiOperation(value = "根据条件显示某酒店详情",notes = "酒店id,入住时间和离店时间")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="hotelId",dataType = "Integer",required = true,value = "酒店id",defaultValue = "1297"),
            @ApiImplicitParam(paramType = "query",name = "checkInTime",dataType = "String",required = true,value = "入住时间",defaultValue = "2020-6-12"),
            @ApiImplicitParam(paramType = "query",name="checkOutTime",dataType = "String",required = true,value = "离店时间",defaultValue = "2020-6-13")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("/hotels/{id}")
    // /accommodations/id?hotelId=1297&checkInTime=2020-06-14&checkOutTime=2020-06-21
    //查看酒店A详情
    public Object showHotel(@PathVariable("id") int hotelId,
                            @RequestParam(defaultValue = "2020-6-12") String checkInTime,
                            @RequestParam(defaultValue = "2020-6-13") String checkOutTime){
        Result res;
        RoomsResult roomsResult = new RoomsResult();
        HotelResult hotel = hotelsService.findHotel(hotelId);   //hotel存放hotelId的酒店信息
        roomsResult.setHotel(hotel);
        List<Rooms> rooms = hotelsService.findRooms(hotelId,checkInTime,checkOutTime);  //rooms存放hotelId的房间信息
        roomsResult.setRooms(rooms);
        res = Result.success(roomsResult);
        return res;
    }

    @ApiOperation(value = "酒店管理员删除本酒店信息",notes = "hotelTranslatedName")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @DeleteMapping("/admins/hotels")
    @ResponseBody
    public Object deleteHotel(@RequestHeader String Authorization){
        String name = jwtTokenMsg.getId(Authorization); //获取token的Id
        return hotelsService.deleteHotel(name);
    }


    @ApiOperation(value = "酒店管理员新添加一条酒店信息",notes = "Hotel信息表单")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @PostMapping("/admins/hotels")
    @ResponseBody
    public Object addHotel(@RequestHeader String Authorization,@ModelAttribute HotelTmp hotelTmp){
        Result res = new Result();
        String hotelTranslatedName = jwtTokenMsg.getId(Authorization);  //读取token中的Admin的id->hotelTranslatedName
        Hotels hotel = hotelTmp.toHotels(); //将body中读取的表单信息转换为hotel对象
        hotel.setHoteltranslatedname(hotelTranslatedName);
        Hotels hotels = hotelsService.addHotel(hotel, hotelTmp.getChainName(), hotelTmp.getBrandName());
        if(hotels == null){ //该hotel在hotels表中已存在，只可更改不可添加
            res.setResultCode(ResultCode.DATA_ALREADY_EXISTED);
            res.setMsg("本酒店信息在数据表中已存在，只可更改不可再添加！");
            return res;
        }
        return Result.success(hotels);
    }

    @ApiOperation(value = "酒店管理员更新本酒店信息",notes = "Hotel信息表单")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @PutMapping("/admins/hotels")
    @ResponseBody
    public Object updateHotel(@RequestHeader String Authorization,@ModelAttribute HotelTmp hotelTmp){
        Result res = new Result();
        String hotelTranslatedName = jwtTokenMsg.getId(Authorization);  //获取tokenId:translatedName
        Hotels hotels = hotelTmp.toHotels();    //将hotel信息表单转换为hotel对象
        hotels.setHoteltranslatedname(hotelTranslatedName);
        Hotels hotel = hotelsService.updateHotel(hotels, hotelTmp.getChainName(), hotelTmp.getBrandName());
        if(hotel == null){  //hotels表中未找到该行，必须先添加才能更新
            res.setResultCode(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据表中无本酒店信息，请先添加信息！");
            return res;
        }else{
            return res.success(hotel);
        }
    }

    @Data
    public static  class HotelTmp{
        private String chainName;
        private String brandName;
        private String hotelname;
        private String hotelformerlyname;
        private String address;
        private Integer zipcode;
        private Double starrating;
        private Double longitude;
        private Double latitude;
        private String checkIn;
        private String checkOut;
        private Integer numberRooms;
        private Integer numberFloors;
        private Integer yearopened;
        private Integer yearrenovated;
        private String photoone;
        private String phototwo;
        private String photothree;
        private String photofour;
        private String photofive;
        private String overview;
        private Integer minPrice;
        private Integer numberOfReviews;
        private Double averageRating;

        public String getChainName() {
            return chainName;
        }

        public void setChainName(String chainName) {
            this.chainName = chainName;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getHotelname() {
            return hotelname;
        }

        public void setHotelname(String hotelname) {
            this.hotelname = hotelname;
        }

        public String getHotelformerlyname() {
            return hotelformerlyname;
        }

        public void setHotelformerlyname(String hotelformerlyname) {
            this.hotelformerlyname = hotelformerlyname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getZipcode() {
            return zipcode;
        }

        public void setZipcode(Integer zipcode) {
            this.zipcode = zipcode;
        }

        public Double getStarrating() {
            return starrating;
        }

        public void setStarrating(Double starrating) {
            this.starrating = starrating;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public String getCheckIn() {
            return checkIn;
        }

        public void setCheckIn(String checkIn) {
            this.checkIn = checkIn;
        }

        public String getCheckOut() {
            return checkOut;
        }

        public void setCheckOut(String checkOut) {
            this.checkOut = checkOut;
        }

        public Integer getNumberRooms() {
            return numberRooms;
        }

        public void setNumberRooms(Integer numberRooms) {
            this.numberRooms = numberRooms;
        }

        public Integer getNumberFloors() {
            return numberFloors;
        }

        public void setNumberFloors(Integer numberFloors) {
            this.numberFloors = numberFloors;
        }

        public Integer getYearopened() {
            return yearopened;
        }

        public void setYearopened(Integer yearopened) {
            this.yearopened = yearopened;
        }

        public Integer getYearrenovated() {
            return yearrenovated;
        }

        public void setYearrenovated(Integer yearrenovated) {
            this.yearrenovated = yearrenovated;
        }

        public String getPhotoone() {
            return photoone;
        }

        public void setPhotoone(String photoone) {
            this.photoone = photoone;
        }

        public String getPhototwo() {
            return phototwo;
        }

        public void setPhototwo(String phototwo) {
            this.phototwo = phototwo;
        }

        public String getPhotothree() {
            return photothree;
        }

        public void setPhotothree(String photothree) {
            this.photothree = photothree;
        }

        public String getPhotofour() {
            return photofour;
        }

        public void setPhotofour(String photofour) {
            this.photofour = photofour;
        }

        public String getPhotofive() {
            return photofive;
        }

        public void setPhotofive(String photofive) {
            this.photofive = photofive;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public Integer getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(Integer minPrice) {
            this.minPrice = minPrice;
        }

        public Integer getNumberOfReviews() {
            return numberOfReviews;
        }

        public void setNumberOfReviews(Integer numberOfReviews) {
            this.numberOfReviews = numberOfReviews;
        }

        public Double getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(Double averageRating) {
            this.averageRating = averageRating;
        }

        public Hotels toHotels(){
            return new Hotels(null,null,null,hotelname,hotelformerlyname,null,address,zipcode,starrating,longitude,latitude,
                    checkIn,checkOut,numberRooms,numberFloors,yearopened,yearrenovated,photoone,phototwo,photothree,
                    photofour,photofive,overview,minPrice,numberOfReviews,averageRating);
        }
    }
}
