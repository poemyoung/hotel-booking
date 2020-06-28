package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Admins;
import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.AdminsService;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AdminsController {
    @Autowired(required = false)
    AdminsService adminsService;

    @Autowired
    JwtTokenMsg jwtTokenMsg;

    @ApiOperation(value = "管理员查看本酒店全部订单",notes = "酒店id,起始时间")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "hotelId", dataType = "Integer", required = true, value = "酒店id", defaultValue = "1297"),
            @ApiImplicitParam(paramType = "query", name = "checkIn", dataType = "String", required = false, value = "入住时间")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("/admins/orders/{id}")
    //1.1 GET /admins/reserves	管理员查看本酒店所有订单详细信息
    public Object GetReserves(@PathVariable("id")int hotelId,String checkIn){
        List<Reserves> reserves = adminsService.getReserves(hotelId, checkIn);
        return Result.success(reserves);
    }

    @ApiOperation(value = "管理员查看本酒店详细信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("admins")
    //1.2 GET /admins	管理员查看管理员账号信息,本酒店及下属房间所有详细信息
    public Result getAdmins(@RequestHeader String Authorization){
        Result res;
        String hotelTranslatedName = jwtTokenMsg.getId(Authorization);
        String role = jwtTokenMsg.getRole(Authorization);
        if(role == null || !role.equals("admin") || hotelTranslatedName == null){
            return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
        }
        //获取admin数据行
        Admins aAdmin =  adminsService.getAdminInfo(hotelTranslatedName);
        int hotelId = aAdmin.getHotelid();
        return aAdmin.getHotelid() == null ? Result.failure(ResultCode.USER_NOT_EXIST) :  Result.success(aAdmin);
    }

    @ApiOperation(value = "酒店管理员更新本酒店信息",notes = "Hotel信息表单")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @PutMapping("/admins/hotels")
    @ResponseBody
    //1.3 PUT /admins/hotels		管理员提交表单更新本酒店详细信息
    public Object updateHotel(@RequestHeader String Authorization,@ModelAttribute HotelTmp hotelTmp){
        Result res = new Result();
        String hotelTranslatedName = jwtTokenMsg.getId(Authorization);  //获取tokenId:translatedName
        Hotels hotels = hotelTmp.toHotels();    //将hotel信息表单转换为hotel对象
        hotels.setHoteltranslatedname(hotelTranslatedName);
        Hotels hotel = adminsService.updateHotel(hotels);
        if(hotel == null){  //hotels表中未找到该行，必须先添加才能更新
            res.setResultCode(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据表中无本酒店信息，请先添加信息！");
            return res;
        }else{
            return res.success(hotel);
        }
    }

    @ApiOperation(value = "管理员删除本酒店信息",notes = "hotelTranslatedName")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @DeleteMapping("/admins/hotels")
    @ResponseBody
    //1.4 DELETE /admins/hotels	管理员删除本账号、本酒店及下属房间的详细信息
    public Object deleteHotel(@RequestHeader String Authorization){
        String name = jwtTokenMsg.getId(Authorization); //获取token的Id
        return adminsService.deleteHotel(name); //返回ResultCode
    }


    @ApiOperation(value = "管理员添加一条本酒店信息",notes = "Hotel信息表单")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @PostMapping("/admins/hotels")
    @ResponseBody
    //1.5 POST /admins/hotels	管理员提交表单插入一条本酒店信息
    public Object addHotel(@RequestHeader String Authorization,@ModelAttribute HotelTmp hotelTmp){
        Result res = new Result();
        String hotelTranslatedName = jwtTokenMsg.getId(Authorization);  //读取token中的Admin的id->hotelTranslatedName
        Hotels hotel = hotelTmp.toHotels(); //将body中读取的表单信息转换为hotel对象
        hotel.setHoteltranslatedname(hotelTranslatedName);
        Hotels hotels = adminsService.addHotel(hotel);  //插入一条酒店数据行以Hotels对象返回
        if(hotels == null){ //该hotel在hotels表中已存在，只可更改不可添加
            res.setResultCode(ResultCode.DATA_ALREADY_EXISTED);
            res.setMsg("本酒店信息在数据表中已存在，只可更改不可再添加！");
            return res;
        }
        return Result.success(hotels);
    }
    @Data
    public static  class HotelTmp{
        private Integer chainId;
        private Integer brandId;
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

        public Integer getChainId() {
            return chainId;
        }

        public HotelTmp setChainId(Integer chainId) {
            this.chainId = chainId;
            return this;
        }

        public Integer getBrandId() {
            return brandId;
        }

        public HotelTmp setBrandId(Integer brandId) {
            this.brandId = brandId;
            return this;
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
            return new Hotels(null,chainId,brandId,hotelname,hotelformerlyname,null,address,zipcode,starrating,longitude,latitude,
                    checkIn,checkOut,numberRooms,numberFloors,yearopened,yearrenovated,photoone,phototwo,photothree,
                    photofour,photofive,overview,minPrice,numberOfReviews,averageRating);
        }
    }


}
