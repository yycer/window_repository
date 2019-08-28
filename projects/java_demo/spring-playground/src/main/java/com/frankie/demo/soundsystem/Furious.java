package com.frankie.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Furious implements CompactDisk{

    @Override
    public void play() {
        System.out.println("速度与激情");
    }
}
