package com.wxwl.hotelbooking.service;

import com.wxwl.hotelbooking.common.domain.Users;
import com.wxwl.hotelbooking.common.utils.FileDealer;
import com.wxwl.hotelbooking.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 用户信息修改
 */
@Service
public class UsersInfoService {
    @Autowired
    FileDealer fileDealer;

    @Autowired(required = false)
    UsersMapper usersMapper;

    public boolean modifyUserInfo(Map<String,String>map, MultipartFile avatar){
        String avatarName = fileDealer.addFile(avatar,map.get("phone")+".jpg");
        Users aUser = new Users();
        aUser.setIdcard(map.get("idCard"));
        aUser.setPwd(map.get("pwd"));
        aUser.setEmail(map.get("email"));
        if(map.get("smoke").equals("false")){
            aUser.setSmoke(false);
        }else {
            aUser.setSmoke(true);
        }
        aUser.setLevelpref(map.get("levelPref"));
        aUser.setAccessneed(map.get("accessNeed"));
        aUser.setUsername(map.get("userName"));
        aUser.setPhone(map.get("phone"));
        aUser.setAvatar(avatarName);
       if(usersMapper.updateByPhone(aUser) == 1){
           return true;
       }else {
           return false;
       }
    }

    public Users getUserInfo(String phone){
        Users aUser = usersMapper.selectUserByPhone(phone);
        String imagePath = fileDealer.findFile(aUser.getAvatar());
        aUser.setAvatar(imagePath);
        return aUser;
    }
}
