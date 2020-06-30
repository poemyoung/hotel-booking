package com.wxwl.hotelbooking.controller;


import com.wxwl.hotelbooking.common.domain.Users;
import com.wxwl.hotelbooking.common.jwt.JwtTokenMsg;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.service.UsersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上载
 */
@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",maxAge = 3600)
public class UsersInfoController {
    @Autowired
    JwtTokenMsg jwtTokenMsg ;

    @Autowired
    UsersInfoService usersInfoService;

    @PutMapping("/users")
    public Result modifyUserInfo(@RequestHeader String Authorization,
                       @RequestParam(value = "avatar",defaultValue = "default1.jpg") MultipartFile avatar,
                       @RequestParam(defaultValue = "") String idCard,
                       @RequestParam(defaultValue = "") String pwd,
                       @RequestParam(defaultValue = "") String email,
                       @RequestParam(defaultValue = "false") String smoke,
                       @RequestParam(defaultValue = "") String levelPref,
                       @RequestParam(defaultValue = "") String pauPref,
                       @RequestParam(defaultValue = "") String accessNeed,
                       @RequestParam(defaultValue = "") String userName
                     ) {
        Result res = new Result();
        String phone  = jwtTokenMsg.getId(Authorization);
        String role = jwtTokenMsg.getRole(Authorization);
        if(role == null || !role.equals("user")||phone == null){
            res = Result.failure(ResultCode.PERMISSION_NO_ACCESS);
            return res;
        }
        Map<String,String> map = new HashMap<>();
        map.put("idCard",idCard);
        map.put("pwd",pwd);
        map.put("email",email);
        map.put("smoke",smoke);
        map.put("levelPref",levelPref);
        map.put("pauPref",pauPref);
        map.put("accessNeed",accessNeed);
        map.put("userName",userName);
        map.put("phone",phone);
        if(!usersInfoService.modifyUserInfo(map, avatar)){
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(ResultCode.SUCCESS);
        }

        @GetMapping("/users/{id}")
        public Result getUserInfo(@RequestHeader String Authorization, @PathVariable String id){
            Result res;
            String phone  = jwtTokenMsg.getId(Authorization);
            String role = jwtTokenMsg.getRole(Authorization);
            if(role == null || !role.equals("user")||phone == null){
                res = Result.failure(ResultCode.PERMISSION_NO_ACCESS);
                return res;
            }
            Users aUser = usersInfoService.getUserInfo(phone);
            if(aUser == null){
                res = Result.failure(ResultCode.USER_NOT_EXIST);
            }else {
                res = Result.success(aUser);
            }
            return res;
        }
    }

