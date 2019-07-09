package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/6/9-14:18
*/


import javax.naming.NamingException;

public class MyLinkedList {

    // region Public Methods
    public static void doReverse(){

        MyLinkedList mll = new MyLinkedList();
        Node head = new Node(5);
        mll.addToLast(head);
        mll.addToLast(new Node(6));
        mll.addToLast(new Node(7));
        mll.addToLast(new Node(1));
        mll.addToLast(new Node(2));

        mll.printList(head);
        Node reversedNode = mll.reverseList(head);
        mll.printList(reversedNode);
    }

    public static void removeDuplicate(){
        MyLinkedList mll = new MyLinkedList();
        Node head = new Node(5);
        mll.addToLast(head);
        mll.addToLast(new Node(6));
        mll.addToLast(new Node(5));
        mll.addToLast(new Node(1));
        mll.addToLast(new Node(1));

        System.out.println("Print init linked list: ");
        mll.printList(head);
        mll.doRemoveDupl();
        System.out.println("Print duplicated linked list: ");
        mll.printList(head);
    }

    private void doRemoveDupl() {
        Node currentNode = head;

        while (currentNode != null && currentNode.next != null ){
            Node tempNode = currentNode;

            while (tempNode.next != null){
                if (currentNode.value == tempNode.next.value){
                    tempNode.next = tempNode.next.next;
                } else{
                    tempNode = tempNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }
    // endregion

    // region Support Methods
    private Node reverseList(Node currentNode) {

        Node previousNode = null;
        Node nextNode;

        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    private void printList(Node head) {
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private void addToLast(Node node) {
        if (head == null){
            head = node;
        } else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    // endregion

    // region Basic Data Structure
    public Node head;

    public static class Node{

        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // endregion

}

