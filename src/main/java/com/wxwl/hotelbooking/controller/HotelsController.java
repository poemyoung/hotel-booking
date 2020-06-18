package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.HotelResult;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.HotelsService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Api("酒店搜索相关Api")
public class HotelsController {
    @Autowired
    HotelsService hotelsService;

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
    @GetMapping("/accommodations")
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
}
