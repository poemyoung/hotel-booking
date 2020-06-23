package com.wxwl.hotelbooking.common.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 根据claims的值返回用户
 */
@Service
public class JwtTokenMsg {
    /**
     * 写入redis
     */
    @Autowired
    private RedisTemplate redisTemplate;

    public  void storeToRedis(Claims claims,String token){
        String userPhone;
        if(claims == null || claims.get("userPhone") == null){
            userPhone = "";
        }else {
            userPhone = (String)claims.get("userPhone");
        }

        if(findExist(token) != null){
            return;
        }
        redisTemplate.opsForValue().set(token,userPhone);
    }

    /**
     * 查找是否有该token已经存在,存在返回用户phone
     */
    public  String findExist(String token) {
        if(redisTemplate == null){
            throw new RedisConnectionFailureException("连接失败");
        }
        String s = (String) redisTemplate.opsForValue().get(token);
        return s;
    }
}
