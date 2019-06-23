package com.frankie.demo;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import jdk.nashorn.internal.ir.IfNode;

import java.time.Period;
import java.util.Stack;
import java.util.UnknownFormatConversionException;

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

    public boolean checkNodeIsExisted(int val){
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

    public Node findNode(int val){
        Node cur = head;
        if (cur == null) return null;

        do {
            if (cur.getValue() == val) return cur;
            cur = cur.getNext();
        } while (cur != null);
        return null;
    }

    public void removeNodeOptimization(int val){

        // Step1: Base check.
        if (head == null) System.out.println("The link list is empty!");

        // Step2: Find the specified node if existed.
        Node specifiedNode = findNode(val);
        if (specifiedNode == null){
            System.out.println("The node is not included in the link list!");
            return;
        }

        // Step3: 链表仅有一个结点，即头结点或尾结点
        if (head == specifiedNode){
            head = null;
            return;
        }

        // 以下链表包含多个结点的情况
        // Step4: 待删除结点为尾结点
        if (specifiedNode.getNext() == null){
            Node cur = head;
            // 按照O(n)时间复杂度遍历链表
            while (cur.getNext() != specifiedNode){
                cur = cur.getNext();
            }
            cur.setNext(null);
        } else{
            // Step5: Delete the node using O(1) time complexity.
            specifiedNode.setValue(specifiedNode.getNext().getValue());
            specifiedNode.setNext(specifiedNode.getNext().getNext());
        }
    }

    public void deleteDuplicateNodes(){
        // 2 -> 3 -> 5 -> 5 -> 7 -> 7 -> 9

        if (head == null) return;

        Node pre = new Node(-1);
        pre.setNext(head);

        Node cur = head;

        while (cur != null && cur.getNext() != null){

            if (cur.getValue() == cur.getNext().getValue()){
                int val = cur.getValue();
                while (cur.getNext() != null && cur.getValue() == val){
                    cur = cur.getNext();
                }
                pre.setNext(cur);

            } else{
                pre = cur;
                cur = cur.getNext();
            }
        }

    }

    public void addNodeForHeadTest(int val) {
        Node cur = head;
        Node next = cur.getNext();

        // Step1: Base check.
        if (cur == null || next == null) return;

        Node node = new Node(val);
        while (cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
}

























