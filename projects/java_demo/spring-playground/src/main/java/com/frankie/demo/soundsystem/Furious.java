package com.frankie.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Furious implements CompactDisk{

    @Override
    public String getCDName() {
        return "速度与激情";
    }
}
