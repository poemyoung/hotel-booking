package com.wxwl.hotelbooking.controller;

import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.SignService;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户注册和登录
 */
@RestController
@CrossOrigin
@Api("用户注册和登录api")
public class SignController {

    @Autowired
    SignService signService;

    @PostMapping("/users")
    public Result SingUp(@ModelAttribute  UserTmp userTmp){
        String phone = userTmp.getPhone();
        String password = userTmp.getPassword();
        Result res = new Result();
        if(phone == null || password == null){
            res.setResultCode(ResultCode.PARAM_IS_BLANK);
            return res;
        }
        if(signService.SignUp(phone,password)){
            res.setResultCode(ResultCode.SUCCESS);
            return res;
        }else {
            res.setResultCode(ResultCode.USER_HAS_EXISTED);
            return res;
        }
    }

    @Data
    public static  class UserTmp{
        private String phone;
        private String password;
    }

}
