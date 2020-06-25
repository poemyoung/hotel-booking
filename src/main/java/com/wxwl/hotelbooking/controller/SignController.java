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

    @PostMapping("/register")
    public Result SignUp(@RequestHeader("X-Role") String role, @ModelAttribute  UserTmp userTmp){
        String phone = userTmp.getPhone();
        String password = userTmp.getPassword();
        Result res = new Result();
        if(phone == null || password == null){
            res.setResultCode(ResultCode.PARAM_IS_BLANK);
            return res;
        }
        if(role.equals("user")) {
            if (signService.userSignUp(phone, password)) {
                res.setResultCode(ResultCode.SUCCESS);
            } else {
                res.setResultCode(ResultCode.USER_HAS_EXISTED);
            }
        }else if(role.equals("admin")){
            if (signService.adminSignUp(phone, password)) {
                res.setResultCode(ResultCode.SUCCESS);
            } else {
                res.setResultCode(ResultCode.USER_HAS_EXISTED);
            }
        }
        return res;
    }

    @PostMapping("/login")
    public Result SignIn(@RequestHeader("X-Role") String role,@ModelAttribute UserTmp userTmp){
        Result res = new Result();
        if(userTmp == null||userTmp.getPhone() == null){
            res.setResultCode(ResultCode.PARAM_IS_BLANK);
            return res;
        }
        ResultCode code = null;
        if(role.equals("user"))
            code = signService.userSignIn(userTmp.getPhone(),userTmp.getPassword());
        else if (role.equals("admin"))
            code = signService.adminLoginIn(userTmp.getPhone(),userTmp.getPassword());

        res.setResultCode(code);
        if(code == ResultCode.SUCCESS){
            String jwt = JwtUtil.generateToken(userTmp.getPhone(),role);
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
