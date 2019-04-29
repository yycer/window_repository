package com.frankie.demo.classes;

import com.frankie.demo.interfaces.Shape;

public class CircleImpl implements Shape {
    private double pi = 3.14;
    private int radius;

    public CircleImpl(int radius){
        this.radius = radius;
    }

    @Override
    public Double area() {
        return (pi * radius * radius) / 2;
    }

    @Override
    public void draw() {
        System.out.println("Circle has been drawn.");
    }
}
