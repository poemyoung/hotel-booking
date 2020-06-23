package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.ReservesResult;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.ReservesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api("预订酒店相关Api")

public class ReservesController {
    @Autowired
    ReservesService reservesService;

    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })

    @RequestMapping("/reserves")
    @ResponseBody
    public Result addReserve(Integer hotelId,Integer roomId,String userName,String userPhone,String userEmail,String checkInTime,String checkOutTime,Integer numOfCustomers,String pay) {
        ReservesResult reservesResult;
        Result res;

        // 判断空
        if(hotelId==null||roomId==null||userName==null||userPhone==null||checkInTime==null||checkOutTime==null)
        {
            System.out.println("必要条件输入为空！");
            //res.failure(ResultCode.RESULE_DATA_NONE);
            res = Result.failure(ResultCode.RESULE_DATA_NONE);
            res.setMsg("数据为空！");
            return res;
        }

        // 设置默认值
        if(userEmail == null)
            userEmail = "";
        if(numOfCustomers == null)
            numOfCustomers = 2;
        if(pay == null)
            pay = "Unionpay";

        reservesResult = reservesService.addReserve(hotelId,roomId,userName,userPhone,userEmail,checkInTime,checkOutTime,numOfCustomers,pay);
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
