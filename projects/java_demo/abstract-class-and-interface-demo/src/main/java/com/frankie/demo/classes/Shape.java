package com.frankie.demo.classes;

public abstract class Shape {
    String objectName;

    Shape(String name){
        this.objectName = name;
    }

    public void moveTo(int x, int y){
        System.out.println(this.objectName + " " + "has been moved to " + "x = " + x + ", y = " + y);

    }

    abstract public double area();
    abstract public void draw();
}
