package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/3/24-13:36
*/

import com.frankie.demo.interfaces.CompactDisc;
import com.frankie.demo.interfaces.MediaPlayer;

public class VCDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public VCDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("用VCD播放器: ");
        cd.play();
    }
}
