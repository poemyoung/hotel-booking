package com.wxwl.hotelbooking.common.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 */
@Configuration
public class JwtUtil {

    private static long EXPIRATION_TIME = JwtMsg.EXPIRATION_TIME;
    private static String SECRET = JwtMsg.SECRET;// 秘钥

    /**
     * 生成jwtToken
     */
    public static String generateToken(String userPhone,String role) {
        HashMap<String, Object> map = new HashMap<>();
        // you can put any data in the map
        map.put("userPhone", userPhone);
        map.put("role",role);
        Date expire_time = new Date(System.currentTimeMillis()+EXPIRATION_TIME);
        System.out.println(expire_time);
        //加密算法
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(expire_time)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return jwt;
    }
    /**
     * 校验jwtToken
     *
     * @param token
     * @return
     */
    public static String validateToken(String token) {
        if (token != null) {
            Map<String, Object> body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            String userPhone = (String) (body.get("userPhone"));
            if (userPhone == null || userPhone.isEmpty()) {
                throw new TokenValidationException("Wrong User");
            } else {
                return userPhone;
            }
        } else {
            throw new TokenValidationException("Missing token");
        }
    }
    /**
     * 异常类，负责处理token的异常
     */
    static class TokenValidationException extends RuntimeException {
        private static final long serialVersionUID = -7946690694369283250L;

        public TokenValidationException(String msg) {
            super(msg);
        }
    }

    public static long getEXPIRATION_TIME(){
        return JwtUtil.EXPIRATION_TIME;
    }
}
