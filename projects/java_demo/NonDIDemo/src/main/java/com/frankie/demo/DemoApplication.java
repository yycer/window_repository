package com.frankie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Gongfu gongfu = new Gongfu();
        Shishen shishen = new Shishen();

        CDPlayer gongfuCdPlayer = new CDPlayer(gongfu);
        gongfuCdPlayer.playGongfu();

        CDPlayer shiShenCdPlayer = new CDPlayer(shishen);
        shiShenCdPlayer.playShiShen();

        VCDPlayer gongfuVcdPlayer = new VCDPlayer(gongfu);
        gongfuVcdPlayer.playGongfu();

        VCDPlayer shiShenVcdPlayer = new VCDPlayer(shishen);
        shiShenVcdPlayer.playShiShen();
    }

}
