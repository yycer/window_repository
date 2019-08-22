package com.frankie.demo.memorytest;

import java.util.ArrayList;
import java.util.List;

public class ConstantPoolOOM {

    public void run(){
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
