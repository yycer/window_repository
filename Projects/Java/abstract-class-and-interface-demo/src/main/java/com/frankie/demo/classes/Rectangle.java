package com.frankie.demo.classes;

public class Rectangle extends Shape {

    private int length, width;

    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return (double)(length * width);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle has been drawn.");
    }
}
