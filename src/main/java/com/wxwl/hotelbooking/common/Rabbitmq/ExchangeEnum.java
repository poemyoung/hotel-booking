package com.wxwl.hotelbooking.common.Rabbitmq;

import lombok.Getter;

/**
 * 交换器常量
 */
@Getter
public enum ExchangeEnum {
    DIRECT_EXCHANGE("direct"),
    FIXED_EXCHANGE("fixed");

    private String value;
    ExchangeEnum(String value){
        this.value = value;
    }
}
