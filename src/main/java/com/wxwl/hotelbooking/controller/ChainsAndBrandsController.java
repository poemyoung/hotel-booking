package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Brands;
import com.wxwl.hotelbooking.common.domain.Chains;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.mapper.BrandsMapper;
import com.wxwl.hotelbooking.mapper.ChainsMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",maxAge = 3600)
public class ChainsAndBrandsController {
    @Autowired(required = false)
    BrandsMapper brandsMapper;
    @Autowired(required = false)
    ChainsMapper chainsMapper;

    @ApiOperation(value = "获取chains表")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("/chains")
    @ResponseBody
    public Object getChains(){
        List<Chains> chains = chainsMapper.selectAll();
        return Result.success(chains);
    }


    @ApiOperation(value = "获取brands表")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code= 400,message = "Params Error"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @GetMapping("/brands")
    @ResponseBody
    public Object getBrands(){
        List<Brands> brands = brandsMapper.selectAll();
        return Result.success(brands);
    }
}
