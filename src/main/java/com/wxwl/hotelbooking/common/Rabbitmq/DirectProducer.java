package com.wxwl.hotelbooking.common.Rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * 生产者代码
 */
@Configuration
@Slf4j
public class DirectProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendAndReceive(String request) throws TimeoutException{
        //请求结果
        String res = null;
        //设置当前请求消息的唯一id
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        //直接发送message对象
        MessageProperties messageProperties = new MessageProperties();
        //过期时间10s
        messageProperties.setExpiration("10000");
        messageProperties.setCorrelationId(correlationData.getId());
        Message message = new Message(request.getBytes(),messageProperties);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("direct请求模式下的请求耗时");
        log.info("请求报文：{}" , request);
        Message response = rabbitTemplate.sendAndReceive(ExchangeEnum.DIRECT_EXCHANGE.getValue(),QueueEnum.DIRECT_REQUEST.getRoutingKey(),message,correlationData);
        stopWatch.stop();
        log.info(stopWatch.getLastTaskName()+"：" + stopWatch.getTotalTimeMillis());

        if(response != null){
            res = new String(response.getBody());
            log.info("请求成功，返回的结果为：{}" , res);
        }else {
            log.error("请求超时");
            throw new TimeoutException("请求超时嗷");
        }
        return res;
    }
}
