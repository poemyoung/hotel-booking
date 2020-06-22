package com.wxwl.hotelbooking.common.jwt;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public final class JwtMsg {
    public static long EXPIRATION_TIME = 3600_000_000L;
    public  static  String SECRET = "mySecret";
}
