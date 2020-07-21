package com.wxwl.hotelbooking.common.Rabbitmq;

import lombok.Getter;

/**
 * 队列枚举常量
 */
@Getter
public enum QueueEnum {
    DIRECT_REQUEST("direct.request","direct");

    //队列名称
    private String name;
    //队列路由键
    private String routingKey;

    QueueEnum(String name,String routingKey){
        this.name = name;
        this.routingKey = routingKey;
    }
}
