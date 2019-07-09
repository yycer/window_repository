package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/3/24-13:21
*/

public class CDPlayer {

    private Gongfu gongfu;

    private Shishen shishen;

    public CDPlayer(Gongfu gongfu){
        this.gongfu = gongfu;
    }

    public CDPlayer(Shishen shishen){
        this.shishen = shishen;
    }


    public void playGongfu(){
        System.out.println("用CD播放： ");
        gongfu.play();
    }

    public void playShiShen(){
        System.out.println("用CD播放： ");
        shishen.play();
    }
}
