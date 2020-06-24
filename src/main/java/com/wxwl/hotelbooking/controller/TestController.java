package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试路径
 */
@RestController
@CrossOrigin
public class TestController {
    @Autowired
    JwtTokenMsg jwtTokenMsg;
    @PostMapping("/test")
    public void test(@RequestHeader("Authorization") String token){
        String role = jwtTokenMsg.getRole(token);
        String id = jwtTokenMsg.getId(token);
        System.out.println("role = "+role);
        System.out.println("id="+ id);
    }

}
