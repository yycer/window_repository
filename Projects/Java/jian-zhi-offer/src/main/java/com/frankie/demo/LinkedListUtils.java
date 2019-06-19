package com.frankie.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Stack;

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

    public void printNodes(){
        Node cur = head;
        if (cur == null){
            System.out.println("The linked list is empty!");
            return;
        }
        while (cur != null){
            System.out.print(cur.getVal() + " -> ");
            cur = cur.getNext();
        }
        System.out.print("null");
    }

    public Integer countNodes(){
        int count = 0;
        Node cur = head;
        if (cur == null) return count;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public String printReverseNode(){
        Stack<Integer> integers = new Stack<>();
        Node cur = head;
        if (cur == null){
            System.out.println("The linked list is empty!");
        }
        while (cur != null){
            integers.push(cur.getVal());
            cur = cur.getNext();
        }

        StringBuilder sb = new StringBuilder();
        while (!integers.isEmpty()){
            sb.append(integers.pop());
            sb.append(" -> ");
        }
        String s = new String(sb);
        return s.substring(0, s.length() - 4);

    }

}
