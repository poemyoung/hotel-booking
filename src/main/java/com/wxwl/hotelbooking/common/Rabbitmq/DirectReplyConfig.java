package com.wxwl.hotelbooking.common.Rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rpc请求模式，Remote Process Call 远程过程调用
 */
@Configuration
@Slf4j
public class DirectReplyConfig {

    /**
     * 返回的bean名称由方法名称决定
     * @return
     */
    @Bean
    public Queue directRequest(){
        return new Queue(QueueEnum.DIRECT_REQUEST.getName(),true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(ExchangeEnum.DIRECT_EXCHANGE.getValue());
    }

    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directRequest()).to(directExchange()).with(QueueEnum.DIRECT_REQUEST.getRoutingKey());
    }

    /**
     * 对每个主题定义一个单独的template，以便控制各自的参数
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate directRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        //关键
        template.setUseTemporaryReplyQueues(false);
        template.setReplyAddress("amq.rabbitmq.reply-to");
        template.setUserCorrelationId(true);

        //请求超时时间
        template.setReplyTimeout(10000);
        return template;
    }



}
