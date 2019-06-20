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


    public Node deleteMiddleNode(){
        if (head == null || head.getNext() == null) return null;

        Node fastPointer = head;
        Node slowPointer = head;

        Node prevoius = null;
        while (fastPointer != null && fastPointer.getNext() != null){
            fastPointer = fastPointer.getNext().getNext();
            prevoius = slowPointer;
            slowPointer = slowPointer.getNext();
        }

        prevoius.setNext(slowPointer.getNext());

        return head;
    }
}
