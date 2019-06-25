package com.frankie.demo;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import jdk.nashorn.internal.ir.IfNode;

import java.io.FileReader;
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
        // 当前结点的前一个结点
        Node preNode = null;
        // 当前结点
        Node curNode = head;

        // 外层循环，依次遍历所有结点
        while (curNode != null){
            Node nextNode = curNode.getNext();
            boolean needDelete = false;
            if (nextNode != null && nextNode.getValue() == curNode.getValue()){
                needDelete = true;
            }

            if (!needDelete){
                preNode = curNode;
                curNode = curNode.getNext();
            }

            // 删除重复结点
            else{
                int value = curNode.getValue();
                Node toBeDelNode = curNode;
                // 内层循环，依次遍历重复结点
                while (toBeDelNode != null && toBeDelNode.getValue() == value){
                    nextNode = toBeDelNode.getNext();
                    toBeDelNode = nextNode;
                    if (preNode == null)
                        head = nextNode;
                    else
                        preNode.setNext(nextNode);
                    curNode = nextNode;
                }
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

    /**
     * 边界条件
     * 1. head == null
     * 2. 节点总数小于k
     * 3. k = 0 => secondNode.getValue => NullPointerException
     * @param k
     * @return
     */
    public Integer findLastKNode(int k){
        if (head == null || k <= 0) return -1;

        Node firstNode = head;
        // Step1: Locate the first node position(k-1).
        for (int i = 0; i < k; i++){
            Node nextNode = firstNode.getNext();
            // 防止节点总数小于k，导致空引用
            if (nextNode != null) firstNode = nextNode;
            else return -1;
        }

        // Step2: Locate the required position.
        Node secondNode = head;
        while (firstNode != null){
            secondNode = secondNode.getNext();
            firstNode = firstNode.getNext();
        }
        return secondNode.getValue();
    }

    /**
     * 输出链表中环的入口节点，准备工作，计算环的节点总数。
     */
    public Integer countNodesInARing(){
        if (head == null || head.getNext() == null) return -1;
        Node meetingNode;
        Node slowNode = head.getNext();
        if (slowNode.getNext() == null) return -1;
        Node fastNode = slowNode.getNext();

        while (slowNode != null && fastNode != null){

            if (slowNode == fastNode) meetingNode = slowNode;

            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext();
            if (fastNode.getNext() != null) fastNode = fastNode.getNext();
        }

        return 0;

    }

    public void generateLoopSingleTraceLinkList(int k){
        // Step1: 确定连接的后续节点。
        Node tmpNode = head;
        for (int i = 0; i < k - 1; i++){
            tmpNode = tmpNode.getNext();
        }
        Node connectedNode = tmpNode;

        // Step2: 遍历到尾部，重新连上后续节点。
        while (tmpNode.getNext() != null){
            tmpNode = tmpNode.getNext();
        }
        tmpNode.setNext(connectedNode);
    }
}

























