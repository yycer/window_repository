package com.frankie.demo.classes;

public class Circle extends Shape {

    double pi = 3.14;
    private int radius;

    public Circle(String name, int radius){
        super(name);
        this.radius = radius;
    }
    @Override
    public double area() {
        return (pi*radius*radius) / 2;
    }

    @Override
    public void draw() {
        System.out.println("Circle has been drawn.");
    }
}
