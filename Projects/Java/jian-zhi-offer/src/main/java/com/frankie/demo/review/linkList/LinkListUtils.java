package com.frankie.demo.review.linkList;/*
 @author: Administrator
 @date: 2019/6/29-16:26
*/


import sun.dc.pr.PRError;

public class LinkListUtils {

    public Node head;
    private final String ARROW = " -> ";

    public void addNode(int val){
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node curNode = head;
        // 定位到链表的最后一个节点。
        while (curNode.getNext() != null){
            curNode = curNode.getNext();
        }

        curNode.setNext(node);
    }

    public String printNodes(){
        if (head == null){
            return "The link list is empty!";
        }

        Node curNode = head;
        StringBuilder sb = new StringBuilder();
        while (curNode != null){
            sb.append(curNode.getVal());
            sb.append(ARROW);
            curNode = curNode.getNext();
        }
        String result = new String(sb);
        return result.substring(0, result.length() - ARROW.length());
    }

    public boolean containNode(int val){
        if (head == null) return false;

        Node curNode = head;
        while (curNode != null){
            if (curNode.getVal() == val) return true;
            curNode = curNode.getNext();
        }
        return false;
    }


    /**
     * 边界条件:
     * 1. 待删除节点在首节点位置，解决方案: if(previousNode == null) head = curNode.getNext();
     * 2. 链表中并不存在待删除节点，解决方案: 前提遍历链表做下check。
     * @param val
     */
    public void deleteNode(int val){
        if (head == null) return;

        Node curNode      = head;
        Node previousNode = null;

        // 定位到待删除节点的前一个节点。
        while (curNode != null){
            if (curNode.getVal() == val) break;
            previousNode = curNode;
            curNode      = curNode.getNext();
        }


        // 边界条件1: 待删除节点为首节点
        if (previousNode == null){
            head = curNode.getNext();
        }
        /**
         * 边界条件2: 链表中不存在待删除的节点。
         * 那么如何判断链表中是否存在待删除节点？
         * 答: 尾结点是链表中的最后一个节点。
         */
        else if (previousNode.getNext() == null) {
            return;
        } else{
            previousNode.setNext(curNode.getNext());
        }
    }

    /**
     * 构建一个简单的环形链表，链表最后一个节点连上链表中的节点。
     * @param val
     */
    public void buildCircleNodeForLastOne(int val){
        if (head == null) return;

        Node curNode       = head;
        Node connectedNode = head;

        // Step1: 定位到最后一个节点。
        while (curNode.getNext() != null){
            curNode = curNode.getNext();
        }

        // Step2: 定位到值为val的节点。
        while (connectedNode != null){
            if (connectedNode.getVal() == val) break;
            connectedNode = connectedNode.getNext();
        }

        curNode.setNext(connectedNode);
    }

    // region Private methods.

    /**
     * 找到待删除节点的前一个节点
     * @param val
     */
//    private Node findPreviousNodeBeforeDeleted(int val){
//        if (head == null) return null;
//
//        Node curNode = head;
//        Node previousNode = null;
//
//        while (curNode != null){
//            // 一旦当前结点等于待删除节点，则已经定位到了待删除、前一个节点。
//            if (curNode.getVal() == val) break;
//            // 否则前一个节点为当前结点。
//            previousNode = curNode;
//            // 而当前结点继续向后遍历。
//            curNode = curNode.getNext();
//        }
//
//        return previousNode;
//    }
    // endregion

}
