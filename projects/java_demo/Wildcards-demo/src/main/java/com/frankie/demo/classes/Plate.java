package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/5/2-10:23
*/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plate<T> {
    private T item;

    public Plate(T t){
        this.item = t;
    }

}
