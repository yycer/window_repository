package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/3/24-13:24
*/

public class VCDPlayer {
    private Gongfu gongfu;

    private Shishen shishen;

    public VCDPlayer(Gongfu gongfu){
        this.gongfu = gongfu;
    }

    public VCDPlayer(Shishen shishen){
        this.shishen = shishen;
    }


    public void playGongfu(){
        System.out.println("用VCD播放： ");
        gongfu.play();
    }

    public void playShiShen(){
        System.out.println("用VCD播放： ");
        shishen.play();
    }
}
