package com.frankie.demo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.frankie.demo.datetimeutils.DatetimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
 /*
     LowerCaseStrategy: 全小写 - basketorderid
     UpperCamelCaseStrategy: 首字母均大写(Pascal) - BasketOrderId
     KebabCaseStrategy: 羊肉串模式 - basket-order-id
     SnakeCaseStrategy: 蛇形模式 - basket_order_id
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {
//    @JsonProperty("basket_order_id")
    private String basketOrderId;

    @JsonIgnore
    private BigDecimal total;

//    @JsonSerialize(using = DatetimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Override
    public String toString(){
        return "Order{" +
                "basketOrderId = '" + basketOrderId + '\'' +
                '}';
    }
}
