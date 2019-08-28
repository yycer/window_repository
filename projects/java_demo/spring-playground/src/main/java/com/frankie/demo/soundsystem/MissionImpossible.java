package com.frankie.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class MissionImpossible implements CompactDisk {


    @Override
    public void play() {
        System.out.println("碟中谍系列");
    }
}
