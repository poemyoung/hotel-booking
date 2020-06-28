package com.wxwl.hotelbooking;

import com.wxwl.hotelbooking.service.HotelsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    HotelsService hotelsService;

    @Test
    public void test(){
        if(!(hotelsService == null)){
            hotelsService.findHotel(1297);
        }
    }
}
