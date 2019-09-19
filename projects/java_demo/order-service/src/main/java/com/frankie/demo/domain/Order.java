package com.frankie.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2019/9/18 10:32
 */
@Setter
@Getter
public class Order {

    private String productName;
    private BigDecimal total;
}
