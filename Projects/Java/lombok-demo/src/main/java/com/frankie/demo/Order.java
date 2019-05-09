package com.frankie.demo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private String basketOrderId;
    private BigDecimal retailPrice;
    private LocalDateTime createdDate;
}
