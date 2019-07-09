package com.frankie.demo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Order {
    private String basketOrderId;
    private BigDecimal retailPrice;
}
