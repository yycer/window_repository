package com.frankie.demo.classes;

import com.frankie.demo.interfaces.Shape;

public class RectangleImpl implements Shape {

    private int length, width;

    public RectangleImpl(int length, int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public Double area() {
        return (double) (length * width);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle has been drawn.");
    }
}
