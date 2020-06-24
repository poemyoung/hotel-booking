package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.domain.ReservesResult;
import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import com.wxwl.hotelbooking.common.jwt.JwtUtil;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.ReservesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api("预订酒店相关Api")

public class ReservesController {
    @Autowired
    ReservesService reservesService;

    @Autowired
    JwtTokenMsg jwtTokenMsg;

    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })

    // 用户查看订单
    @GetMapping("/reserves")
    public Result UsergetReserves(@RequestHeader String Authorization){
        // 从Redis中获得用户电话
        String userPhone = jwtTokenMsg.getId(Authorization);

        //
        List<Reserves> reserves = reservesService.userGetReserves(userPhone);

        Result res;
        if(reserves == null){
            //内部错误
            res = Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
            res.setMsg("参数类型错误！");
        }
        else {
            res = Result.success(reserves);
            System.out.println("订单查询成功！");
        }
        return res;
    }

    // 酒店管理员查看订单
    @GetMapping("/admins/{id}")
    public Result adminGetReserves(@RequestHeader String Authorization, @PathVariable String id){

        System.out.println("管理员查看订单controller");
        Reserves reserves = reservesService.adminGetReserves(id);

        Result res;
        if(reserves == null){
            //内部错误
            res = Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
            res.setMsg("参数类型错误！");
        }
        else {
            res = Result.success(reserves);
            System.out.println("订单查询成功！");
        }
        return res;
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
        // Result result = null;
        //System.out.println(hotelId);

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
}
