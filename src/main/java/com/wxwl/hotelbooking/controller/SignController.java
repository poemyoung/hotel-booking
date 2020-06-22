package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.jwt.JwtUtil;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.SignService;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 用户注册和登录
 */
@RestController
@CrossOrigin
@Api("用户注册和登录api")
public class SignController {

    @Autowired
    SignService signService;

    @PostMapping("/users/register")
    public Result SignUp(@ModelAttribute  UserTmp userTmp){
        String phone = userTmp.getPhone();
        String password = userTmp.getPassword();
        Result res = new Result();
        if(phone == null || password == null){
            res.setResultCode(ResultCode.PARAM_IS_BLANK);
            return res;
        }
        if(signService.signUp(phone,password)){
            res.setResultCode(ResultCode.SUCCESS);
        }else {
            res.setResultCode(ResultCode.USER_HAS_EXISTED);
        }
        return res;
    }

    @PostMapping("/users/login")
    public Result SignIn(@ModelAttribute UserTmp userTmp){
        Result res = new Result();
        if(userTmp == null||userTmp.getPhone() == null){
            res.setResultCode(ResultCode.PARAM_IS_BLANK);
            return res;
        }
        ResultCode code = signService.signIn(userTmp.getPhone(),userTmp.getPassword());
        res.setResultCode(code);
        if(code == ResultCode.SUCCESS){
            String jwt = JwtUtil.generateToken(userTmp.getPhone());
            HashMap<String,String> map = new HashMap<>();
            map.put("token",jwt);
            res = Result.success(map);
        }
        return res;
    }

    @Data
    public static  class UserTmp{
        private String phone;
        private String password;

        public String getPhone() {
            return phone;
        }
        public String getPassword() {
            return password;
        }
    }
}
