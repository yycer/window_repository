package com.frankie.demo.soundsystemtraditianal;/*
 @author: Administrator
 @date: 2019/8/30-07:33
*/

public class DVDPlayFurious {

    private FuriousCD furiousCD;

    public DVDPlayFurious(){
        this.furiousCD = new FuriousCD();
    }

    public void play(){
        System.out.println("一台只能看" + furiousCD.getCompactDiskName() + "的DVD");
    }
}
