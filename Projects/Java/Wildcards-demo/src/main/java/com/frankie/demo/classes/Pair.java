package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/5/2-15:17
*/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }


}
