package com.wxwl.hotelbooking.common.Rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 消费者
 */
@Component
@RabbitListener(queues = "direct.request")
@Slf4j
public class DirectConsumer {

    @RabbitHandler
    public String onMessage(byte[] message){
        StopWatch stopWatch = new StopWatch("处理计数器");
        stopWatch.start("rpc调用消费者耗时");
        String request = new String(message);
        String response = null;
        log.info("接收到的消息为：" + request);
        response = "hello" + request;
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName()+stopWatch.getTotalTimeMillis()+"ms");
        return response;
    }

}
