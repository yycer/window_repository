package com.frankie.demo.optional;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2019/11/11 21:16
 */
@Setter
@Getter
public class Order {

    private String        orderId;
    private BigDecimal    total;
    private UserInfo      userInfo;
}
