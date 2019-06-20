package com.frankie.demo;

public class LinkedListUtils {

    Node head = null;
    Node tail = null;

    public void addNode(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else{
            tail.setNext(newNode);
            tail = newNode;
        }
    }


}
