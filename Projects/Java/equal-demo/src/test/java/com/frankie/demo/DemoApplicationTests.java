package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void primitiveTypeSizeTest() {
        /*
            1 byte: byte, boolean
            2 byte: short, char
            4 byte: int, float
            8 byte: long, double
        */

        int byteSize = Byte.SIZE / 8; // 1
        int shortSize = Short.SIZE / 8; // 2
        int characterSize = Character.SIZE / 8; // 2
        int integerSize = Integer.SIZE / 8; // 4
        int floatSize = Float.SIZE / 8; // 4
        int longSize = Long.SIZE / 8; // 8
        int doubleSize = Double.SIZE / 8; // 8
    }

    @Test
    public void primitiveTypeEqualSign(){
        // 1. Byte
        Byte b1 = 127;
        Byte b2 = 127;
        Byte b3 = 123;

        boolean byte1 = b1 == b2; // true
        boolean byte2 = b1 == b3; // false
        boolean byte3 = b1.equals(b2); // true
        boolean byte4 = b1.equals(b3); // false

        // 2. Char
        Character c1 = 'y';
        Character c2 = 'y';
        Character c3 = 'c';

        boolean char1 = c1 == c2; // true
        boolean char2 = c1 == c3; // false
        boolean char3 = c1.equals(c2); // true
        boolean char4 = c1.equals(c3); // false

        // 2. Short
        Short s1 = 32767;
        Short s2 = 32767;
        Short s3 = 32000;

        boolean short1 = s1 == s2; // why false??
        boolean short2 = s1 == s3; // false
        boolean short3 = s1.equals(s2); // true
        boolean short4 = s1.equals(s3); // false

        // 4. Integer
        Integer i1 = 10086;
        Integer i2 = 10086;
        Integer i3 = 10000;

        boolean integer1 = i1 == i2; // why false??
        boolean integer2 = i1 == i3;
        boolean integer3 = i1.equals(i2);
        boolean integer4 = i1.equals(i3);


        // 4. Float
        Float f1 = 20132.20132f;
        Float f2 = 20132.20132f;
        Float f3 = 20132.22222f;

        boolean float1 = f1 == f2; // false
        boolean float2 = f1 == f3;
        boolean float3 = f1.equals(f2);
        boolean float4 = f1.equals(f3);

        // 8. Long
        Long l1 = 1111122222l;
        Long l2 = 1111122222l;
        Long l3 = 1111133333l;

        boolean long1 = l1 == l2; // false
        boolean long2 = l1 == l3;
        boolean long3 = l1.equals(l2);
        boolean long4 = l1.equals(l3);

        // 8. Double
        Double d1 = 1111122222.333;
        Double d2 = 1111122222.333;
        Double d3 = 1111122222.888;

        boolean double1 = d1 == d2; // false
        boolean double2 = d1 == d3;
        boolean double3 = d1.equals(d2);
        boolean double4 = d1.equals(d3);

    }

    @Test
    public void objectEqualTest(){

        String uuidStr1 = UUID.randomUUID().toString();
        String uuidStr2 = UUID.randomUUID().toString();

        Order order1 = new Order();
        order1.setBasketOrderId(uuidStr1);
        order1.setRetailPrice(new BigDecimal(10.20));

        Order order2 = new Order();
        order2.setBasketOrderId(uuidStr1);
        order2.setRetailPrice(new BigDecimal(10.20));

        Order order3 = new Order();
        order3.setBasketOrderId(uuidStr2);
        order3.setRetailPrice(new BigDecimal(88.50));

        boolean b1 = order1 == order2; // false
        boolean b2 = order1 == order3; // false
        boolean b3 = order1.equals(order2); // false
        boolean b4 = order1.equals(order3); // false
    }
}