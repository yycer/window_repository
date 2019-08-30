package com.frankie.demo.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    @Autowired
    @Qualifier("missionImpossible")
    private CompactDisk cd;

    @Override
    public void play() {

    }

}
