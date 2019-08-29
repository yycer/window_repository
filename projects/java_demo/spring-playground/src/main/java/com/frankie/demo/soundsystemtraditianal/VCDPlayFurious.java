package com.frankie.demo.soundsystemtraditianal;

public class VCDPlayFurious {

    private FuriousCD furiousCD;

    public VCDPlayFurious(){
        this.furiousCD = new FuriousCD();
    }

    public void play(){
        System.out.println("一台只能看" + furiousCD.getCompactDiskName() + "的VCD");
    }
}
