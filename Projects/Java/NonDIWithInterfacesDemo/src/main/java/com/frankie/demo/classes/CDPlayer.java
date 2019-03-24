package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/3/24-13:35
*/

import com.frankie.demo.interfaces.CompactDisc;
import com.frankie.demo.interfaces.MediaPlayer;

public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("用CD播放器: ");
        cd.play();
    }
}
