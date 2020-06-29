package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.domain.ReservesResult;
import com.wxwl.hotelbooking.common.domain.Rooms;
import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.HotelsMapper;
import com.wxwl.hotelbooking.mapper.RoomsMapper;
import com.wxwl.hotelbooking.service.ReservesService;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Api("预订酒店相关Api")

public class ReservesController {
    @Autowired
    ReservesService reservesService;

    @Autowired
    JwtTokenMsg jwtTokenMsg;

    @Autowired(required = false)
    HotelsMapper hotelsMapper;

    @Autowired(required = false)
    RoomsMapper roomsMapper;

    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })

    // 用户查看订单
    @GetMapping("/reserves")
    public Result UserGetReserves(@RequestHeader String Authorization) {
        Result res;

        // 判断用户类型
        if(!jwtTokenMsg.getRole(Authorization).equals("user"))
        {
            System.out.println("你不是用户！");
            res = Result.failure(ResultCode.DATA_IS_WRONG);
            res.setMsg("你不是用户！");
            return res;
        }

        // 从Redis中获得用户电话
        String userPhone = jwtTokenMsg.getId(Authorization);


        //
        List<Reserves> reserves = reservesService.userGetReserves(userPhone);
        System.out.println("?空");
        return getResult(reserves);
    }

    private Result getResult(List<Reserves> reserves) {
        Result res;
        List<OrderDetail> orderDetails = new ArrayList<>(setOrderDetails(reserves));

        if(orderDetails.size() == 0){
            //内部错误
            res = Result.failure(ResultCode.RESULE_DATA_NONE);
            res.setMsg("暂无订单!");
        }
        else {
            res = Result.success(orderDetails);
            System.out.println("订单查询成功！");
        }
        return res;
    }

    // 酒店管理员查看订单
    @GetMapping("/admins/reserves")
    public Result adminGetReserves(@RequestHeader String Authorization) {
        Result res;

        // 判断角色是否为管理员
        if(!jwtTokenMsg.getRole(Authorization).equals("admin"))
        {
            System.out.println("角色为：" + jwtTokenMsg.getRole(Authorization));
            res = Result.failure(ResultCode.DATA_IS_WRONG);
            res.setMsg("你不是管理员！");
            return res;
        }else if(jwtTokenMsg.getId(Authorization) == null) {
            System.out.println("酒店名为空！");
            res = Result.failure(ResultCode.RESULE_DATA_NONE);
            res.setMsg("酒店名为空");
        }

        // 获取Auth信息
        String hotelName = jwtTokenMsg.getId(Authorization);

        //System.out.println("hotelName:"+hotelName);
        List<Reserves> reserves = reservesService.adminGetReserves(hotelName);

        return getResult(reserves);
    }

    // 用户下订单
    @PostMapping("/reserves")

    @ApiOperation(value = "根据条件显示某酒店详情",notes = "酒店id,入住时间和离店时间")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "hotelId",dataType = "Integer",required = true,value = "酒店id",defaultValue = "1297"),
            @ApiImplicitParam(paramType = "body",name = "roomId",dataType = "String",required = true,value = "房间id",defaultValue = "1"),
            @ApiImplicitParam(paramType = "body",name = "checkInTime",dataType = "String",required = true,value = "入住时间",defaultValue = "2020-6-12"),
            @ApiImplicitParam(paramType = "body",name = "checkOutTime",dataType = "String",required = true,value = "离店时间",defaultValue = "2020-6-13"),
    })

    public Result addReserve( @RequestHeader String Authorization,
                             Integer hotelId,
                              Integer roomId,
                              String checkInTime,
                              String checkOutTime,
                              Integer numOfCustomers,
                              String pay) {
        ReservesResult reservesResult;
        Result res;
        // 获取Auth信息
        String userPhone = jwtTokenMsg.getId(Authorization);
        // 判断空
        if(hotelId==null||roomId==null||userPhone == null||checkInTime==null||checkOutTime==null)
        {
            System.out.println("必要条件输入为空！");
            //res.failure(ResultCode.RESULE_DATA_NONE);
            res = Result.failure(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据为空！");
            return res;
        }
        // 设置默认值
        if(numOfCustomers == null)
            numOfCustomers = 2;
        if(pay == null)
            pay = "Unionpay";

        reservesResult = reservesService.addReserve(hotelId,roomId,userPhone,checkInTime,checkOutTime,numOfCustomers,pay);

        if(reservesResult == null){
            //内部错误
            res = Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
            res.setMsg("参数类型错误！");
        }else if (reservesResult.getId() == null){
            res = Result.failure(ResultCode.DATA_IS_WRONG);
            res.setMsg("数据有误！");
        }
        else {
            res = Result.success(reservesResult);
            System.out.println("订单添加成功！");
        }


        return res;

    }

    public List<OrderDetail> setOrderDetails(List<Reserves> reserves){
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (Reserves reserve:reserves)
        {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(reserve.getId());
            orderDetail.setCheckinat(reserve.getCheckinat());
            orderDetail.setCheckoutat(reserve.getCheckoutat());
            orderDetail.setCreateat(reserve.getCreateat());
            orderDetail.setPay(reserve.getPay());
            orderDetail.setPrice(reserve.getPrice());
            orderDetail.setUseremail(reserve.getUseremail());
            orderDetail.setUsername(reserve.getUsername());
            orderDetail.setUserphone(reserve.getUserphone());
            orderDetail.setHotels(hotelsMapper.selectByPrimaryKey(reserve.getHotelid()));
            orderDetail.setRooms(roomsMapper.selectByPrimaryKey(reserve.getRoomid()));

            orderDetails.add(orderDetail);
        }

        return orderDetails;
    }

    @Data
    private class OrderDetail {
        private Rooms rooms;

        private Hotels hotels;

        private Integer id;

        private Date createat;

        private String username;

        private String userphone;

        private String useremail;

        private Date checkinat;

        private Date checkoutat;

        private ReservesService.PayWay pay;

        private Long price;

        public Rooms getRooms() {
            return rooms;
        }

        public void setRooms(Rooms rooms) {
            this.rooms = rooms;
        }

        public Hotels getHotels() {
            return hotels;
        }

        public void setHotels(Hotels hotels) {
            this.hotels = hotels;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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
            this.username = username;
        }

        public String getUserphone() {
            return userphone;
        }

        public void setUserphone(String userphone) {
            this.userphone = userphone;
        }

        public String getUseremail() {
            return useremail;
        }

        public void setUseremail(String useremail) {
            this.useremail = useremail;
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
            this.pay = pay;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public OrderDetail(Rooms rooms, Hotels hotels, Integer id, Date createat, String username, String userphone, String useremail, Date checkinat, Date checkoutat, ReservesService.PayWay pay, Long price) {
            this.rooms = rooms;
            this.hotels = hotels;
            this.id = id;
            this.createat = createat;
            this.username = username;
            this.userphone = userphone;
            this.useremail = useremail;
            this.checkinat = checkinat;
            this.checkoutat = checkoutat;
            this.pay = pay;
            this.price = price;
        }

        public OrderDetail() {
        }
    }
}
