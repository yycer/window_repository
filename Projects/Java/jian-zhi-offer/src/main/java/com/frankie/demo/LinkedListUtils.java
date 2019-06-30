package com.frankie.demo;

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

//    public Node deleteMiddleNode(){
//        if (head == null || head.getNext() == null) return null;
//
//        Node fastPointer = head;
//        Node slowPointer = head;
//
//        Node prevoius = null;
//        while (fastPointer != null && fastPointer.getNext() != null){
//            fastPointer = fastPointer.getNext().getNext();
//            prevoius = slowPointer;
//            slowPointer = slowPointer.getNext();
//        }
//
//        prevoius.setNext(slowPointer.getNext());
//
//        return head;
//    }

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

    /**
     * 1. 需要三个指针： preNode、curNode、nextNode
     * 2. 边界条件
     * <1> head == null
     * <2> 一个结点
     * <3> 多个结点
     * @return
     */
    public Node reverseLinkList(){
        if (head == null) return null;

        Node preNode  = null;
        Node nextNode = null;
        Node curNode  = head;

        while (curNode != null){
            nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

//    public void printLinkListReverselyUsingRecursive(Node node) {
//
//        // Step1: Base check.
//        if (node == null) System.out.println("The link list is empty!");
//
//        // Step2: Print link list reversely using recursive.
//        Node next = node.getNext();
//        if (next != null){
//            printLinkListReverselyUsingRecursive(next);
//        }
//        System.out.println(node.getValue());
//    }

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


    public Node meetingNode(){
        Node slowNode = head.getNext();
        if (slowNode.getNext() == null) return null;
        Node fastNode = slowNode.getNext();

        while (slowNode != null && fastNode != null){

            if (slowNode == fastNode) return fastNode;
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext();
            if (fastNode != null) fastNode = fastNode.getNext();
        }
        return null;
    }


    /**
     * 边界条件
     * 1. 无闭环 => meetingNode = null.
     * @return
     */
    public Integer printEntranceNode(){
        // Step1: Base check.
        if (head == null) return -1;

        // Step2: 获取相遇节点。
        Node meetingNode = meetingNode();
        // 代表链表无环。
        if (meetingNode == null) return -1;

        // Step3: 计算环中的节点总数。
        Node fastNode = head;
        while (fastNode != meetingNode){
            fastNode = fastNode.getNext();
        }

        // Step4: 打印入口节点。
        Node slowNode = head;
        while (fastNode != slowNode){
            fastNode  = fastNode.getNext();
            slowNode = slowNode.getNext();
        }
        Integer result = fastNode.getValue();

        return result;
    }

    /**
     * 1. 合并两个有序的链表。
     * 2. 边界条件
     * <1> 单个链表中存在连续节点
     * <2> 任意一个链表为null，或者均为null。
     * <3> 任意一个链表仅包含一个结点。
     */
    public Node mergeTwoSortedLinkList(Node n1, Node n2){
        if (n1 == null) return n2;
        else if (n2 == null) return n1;

        Node mergedNode = null;
        if (n1.getValue() < n2.getValue()){
            mergedNode = n1;
            mergedNode.setNext(mergeTwoSortedLinkList(n1.getNext(), n2));
        } else {
            mergedNode = n2;
            mergedNode.setNext(mergeTwoSortedLinkList(n1, n2.getNext()));
        }

        return mergedNode;
    }

//    public int countNodes(Node node){
//        if (node == null) return 0;
//
//        Node curNode = node;
//        int count = 0;
//        do {
//            count++;
//            curNode = curNode.getNext();
//        }while (curNode != null);
//        return count;
//    }

//    /**
//     * 边界条件:
//     * √1. 无公共节点。
//     * √2. 公共节点在结尾。
//     * √3. 两个链表完全一样。
//     * @param n1
//     * @param n2
//     * @return
//     */
//    public Node findFirstCommonNodeBetweenTwoLinkList(Node n1, Node n2){
//        // Base check.
//        if (n1 == null || n2 == null) return null;
//
//        // Step1: Get the length of node1 and node2.
//        int size1 = countNodes(n1);
//        int size2 = countNodes(n2);
//        int distance;
//        Node longNode;
//        Node shortNode;
//        if (size1 >= size2) {
//            longNode  = n1;
//            shortNode = n2;
//            distance  = size1 - size2;
//        } else {
//            longNode  = n2;
//            shortNode = n1;
//            distance  = size2 - size1;
//        }
//
//        // Step2: 长的那个链表先往前走distance步。
//        while (distance > 0){
//            longNode = longNode.getNext();
//            distance--;
//        }
//
//        // Step3: 遍历两个链表，若当前两个节点相同，该节点即为公共节点。
//        while (longNode            != null &&
//               shortNode           != null &&
//               longNode.getValue() != shortNode.getValue()){
//            longNode  = longNode.getNext();
//            shortNode = shortNode.getNext();
//        }
//
//        return longNode;
//
//    }
}

























