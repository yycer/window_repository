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

    /**
     * 在O(1)时间复杂度下删除链表节点
     * 边界条件:
     * 1. 待删除节点在头结点
     * 2. 链表中无待删除节点。 - 如何区分待删除节点在尾节点(curNode.getNext == null)、链表中无待删除节点(curNode == null)？
     * 3. 待删除节点在尾节点。 - 解决方案: 遍历整个链表，定位到待删除节点的前一个节点，并将其连接上null
     *

     * @param val
     */
    public void deleteNodeUsingO1(int val){

        if (head == null) return;

        /**
         * 定位待删除节点
         * <1> 若链表中不存在待删除节点   => curNode           == null;
         * <2> 若待删除节点处于链表的尾部 => curNode.getNext() == null;
         * <3> 若待删除节点处于链表的首部 => curNode           == head;
         */
        Node curNode = head;
        do {
            if (curNode.getVal() == val) break;
            curNode = curNode.getNext();
        } while (curNode != null);

        /**
         * 边界条件1: 待删除节点在头结点，包含两种情况
         * <1> 链表仅包含一个节点。
         * <2> 链表包含多个节点。
         *
         */
        if (head == curNode){
            head = curNode.getNext();
            return;
        }

        /**
         * 边界条件2：链表中无待删除节点。
         */
        if (curNode == null){
            return;
        }
        /**
         * 边界条件3: 待删除节点在尾节点。
         */
        else if (curNode.getNext() == null){
            Node previousNode = head;
            while (previousNode.getNext() != curNode){
                previousNode = previousNode.getNext();
            }
            previousNode.setNext(null);
        } else{

            /**
             * Step1: 将待删除后一个节点的值复制到待删除节点。
             * Step2: 将更新后的待删除节点连上待删除节点的下下个节点。
             */
            curNode.setVal(curNode.getNext().getVal());
            curNode.setNext(curNode.getNext().getNext());
        }
    }

    /**
     * 一.删除链表中重复节点。
     * 1. 外层循环，判断当前节点是否需要删除？判断依据是什么？ 当前节点是否与下一个结点值相等。
     * 2. 内层循环，直至下一个不同节点，且将previousNode连上当前不同节点。
     *
     * 二. 边界条件
     * 1. 链表仅包含一个节点，不作任何修改。
     * 2. 链表仅包含重复节点，整个链表为null。解决方案： 在内层循环中，判断previous是否为null，若是，head指向当前节点的下一个节点。
     * 3. 链表中包含的重复节点在头节点。
     * 4. 链表中包含的重复节点在尾节点。
     * 5. 链表中间包含多个不同值的重复节点。
     * 6. 链表中不包含重复节点，不做任何修改。
     */
    public void deleteDuplicateNodes(){

        if (head == null) return;

        Node curNode      = head;
        Node previousNode = null;
        while (curNode != null){

            if (curNode.getNext() == null) return;
            Node nextNode = curNode.getNext();

            // 当前节点不需要删除。
            if (curNode.getVal() != nextNode.getVal()){
                previousNode = curNode;
                curNode      = curNode.getNext();
            }
            // 当前节点需要删除。
            else {
                int duplicateValue = curNode.getVal();
                Node tmpNode       = curNode;

                while (tmpNode != null && tmpNode.getVal() == duplicateValue){
                    tmpNode = tmpNode.getNext();
                    if (previousNode == null){
                        head = tmpNode;
                    }
                    // 将下面else语句放在该while语句块的原因是: 防止对previousNode多赋值一遍，还有可能造成空引用。
                    else{
                        previousNode.setNext(tmpNode);
                    }
                }
                curNode = tmpNode;
            }
        }
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






















