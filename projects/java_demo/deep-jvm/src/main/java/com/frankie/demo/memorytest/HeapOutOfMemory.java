package com.frankie.demo.memorytest;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemory {

    static class OOMObject{

    }

    public void run(){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
