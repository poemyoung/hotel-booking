package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Reserves;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.service.AdminsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminsController {
    @Autowired(required = false)
    AdminsService adminsService;

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
    @GetMapping("/admins/{id}")
    public Object GetReserves(@PathVariable("id")int hotelId,String checkIn){
        List<Reserves> reserves = adminsService.getReserves(hotelId, checkIn);
        return Result.success(reserves);
    }

}
