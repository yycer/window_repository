package com.frankie.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String personName;
    private Integer personAge;
    private Address address;
}
