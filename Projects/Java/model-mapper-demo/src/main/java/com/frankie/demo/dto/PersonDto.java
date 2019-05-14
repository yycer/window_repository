package com.frankie.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonDto {
    private String name;
    private Integer age;
    private AddressDto address;
}
