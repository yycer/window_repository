package com.frankie.demo.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VCDPlayer implements MediaPlayer {

    @Autowired
    @Qualifier("furious")
    private CompactDisk cd;

    @Override
    public void play() {
        System.out.println("Play " + cd.getCDName() + " using VCD");
    }
}
