package com.frankie.demo.optional;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2019/11/10 14:09
 */
@Setter
@Getter
public class Location {
    private String country;
    private String city;

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public static void introduce(String country) {
        System.out.println("I'm from " + country + ".");
    }
}
