package com.wxwl.hotelbooking.common.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

public  void storeToRedis(Claims claims,String token) {
    String userPhone;
    String role;
    System.out.println("storing to redis");
        if (claims == null || claims.get("userPhone") == null || claims.get("role") == null) {
            userPhone = "";
            role = "";
        } else {
            userPhone = (String) claims.get("userPhone");
            role = (String) claims.get("role");
        }
        if (getId(token) != null) {
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("role", role);
        map.put("id", userPhone);
        redisTemplate.opsForHash().putAll("Bearer " + token, map);
}
    /**
     * 查找是否有该token已经存在,存在返回用户phone
     */
    public  String getId(String token) {
        if(redisTemplate == null){
            throw new RedisConnectionFailureException("连接失败");
        }

        String s = (String) redisTemplate.opsForHash().get(token,"id");
        return s;
    }

    public String getRole(String token){
        if(redisTemplate == null){
            throw new RedisConnectionFailureException("连接失败");
        }
        String role = (String)redisTemplate.opsForHash().get(token,"role");
        return role;
    }
}
