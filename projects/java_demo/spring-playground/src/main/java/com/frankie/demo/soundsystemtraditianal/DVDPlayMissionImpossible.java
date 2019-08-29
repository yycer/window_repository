package com.frankie.demo.soundsystemtraditianal;

/**
 * 一台只能看碟中谍的DCD，你想要么？如果不想要，那就尽量避免紧耦合。
 */
public class DVDPlayMissionImpossible {

    private MissionImpossibleCD missionImpossibleCD;

    public DVDPlayMissionImpossible(){
        this.missionImpossibleCD = new MissionImpossibleCD();
    }

    public void play(){
        System.out.println("一台只能看" + missionImpossibleCD.getCompactDiskName() + "的DVD");
    }
}
