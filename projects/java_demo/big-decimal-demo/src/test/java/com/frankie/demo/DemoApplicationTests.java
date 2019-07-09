package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void add() {
        BigDecimal bd1 = new BigDecimal(10.20);
        BigDecimal bd2 = new BigDecimal(20.30);

        // 小数点后保留2位
        BigDecimal result = bd1.add(bd2).setScale(2, RoundingMode.CEILING);
        System.out.println(result);
    }

    @Test
    public void subtract(){
        BigDecimal bd1 = new BigDecimal(10.89);
        BigDecimal bd2 = new BigDecimal(3.78);
        BigDecimal result = bd1.subtract(bd2).setScale(2, RoundingMode.HALF_UP);
        System.out.println(result);
    }

    @Test
    public void multiply(){
        BigDecimal bd1 = new BigDecimal(1.89);
        BigDecimal bd2 = new BigDecimal(2.39);
        BigDecimal result = bd1.multiply(bd2).setScale(2, RoundingMode.HALF_UP);
    }

    @Test
    public void divide(){
        BigDecimal bd1 = new BigDecimal(9.34);
        BigDecimal bd2 = new BigDecimal(2.35);
        // divide(BigDecimal divisor, int scale, RoundingMode rm)
        BigDecimal result = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
    }


    @Test
    public void compareTo(){
        BigDecimal bd1 = new BigDecimal(10.37);
        BigDecimal bd2 = new BigDecimal(20.37);
        int result = bd1.compareTo(bd2);
    }

    @Test
    public void roundingModeTest(){
        BigDecimal bd1 = new BigDecimal(5.5555);
        BigDecimal bd2 = new BigDecimal(5.333);
        BigDecimal bd3 = new BigDecimal(5.888);
        BigDecimal bd4 = new BigDecimal(-5.5555555);
        BigDecimal bd5 = new BigDecimal(-5.333);
        BigDecimal bd6 = new BigDecimal(-5.888);

        // Up: <- .... ->
        BigDecimal up1 = bd1.setScale(2, RoundingMode.UP); // 5.56
        BigDecimal up2 = bd2.setScale(2, RoundingMode.UP); // 5.34
        BigDecimal up3 = bd3.setScale(2, RoundingMode.UP); // 5.89
        BigDecimal up4 = bd4.setScale(2, RoundingMode.UP); // -5.56
        BigDecimal up5 = bd5.setScale(2, RoundingMode.UP); // -5.34
        BigDecimal up6 = bd6.setScale(2, RoundingMode.UP); // -5.89


        // Down: -> ... <-
        BigDecimal down1 = bd1.setScale(2, RoundingMode.DOWN); // 5.55
        BigDecimal down2 = bd2.setScale(2, RoundingMode.DOWN); // 5.33
        BigDecimal down3 = bd3.setScale(2, RoundingMode.DOWN); // 5.88
        BigDecimal down4 = bd4.setScale(2, RoundingMode.DOWN); // -5.55
        BigDecimal down5 = bd5.setScale(2, RoundingMode.DOWN); // -5.33
        BigDecimal down6 = bd6.setScale(2, RoundingMode.DOWN); // -5.88


        // Ceiling: -> ... ->
        BigDecimal ceiling1 = bd1.setScale(2, RoundingMode.CEILING); // 5.56
        BigDecimal ceiling2 = bd2.setScale(2, RoundingMode.CEILING); // 5.34
        BigDecimal ceiling3 = bd3.setScale(2, RoundingMode.CEILING); // 5.89
        BigDecimal ceiling4 = bd4.setScale(2, RoundingMode.CEILING); // -5.55
        BigDecimal ceiling5 = bd5.setScale(2, RoundingMode.CEILING); // -5.33
        BigDecimal ceiling6 = bd6.setScale(2, RoundingMode.CEILING); // -5.88


        // Floor: <- ... <-
        BigDecimal floor1 = bd1.setScale(2, BigDecimal.ROUND_FLOOR); // 5.55
        BigDecimal floor2 = bd2.setScale(2, BigDecimal.ROUND_FLOOR); // 5.33
        BigDecimal floor3 = bd3.setScale(2, BigDecimal.ROUND_FLOOR); // 5.88
        BigDecimal floor4 = bd4.setScale(2, BigDecimal.ROUND_FLOOR); // -5.56
        BigDecimal floor5 = bd5.setScale(2, BigDecimal.ROUND_FLOOR); // -5.34
        BigDecimal floor6 = bd6.setScale(2, BigDecimal.ROUND_FLOOR); // -5.89


        // Half_Up: 四舍五入
        BigDecimal halfUp1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP); // 5.56
        BigDecimal halfUp2 = bd2.setScale(2, BigDecimal.ROUND_HALF_UP); // 5.33
        BigDecimal halfUp3 = bd3.setScale(2, BigDecimal.ROUND_HALF_UP); // 5.89
        BigDecimal halfUp4 = bd4.setScale(2, BigDecimal.ROUND_HALF_UP); // -5.56
        BigDecimal halfUp5 = bd5.setScale(2, BigDecimal.ROUND_HALF_UP); // -5.33
        BigDecimal halfUp6 = bd6.setScale(2, BigDecimal.ROUND_HALF_UP); // -5.89

    }
}
