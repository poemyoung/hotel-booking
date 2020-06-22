package com.wxwl.hotelbooking;

import com.wxwl.hotelbooking.common.jwt.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wxwl.hotelbooking")
@ServletComponentScan("com.wxwl.hotelbooking")
public class HotelBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingApplication.class, args);
    }

}
