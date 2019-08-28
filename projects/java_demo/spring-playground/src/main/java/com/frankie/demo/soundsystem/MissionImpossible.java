package com.frankie.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class MissionImpossible implements CompactDisk {

    @Override
    public String getCDName() {
        return "碟中谍";
    }
}
