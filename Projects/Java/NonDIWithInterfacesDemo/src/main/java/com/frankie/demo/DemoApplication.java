package com.frankie.demo;

import com.frankie.demo.classes.CDPlayer;
import com.frankie.demo.classes.GongFu;
import com.frankie.demo.classes.ShiShen;
import com.frankie.demo.classes.VCDPlayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        GongFu gongfu = new GongFu();
        ShiShen shishen = new ShiShen();

        CDPlayer gongfuCdPlayer = new CDPlayer(gongfu);
        gongfuCdPlayer.play();

        CDPlayer shiShenCdPlayer = new CDPlayer(shishen);
        shiShenCdPlayer.play();

        VCDPlayer gongfuVcdPlayer = new VCDPlayer(gongfu);
        gongfuVcdPlayer.play();

        VCDPlayer shiShenVcdPlayer = new VCDPlayer(shishen);
        shiShenVcdPlayer.play();

    }
}
