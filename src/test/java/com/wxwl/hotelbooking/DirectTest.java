package com.wxwl.hotelbooking;

import com.wxwl.hotelbooking.common.Rabbitmq.DirectProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.concurrent.TimeoutException;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DirectTest {
    @Autowired
    private DirectProducer producer;

    @Test
    public void DirectRPCTest() throws TimeoutException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Thread thread = new Thread(()-> {
                try {
                    producer.sendAndReceive("thread--"+finalI);
                    Thread.sleep((long) finalI);
                } catch (TimeoutException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

}
