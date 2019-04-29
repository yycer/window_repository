package com.frankie.demo;

import com.frankie.demo.classes.Circle;
import com.frankie.demo.classes.CircleImpl;
import com.frankie.demo.classes.Rectangle;
import com.frankie.demo.classes.RectangleImpl;
import com.sun.webkit.dom.RectImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.css.Rect;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void interfaceTest(){

        RectangleImpl rectangle = new RectangleImpl(3, 4);
        System.out.println("Rectangle area = " + rectangle.area());
        rectangle.draw();

        System.out.println("---------------------------");
        CircleImpl circle = new CircleImpl(6);
        System.out.println("Circle area = " + circle.area());
        circle.draw();
    }

    @Test
    public void abstractClassTest(){
        Rectangle rectangle = new Rectangle("Rectangle", 4, 3);
        rectangle.moveTo(6, 2);
        System.out.println("Rectangle area = " + rectangle.area());
        rectangle.draw();

        System.out.println("---------------------------");
        Circle circle = new Circle("Circle", 5);
        circle.moveTo(4, 9);
        System.out.println("Circle area = " + circle.area());
        circle.draw();
    }

}
