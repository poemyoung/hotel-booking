package com.wxwl.hotelbooking;

import com.wxwl.hotelbooking.service.HotelsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HotelBookingApplicationTests {
    @Before
    public void init(){
        System.out.println("测试开始");
    }

    @Autowired
    private HotelsService hotelsService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        //Assert.assertNotNull(hotelsService.findHotels("Chengdu","2020-06-20","2020-08-20",2));
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }



}
