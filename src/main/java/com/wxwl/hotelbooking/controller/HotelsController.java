package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.domain.Hotels;
import com.wxwl.hotelbooking.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class HotelsController {
    @Autowired
    HotelsService hotelsService;


    @GetMapping("/hotels")
    public String findHotels(ModelMap modelMap,String location,
                             @RequestParam(defaultValue = "2020-6-12") String checkInTime,
                             @RequestParam(defaultValue = "2020-6-13") String checkOutTime,
                             @RequestParam(defaultValue = "2") int numOfCustomers){
        ArrayList<Hotels> list = hotelsService.findHotels(location,checkInTime,checkOutTime,numOfCustomers);
        modelMap.put("hotels",list);
        String msg = "查询成功";
        modelMap.put("msg",msg);
        return "success";
    }

}
