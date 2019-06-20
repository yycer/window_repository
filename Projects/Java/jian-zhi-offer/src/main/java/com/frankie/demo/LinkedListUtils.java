package com.frankie.demo;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.Stack;

public class LinkedListUtils {

    Node head = null;
    Node tail = null;
    public static final String specifiedLabel = " -> ";

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

    public String printLinkList(Node node){
        Node cur = head;
        if (node != null){
            cur = node;
        }
        if (cur == null){
            return "The link list is empty!";
        }
        StringBuilder sb = new StringBuilder();
        while (cur != null){
            sb.append(cur.getValue() + specifiedLabel);
            cur = cur.getNext();
        }

        String result = new String(sb);
        return result.substring(0, sb.length() - specifiedLabel.length());
    }

    public boolean findNode(int val){
        Node cur = head;
        if (cur == null) return false;

        while (cur != null){
            if (cur.getValue() == val)
                return true;
            cur = cur.getNext();
        }
        return false;
    }

    public void removeNode(int val){
        Node cur = head;
        if (cur == null) return;
        Node previous = null;

        while (cur != null){
            if (cur.getValue() == val) break;
            previous = cur;
            cur = cur.getNext();
        }

        // 考虑到删除头结点的情况
        if (previous == null){
            head = head.getNext();
        } else{
            previous.setNext(cur.getNext());
        }
    }

    public void printLinkListReverselyUsingStack(){

        // Step1: Base check.
        Node cur = head;
        if (cur == null) System.out.println("The link list is empty!");

        // Step2: Loop through the entire link list, push elements into stack from beginning to end.
        Stack<Integer> stack = new Stack<>();
        while (cur != null){
            stack.push(cur.getValue());
            cur = cur.getNext();
        }

        // Step3: Pop element from stack in sequence.
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public Node reverseLinkList(){
        /**
         * next     = cur.next;
         * cur.next = previous;
         * previous = cur;
         * cur      = next;
         */

        // Step1: Base check.
        Node cur = head;
        if (cur == null) return null;

        // Step2: Reverse and return link list.
        Node next;
        Node previous = null;
        while (cur != null){
            next = cur.getNext();
            cur.setNext(previous);
            previous = cur;
            cur = next;
        }
        return previous;
    }

    public void printLinkListReverselyUsingRecursive(Node node) {

        // Step1: Base check.
        if (node == null) System.out.println("The link list is empty!");

        // Step2: Print link list reversely using recursive.
        Node next = node.getNext();
        if (next != null){
            printLinkListReverselyUsingRecursive(next);
        }
        System.out.println(node.getValue());
    }
}
