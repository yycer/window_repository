package com.frankie.demo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.frankie.demo.validator.Name;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {

    @NotBlank(message = "Please provide a name.")
    @Name
    private String name;

    @NotNull(message = "Please provide a retail price.")
    @DecimalMin("1.00")
    private BigDecimal retailPrice;

    private Integer quantity;

    /*
        childProducts not null, but size can be zero. For example
        1. "child_products": []
        2. "child_products": ["80142816", "80156212"]
    */
    @NotNull(message = "Please provide child products.")
    private List<String> childProducts;
}
