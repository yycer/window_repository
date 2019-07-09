package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/3/24-13:34
*/

import com.frankie.demo.interfaces.CompactDisc;

public class ShiShen implements CompactDisc {
    @Override
    public void play() {
        System.out.println("食神");
    }
}
