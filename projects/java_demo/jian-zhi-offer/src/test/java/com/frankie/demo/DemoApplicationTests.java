package com.frankie.demo;

import com.frankie.demo.binaryTree.BinaryTree;
import com.frankie.demo.binaryTree.BinaryTreePrinter;
import com.frankie.demo.review.linkList.LinkListUtils;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.assertj.core.error.ShouldBeInstanceOfAny;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.util.ArrayStack;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void findRepeatedEleInArray() {
        int[] a = {8, 3, 7, 6, 8, 7};

        ArrayList<Integer> uniqueList = new ArrayList<>();
        ArrayList<Integer> repeatedList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (!uniqueList.contains(a[i])) {
                uniqueList.add(a[i]);
            } else {
                repeatedList.add(a[i]);
            }
        }
        System.out.println("2");
    }

    @Test
    public void indexWayTest() {
        int[] a = {2, 0, 3, 1, 2};

        boolean duplicated = ArrayUtils.isDuplicated(a);
        System.out.println(2);
    }

    @Test
    public void localDatetimeTest() {
        LocalDateTime ldt = LocalDateTime.of(LocalDateTime.now().getYear(), 6, 13, 0, 0);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = ldt.format(dateTimeFormatter);

        System.out.println(2);
    }

    @Test
    public void getMonthAndDay() {
        /**
         * 月: 7
         * 日: 10
         */
        String s = "您的订单预计12月13日送达您手中";
        int month = s.indexOf("月");
        int day = s.indexOf("日");

        char c = s.charAt(month - 1);
        char c1 = s.charAt(month - 2);
        String result;
        /**
         * 48 represents 0.
         * 57 represents 9.
         */
        if (c1 > 48 || c1 < 57) {
            result = String.valueOf(c1) + c;
        } else {
            result = String.valueOf(c);
        }

        System.out.println(result);

        String dayDigit = s.substring(month + 1, day);

        System.out.println(2);

    }

    @Test
    public void duplicateDichotomyTest() {
        int[] a = {2, 7, 3, 4, 2, 6, 4, 1};
        Integer duplicateInteger = ArrayUtils.isDuplicateDichotomy(a);
        System.out.println(duplicateInteger);
    }

    @Test
    public void printMatrix() {
        ArrayUtils.printMatrix();
    }

    @Test
    public void isExistedInMatrix() {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

//        boolean elementFromMatrix = ArrayUtils.findElementFromMatrix(matrix, 77);
        boolean b = ArrayUtils.topRightCornerWay(matrix, 6);
        System.out.println(b);
    }

    @Test
    public void replaceBlank() {

        String s = "hello world a b c";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 32) sb.append(s.charAt(i));
            else sb.append("%20");
        }
        String result = new String(sb);
        Assert.assertEquals(result, "hello%20world%20a%20b%20c");
    }

    @Test
    public void convertTest() {
        StreamUtils streamUtils = new StreamUtils();
//        streamUtils.convertInTwoListWay1();
        streamUtils.convertInTwoListWay2();
    }


    @Test
    public void deleteMiddleOfLinkListTest() {
        LinkedListUtils llu = new LinkedListUtils();
        llu.addNode(2);
        llu.addNode(4);
        llu.addNode(5);
        llu.addNode(8);
        llu.addNode(6);
        String llu1 = llu.printLinkList(null);
//        llu.deleteMiddleNode();
//        boolean existed = llu.checkNodeIsExisted(50);
//        llu.removeNode(2);
//        String llu2 = llu.printLinkList();
        System.out.println(llu1);
//        System.out.println("------ Reverse Time ------");
//        llu.printLinkListReverselyUsingStack();
//        Node node = llu.reverseLinkList();
//        String llu2 = llu.printLinkList(node);
//        llu.printLinkListReverselyUsingRecursive(llu.head);

        llu.removeNodeOptimization(4);
        System.out.println("aaaaa");

    }

    @Test
    public void doWhileTest() {
        int i = 5;
        do {
            System.out.println(i);
            i++;
        } while (i < 10);
    }


    @Test
    public void deleteNodeTest() {
        LinkedListUtils llu1 = new LinkedListUtils();
        llu1.addNode(2);
        llu1.removeNodeOptimization(3);
        llu1.removeNodeOptimization(2);
        Node head1 = llu1.head;


        LinkedListUtils llu2 = new LinkedListUtils();
        llu2.addNode(2);
        llu2.addNode(4);
        llu2.addNode(5);
        llu2.addNode(8);
        llu2.addNode(6);
        llu2.removeNodeOptimization(6);
        Node head2 = llu2.head;
        llu2.removeNodeOptimization(4);
        Node head3 = llu2.head;

    }

    @Test
    public void deleteDuplicateNodesTest() {

        LinkedListUtils llu = new LinkedListUtils();
        llu.addNode(2);
        llu.addNode(3);
        llu.addNode(5);
        llu.addNode(5);
        llu.addNode(7);
        llu.addNode(7);
        llu.addNode(9);
        llu.deleteDuplicateNodes();


        LinkedListUtils llu1 = new LinkedListUtils();
        llu1.addNode(2);
        llu1.addNode(3);
        llu1.deleteDuplicateNodes();


        // failed
        LinkedListUtils llu2 = new LinkedListUtils();
        llu2.addNode(2);
        llu2.addNode(2);
        llu2.deleteDuplicateNodes();

        // failed
        LinkedListUtils llu3 = new LinkedListUtils();
        llu3.addNode(5);
        llu3.addNode(5);
        llu3.addNode(6);
        llu3.deleteDuplicateNodes();


        LinkedListUtils llu4 = new LinkedListUtils();
        llu4.addNode(3);
        llu4.addNode(4);
        llu4.addNode(5);
        llu4.addNode(5);
        llu4.deleteDuplicateNodes();
    }


    @Test
    public void findLastKNodeTest() {
        LinkedListUtils llu = new LinkedListUtils();
        llu.addNode(1);
        llu.addNode(2);
        llu.addNode(3);
//        llu.addNode(4);
//        llu.addNode(5);
//        llu.addNode(6);
//        llu.addNode(7);

//        Integer lastKNode5 = llu.findLastKNode(3);
//        Integer lastKNode3 = llu.findLastKNode(5);
        Integer lastKNode = llu.findLastKNode(4);
    }

    @Test
    public void countNodesInARing() {
        LinkedListUtils llu = new LinkedListUtils();
        llu.addNode(1);
        llu.addNode(2);
        llu.addNode(3);
        llu.addNode(4);
        llu.addNode(5);
        llu.addNode(6);

        llu.generateLoopSingleTraceLinkList(3);
//        Integer integer = llu.meetingNode();
        Integer integer = llu.printEntranceNode();
        System.out.println(integer);
    }

    @Test
    public void reverseLinkListTest() {
        LinkedListUtils llu = new LinkedListUtils();
        llu.addNode(1);
//        llu.addNode(2);
//        llu.addNode(3);
//        llu.addNode(4);
//        llu.addNode(5);
//        llu.addNode(6);

        Node node = llu.reverseLinkList();
        System.out.println(node);
    }

    @Test
    public void mergeTwoSortedLinkList() {
        LinkedListUtils llu1 = new LinkedListUtils();
//        llu1.addNode(1);
//        llu1.addNode(3);
        llu1.addNode(3);
//        llu1.addNode(8);

        LinkedListUtils llu2 = new LinkedListUtils();
        llu2.addNode(2);
//        llu2.addNode(4);
//        llu2.addNode(4);
//        llu2.addNode(5);

        LinkedListUtils llu = new LinkedListUtils();
        Node node = llu.mergeTwoSortedLinkList(llu1.head, llu2.head);

    }

//    @Test
//    public void countNodesTest() {
//        LinkedListUtils llu = new LinkedListUtils();
//        llu.addNode(1);
//        llu.addNode(2);
//        llu.addNode(3);
//        llu.addNode(4);
//        llu.addNode(5);
//        int i = llu.countNodes(llu.head);
//    }
//
//    @Test
//    public void findTheFirstCommonNode() {
//        LinkedListUtils llu1 = new LinkedListUtils();
////        llu1.addNode(1);
////        llu1.addNode(2);
////        llu1.addNode(3);
//        llu1.addNode(1);
//        llu1.addNode(2);
//        llu1.addNode(3);
//        llu1.addNode(9);
//
//        LinkedListUtils llu2 = new LinkedListUtils();
//        llu2.addNode(4);
//        llu2.addNode(5);
//        llu2.addNode(6);
//        llu2.addNode(7);
//
//        Node resultNode = llu1.findFirstCommonNodeBetweenTwoLinkList(llu1.head, llu2.head);
//        System.out.println(2);
//    }

    @Test
    public void ifElseTest() {
        /**
         * 若存在多个if语句，按顺序执行，只要符合相应if语句的条件，均会进入该代码块。
         */
        int a = 10;
        if (a > 2) {
            System.out.println("(a = " + a + ") > 2"); // Hit
        }
        if (a > 5) {
            System.out.println("(a = " + a + ") > 5"); // Hit
        }

        /**
         * 若存在多个if、else if语句，按顺序执行，一旦符合某一条件语句，执行完相应代码，即结束。
         */
        int b = 20;
        if (b > 2) {
            System.out.println("(b = " + b + ") > 2"); // Hit
        } else if (b > 5) {
            System.out.println("(b = " + b + ") > 5");
        }
    }

    @Test
    public void buildBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.addNode(6);
        bt.addNode(4);
        bt.addNode(8);
        bt.addNode(3);
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(10);
        bt.addNode(88);
        bt.addNode(23);
        BinaryTreePrinter.printNode(bt.root);
        boolean b1 = bt.containNode(5);
        boolean b2 = bt.containNode(7);
        boolean b3 = bt.containNode(77);
    }

    /**
     * Professional test.
     */

    @Test
    public void addNodeTest() {
        LinkListUtils llu = new LinkListUtils();
        llu.addNode(1);
        llu.addNode(3);
        llu.addNode(9);
        llu.addNode(6);
        String result = llu.printNodes();
        Assert.assertEquals(result, "1 -> 3 -> 9 -> 6");
    }

    @Test
    public void containNodeTest() {
        LinkListUtils llu = new LinkListUtils();
        llu.addNode(1);
        llu.addNode(3);
        llu.addNode(9);
        llu.addNode(6);

        boolean contain3 = llu.containNode(3);
        boolean contain9 = llu.containNode(9);
        boolean contain7 = llu.containNode(7);

        Assert.assertTrue(contain3);
        Assert.assertTrue(contain9);
        Assert.assertFalse(contain7);
    }

//    @Test
//    public void findPreviousNodeBeforeDeleteNode(){
//        LinkListUtils llu = new LinkListUtils();
//        llu.addNode(1);
//        llu.addNode(3);
//        llu.addNode(9);
//        llu.addNode(6);
//
//        com.frankie.demo.review.linkList.Node previousNodeBeforeDeleted = llu.findPreviousNodeBeforeDeleted(9);
//        Assert.assertEquals(previousNodeBeforeDeleted.getVal(), 3);
//    }


    @Test
    public void deleteNodeTest2() {
        LinkListUtils llu = new LinkListUtils();
        llu.addNode(1);
        llu.addNode(3);
        llu.addNode(9);
        llu.addNode(6);

        llu.deleteNode(10);
        String deleteNode10 = llu.printNodes();
        Assert.assertEquals(deleteNode10, "1 -> 3 -> 9 -> 6");


        llu.deleteNode(9);
        String deleteNode9 = llu.printNodes();
        Assert.assertEquals(deleteNode9, "1 -> 3 -> 6");

        llu.deleteNode(1);
        String deleteNode1 = llu.printNodes();
        Assert.assertEquals(deleteNode1, "3 -> 6");

        llu.deleteNode(6);
        String deleteNode6 = llu.printNodes();
        Assert.assertEquals(deleteNode6, "3");
    }

    @Test
    public void buildCircleLinkListTest() {
        LinkListUtils llu = new LinkListUtils();
        llu.addNode(1);
        llu.addNode(3);
        llu.addNode(5);
        llu.addNode(7);
        llu.buildCircleNodeForLastOne(3);
    }

    @Test
    public void deleteNodeUsingO1Test() {
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(5);
        llu1.addNode(7);
        // 常规情况
        llu1.deleteNodeUsingO1(3);
        String result1 = llu1.printNodes();
        Assert.assertEquals(result1, "1 -> 5 -> 7");

        LinkListUtils llu2 = new LinkListUtils();
        llu2.addNode(1);
        llu2.addNode(3);
        llu2.addNode(5);
        llu2.addNode(7);
        // 边界条件1: 待删除节点位于头节点
        llu2.deleteNodeUsingO1(1);
        String result2 = llu2.printNodes();
        Assert.assertEquals(result2, "3 -> 5 -> 7");

        LinkListUtils llu3 = new LinkListUtils();
        llu3.addNode(1);
        llu3.addNode(3);
        llu3.addNode(5);
        llu3.addNode(7);
        // 边界条件2: 待删除节点位于尾节点
        llu3.deleteNodeUsingO1(7);
        String result3 = llu3.printNodes();
        Assert.assertEquals(result3, "1 -> 3 -> 5");


        LinkListUtils llu4 = new LinkListUtils();
        llu4.addNode(1);
        llu4.addNode(3);
        llu4.addNode(5);
        llu4.addNode(7);
        // 边界条件3: 链表中不包含待删除节点。
        llu4.deleteNodeUsingO1(9);
        String result4 = llu4.printNodes();
        Assert.assertEquals(result4, "1 -> 3 -> 5 -> 7");

        LinkListUtils llu5 = new LinkListUtils();
        llu5.addNode(1);
        // 边界条件4: 链表中仅包含一个节点。
        llu5.deleteNodeUsingO1(1);
        String result5 = llu5.printNodes();
        Assert.assertEquals(result5, "The link list is empty!");

    }

    @Test
    public void deleteDuplicateNodes2(){
        // 常规情况
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(3);
        llu1.addNode(5);
        llu1.deleteDuplicateNodes();
        String r1 = llu1.printNodes();
        Assert.assertEquals(r1, "1 -> 5");

        // 边界条件1: 链表中仅包含一个节点。
        LinkListUtils llu2 = new LinkListUtils();
        llu2.addNode(1);
        llu2.deleteDuplicateNodes();
        String r2 = llu2.printNodes();
        Assert.assertEquals(r2, "1");

        // 边界条件2: 链表中均为重复节点。
        LinkListUtils llu3 = new LinkListUtils();
        llu3.addNode(1);
        llu3.addNode(1);
        llu3.addNode(3);
        llu3.addNode(3);
        llu3.deleteDuplicateNodes();
        String r3 = llu3.printNodes();
        Assert.assertEquals(r3, "The link list is empty!");

        // 边界条件3: 链表中包含的重复节点在头节点。
        LinkListUtils llu4 = new LinkListUtils();
        llu4.addNode(1);
        llu4.addNode(1);
        llu4.addNode(3);
        llu4.addNode(5);
        llu4.deleteDuplicateNodes();
        String r4 = llu4.printNodes();
        Assert.assertEquals(r4, "3 -> 5");

        // 边界条件4: 链表中包含的重复节点在尾节点。
        LinkListUtils llu5 = new LinkListUtils();
        llu5.addNode(1);
        llu5.addNode(3);
        llu5.addNode(5);
        llu5.addNode(5);
        llu5.deleteDuplicateNodes();
        String r5 = llu5.printNodes();
        Assert.assertEquals(r5, "1 -> 3");

        // 边界条件5: 链表中包含多个值不同的重复节点。
        LinkListUtils llu6 = new LinkListUtils();
        llu6.addNode(1);
        llu6.addNode(3);
        llu6.addNode(3);
        llu6.addNode(5);
        llu6.addNode(5);
        llu6.addNode(7);
        llu6.deleteDuplicateNodes();
        String r6 = llu6.printNodes();
        Assert.assertEquals(r6, "1 -> 7");

        // 边界条件6: 链表中不包含重复节点。
        LinkListUtils llu7 = new LinkListUtils();
        llu7.addNode(1);
        llu7.addNode(3);
        llu7.addNode(5);
        llu7.addNode(7);
        llu7.deleteDuplicateNodes();
        String r7 = llu7.printNodes();
        Assert.assertEquals(r7, "1 -> 3 -> 5 -> 7");
    }

    @Test
    public void deleteMiddleNode2(){
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(5);
        llu1.addNode(7);
        // 链表总数为奇数。
        llu1.deleteMiddleNode();
        String r1 = llu1.printNodes();
        Assert.assertEquals(r1, "1 -> 3 -> 7");

        LinkListUtils llu2 = new LinkListUtils();
        llu2.addNode(1);
        llu2.addNode(3);
        llu2.addNode(5);
        llu2.addNode(7);
        llu2.addNode(9);
        // 链表总数为偶数。
        llu2.deleteMiddleNode();
        String r2 = llu2.printNodes();
        Assert.assertEquals(r2, "1 -> 3 -> 7 -> 9");

        LinkListUtils llu3 = new LinkListUtils();
        llu3.addNode(1);
        // 边界条件1: 链表仅包含1个节点。
        llu3.deleteMiddleNode();
        String r3 = llu3.printNodes();
        Assert.assertEquals(r3, "1");

        LinkListUtils llu4 = new LinkListUtils();
        llu4.addNode(1);
        llu4.addNode(2);
        // 边界条件2: 链表仅包含2个节点。
        llu4.deleteMiddleNode();
        String r4 = llu4.printNodes();
        Assert.assertEquals(r4, "1 -> 2");
    }

    @Test
    public void reverseLinkListTest2(){
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(5);
        com.frankie.demo.review.linkList.Node reversedLinkList1 = llu1.reverseLinkList();

        LinkListUtils llu2 = new LinkListUtils();
        llu2.addNode(1);
        com.frankie.demo.review.linkList.Node reversedLinkList2 = llu2.reverseLinkList();
    }

    @Test
    public void printLinkedListReverselyUsingRecursiveTest(){
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(5);
//        llu1.printLinkListReverselyUsingRecursive(llu1.head);
        llu1.printLinkListReverselyUsingStack(llu1.head);
    }

    @Test
    public void printLastKNodeTest2(){
        LinkListUtils llu1 = new LinkListUtils();
        llu1.addNode(1);
        llu1.addNode(3);
        llu1.addNode(5);
        llu1.addNode(7);
        llu1.addNode(9);
        com.frankie.demo.review.linkList.Node last2Node = llu1.printLastKNode(2);
        Assert.assertEquals(String.valueOf(last2Node.getVal()), "7");

        com.frankie.demo.review.linkList.Node last4Node = llu1.printLastKNode(4);
        Assert.assertEquals(String.valueOf(last4Node.getVal()), "3");

        // 边界条件1: k > length
        LinkListUtils llu2 = new LinkListUtils();
        llu2.addNode(1);
        llu2.addNode(3);
        llu2.addNode(5);
        com.frankie.demo.review.linkList.Node node1 = llu2.printLastKNode(4);
        Assert.assertEquals(node1, null);

        // 边界条件2: k < 0
        LinkListUtils llu3 = new LinkListUtils();
        llu3.addNode(1);
        llu3.addNode(3);
        llu3.addNode(5);
        com.frankie.demo.review.linkList.Node node2 = llu3.printLastKNode(-2);
        Assert.assertEquals(node2, null);


        // 边界条件3: k = 0
        LinkListUtils llu4 = new LinkListUtils();
        llu4.addNode(1);
        llu4.addNode(3);
        llu4.addNode(5);
        com.frankie.demo.review.linkList.Node node3 = llu4.printLastKNode(0);
        Assert.assertEquals(node3, null);

    }

    @Test
    public void pushTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(null);

        Integer pop = stack.pop();
    }

    @Test
    public void buildBinaryTreeTest(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(40);
        bt.addNode(20);
        bt.addNode(20);
//        bt.addNode(60);
//        bt.addNode(10);
//        bt.addNode(30);
//        bt.addNode(50);
//        bt.addNode(70);
//        bt.addNode(42);
//        bt.addNode(55);
//        bt.addNode(53);
//        bt.addNode(59);
        BinaryTreePrinter.printNode(bt.root);
//        bt.preOrderTraversal(bt.root);
//        bt.inOrderTraversal(bt.root);
//        bt.postOrderTraversal(bt.root);
//        bt.preOrderTraversalUsingRecursive(bt.root);
//        bt.inOrderTraversalUsingRecursive(bt.root);
//        bt.postOrderTraversalUsingRecursive(bt.root);
//        bt.levelOrderTraserval(bt.root);
//        bt.deleteNode(bt.root, 59);

        System.out.println("After delete node.");
        BinaryTreePrinter.printNode(bt.root);
    }

    @Test
    public void traversalTest(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(5);
        bt.addNode(20);
        bt.addNode(1);
        bt.addNode(7);
        bt.addNode(12);
        bt.addNode(30);
//        bt.inOrderTraversal(bt.root);
//        bt.postOrderTraversal2(bt.root);
//        bt.preOrderTraversalUsingRecursive(bt.root);
//        bt.inOrderTraversalUsingRecursive(bt.root);
//        bt.postOrderTraversalUsingRecursive(bt.root);
        bt.levelOrderTraserval2(bt.root);
    }

    @Test
    public void fibonaciiEfficiencyTest(){
        LocalDateTime start = LocalDateTime.now();
        BinaryTree bt = new BinaryTree();
        bt.fibonacciOptimization(500);
        LocalDateTime end = LocalDateTime.now();
        long l = Duration.between(start, end).toMillis();
        System.out.println(l);
    }

    @Test
    public void fibonacciTest(){
        BinaryTree bt = new BinaryTree();
        int result = bt.fibonacciOptimization(6);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void operatorTest(){
        int a = 224;
        int i = a >> 3;  // Signed
        int b = a >>> 3; // Unsigned
    }


    @Test
    public void stackTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);

        Integer pop5 = stack.pop();
        Integer peek3 = stack.peek();

        Assert.assertEquals(String.valueOf(pop5), "5");
        Assert.assertEquals(String.valueOf(peek3), "3");
    }


    @Test
    public void deleteLeafNodeFromTree(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(40);
        bt.addNode(20);
        bt.addNode(60);
        bt.addNode(10);
        bt.addNode(30);
        bt.addNode(50);
        bt.addNode(70);
        bt.addNode(3);
        bt.addNode(42);
        bt.addNode(55);
        bt.addNode(80);
        bt.addNode(53);
        bt.addNode(59);
        BinaryTreePrinter.printNode(bt.root);
        bt.deleteNode(bt.root, 50);
        System.out.println("After delete node.");
        BinaryTreePrinter.printNode(bt.root);
    }

    @Test
    public void deleteNodeWithOneChildFromTree(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(40);
        bt.addNode(20);
        bt.addNode(60);
        bt.addNode(10);
        bt.addNode(30);
        bt.addNode(50);
        bt.addNode(70);
        bt.addNode(42);
        bt.addNode(55);
        bt.addNode(53);
        bt.addNode(59);
        bt.addNode(80);
        BinaryTreePrinter.printNode(bt.root);
        bt.deleteNode(bt.root, 70);

        System.out.println("After delete node.");
        BinaryTreePrinter.printNode(bt.root);
    }

    @Test
    public void deleteNodeWithTwoChildFromTree(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(40);
        bt.addNode(20);
        bt.addNode(60);
        bt.addNode(10);
        bt.addNode(30);
        bt.addNode(50);
        bt.addNode(70);
        bt.addNode(42);
        bt.addNode(55);
        bt.addNode(53);
        bt.addNode(59);
        bt.addNode(80);
        BinaryTreePrinter.printNode(bt.root);
        bt.deleteNode(bt.root, 50);

        System.out.println("After delete node.");
        BinaryTreePrinter.printNode(bt.root);
    }


    @Test
    public void hasSubtreeTest(){
        BinaryTree bt1 = new BinaryTree();
        bt1.addNode(10);
        bt1.addNode(5);
        bt1.addNode(20);
        bt1.addNode(1);
        bt1.addNode(8);
        bt1.addNode(15);
        bt1.addNode(25);
        BinaryTreePrinter.printNode(bt1.root);

        BinaryTree bt2 = new BinaryTree();
        bt2.addNode(20);
        bt2.addNode(15);
        bt2.addNode(25);

        boolean result = bt1.hasSubtree(bt1.root, bt2.root);
        System.out.println(result);
    }

    @Test
    public void doubleCompareTest(){
        double a = 19.9;
        double b = 9.9;

        double v = a - b;
    }

    @Test
    public void nextNodeTesT(){
        BinaryTree bt = new BinaryTree();
        bt.root = new com.frankie.demo.binaryTree.Node(40);
        com.frankie.demo.binaryTree.Node node20 = new com.frankie.demo.binaryTree.Node(20);
        com.frankie.demo.binaryTree.Node node60 = new com.frankie.demo.binaryTree.Node(60);
        com.frankie.demo.binaryTree.Node node10 = new com.frankie.demo.binaryTree.Node(10);
        com.frankie.demo.binaryTree.Node node30 = new com.frankie.demo.binaryTree.Node(30);
        com.frankie.demo.binaryTree.Node node50 = new com.frankie.demo.binaryTree.Node(50);
        com.frankie.demo.binaryTree.Node node70 = new com.frankie.demo.binaryTree.Node(70);
        com.frankie.demo.binaryTree.Node node25 = new com.frankie.demo.binaryTree.Node(25);
        com.frankie.demo.binaryTree.Node node35 = new com.frankie.demo.binaryTree.Node(35);

        node30.setLeftNode(node25);
        node30.setRightNode(node35);
        node25.setParentNode(node30);
        node35.setParentNode(node30);

        node20.setLeftNode(node10);
        node20.setRightNode(node30);
        node10.setParentNode(node20);
        node30.setParentNode(node20);

        node60.setLeftNode(node50);
        node60.setRightNode(node70);
        node50.setParentNode(node60);
        node50.setParentNode(node70);

        bt.root.setLeftNode(node20);
        bt.root.setRightNode(node60);
        node20.setParentNode(bt.root);
        node60.setParentNode(bt.root);

//        BinaryTreePrinter.printNode(bt.root);
        com.frankie.demo.binaryTree.Node node = bt.returnNextNode(node35);
    }

    @Test
    public void rebuildBtTest(){
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in  = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree bt = new BinaryTree();
        com.frankie.demo.binaryTree.Node node = bt.rebuildBinaryTree(pre, in);
        System.out.println(node);
    }

    @Test
    public void mirrorBinaryTreeTest(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(8);
        bt.addNode(6);
        bt.addNode(10);
        bt.addNode(5);
        bt.addNode(7);
//        bt.addNode(9);
//        bt.addNode(11);
        com.frankie.demo.binaryTree.Node node = bt.mirrorRecursively(bt.root);
    }

    @Test
    public void isSymmetricalTest(){
        BinaryTree bt = new BinaryTree();
        bt.root = new com.frankie.demo.binaryTree.Node(10);

        com.frankie.demo.binaryTree.Node node201 = new com.frankie.demo.binaryTree.Node(20);
        com.frankie.demo.binaryTree.Node node202 = new com.frankie.demo.binaryTree.Node(20);
        com.frankie.demo.binaryTree.Node node701 = new com.frankie.demo.binaryTree.Node(70);
        com.frankie.demo.binaryTree.Node node702 = new com.frankie.demo.binaryTree.Node(70);
        com.frankie.demo.binaryTree.Node node301 = new com.frankie.demo.binaryTree.Node(30);
        com.frankie.demo.binaryTree.Node node302 = new com.frankie.demo.binaryTree.Node(30);

        node201.setLeftNode(node701);
        node201.setRightNode(node301);
        node202.setLeftNode(node302);
        node202.setRightNode(node702);
        bt.root.setLeftNode(node201);
        bt.root.setRightNode(node202);
        BinaryTreePrinter.printNode(bt.root);

        boolean result = bt.isSymmetrical(bt.root);
        Assert.assertTrue(result);
    }

    @Test
    public void veriftSequenceOfBSTTest(){
        int[] seq = {5, 7, 6, 9, 11, 10, 8};
//        int[] seq = {5, 7, 6, 18, 12, 15, 10};
        BinaryTree bt = new BinaryTree();
        boolean result = bt.verifySequenceOfBST(seq);
        Assert.assertTrue(result);
    }

    @Test
    public void arrayListTest(){
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> result = new ArrayList<>(integers);
        integers.add(7);
    }

    @Test
    public void returnPathsTest(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(10);
        bt.addNode(5);
        bt.addNode(12);
        bt.addNode(4);
        bt.addNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = bt.returnPaths(bt.root, 22);
    }

    @Test
    public void returnFirstKNodeFromBST(){
        BinaryTree bt = new BinaryTree();
        bt.addNode(5);
        bt.addNode(3);
        bt.addNode(7);
        bt.addNode(2);
        bt.addNode(4);
        bt.addNode(6);
        bt.addNode(8);
        com.frankie.demo.binaryTree.Node node = bt.returnFirstKNode(bt.root, 3);
        System.out.println(2);
    }

    @Test
    public void calculateTreeDepth(){
        BinaryTree bt = new BinaryTree();
        bt.root = new com.frankie.demo.binaryTree.Node(1);

        com.frankie.demo.binaryTree.Node n2 = new com.frankie.demo.binaryTree.Node(2);
        com.frankie.demo.binaryTree.Node n3 = new com.frankie.demo.binaryTree.Node(3);
        com.frankie.demo.binaryTree.Node n4 = new com.frankie.demo.binaryTree.Node(4);
        com.frankie.demo.binaryTree.Node n5 = new com.frankie.demo.binaryTree.Node(5);
        com.frankie.demo.binaryTree.Node n6 = new com.frankie.demo.binaryTree.Node(6);
        com.frankie.demo.binaryTree.Node n7 = new com.frankie.demo.binaryTree.Node(7);

        n5.setLeftNode(n7);
        n2.setLeftNode(n4);
        n2.setRightNode(n5);
        n3.setRightNode(n6);
        bt.root.setLeftNode(n2);
        bt.root.setRightNode(n3);

        BinaryTreePrinter.printNode(bt.root);
        int depth = bt.treeDepth(bt.root);
        Assert.assertEquals(depth, 4);
    }

    @Test
    public void isBalancedTreeTest(){
        BinaryTree bt = new BinaryTree();
        bt.root = new com.frankie.demo.binaryTree.Node(1);

        com.frankie.demo.binaryTree.Node n2 = new com.frankie.demo.binaryTree.Node(2);
        com.frankie.demo.binaryTree.Node n3 = new com.frankie.demo.binaryTree.Node(3);
        com.frankie.demo.binaryTree.Node n4 = new com.frankie.demo.binaryTree.Node(4);
        com.frankie.demo.binaryTree.Node n5 = new com.frankie.demo.binaryTree.Node(5);
        com.frankie.demo.binaryTree.Node n6 = new com.frankie.demo.binaryTree.Node(6);
        com.frankie.demo.binaryTree.Node n7 = new com.frankie.demo.binaryTree.Node(7);
        com.frankie.demo.binaryTree.Node n8 = new com.frankie.demo.binaryTree.Node(8);

        n7.setRightNode(n8);
        n5.setLeftNode(n7);
        n2.setLeftNode(n4);
        n2.setRightNode(n5);
        n3.setRightNode(n6);
        bt.root.setLeftNode(n2);
        bt.root.setRightNode(n3);

        BinaryTreePrinter.printNode(bt.root);
//        boolean balancedTree = bt.isBalancedTree(bt.root);
        boolean balancedTreeOptimization = bt.isBalancedTreeOptimization(bt.root);
        Assert.assertFalse(balancedTreeOptimization);
    }


    @Test
    public void doubleStackTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        cu.queueAddElementUsingDoubleStacks(1);
        cu.queueAddElementUsingDoubleStacks(2);
        cu.queueAddElementUsingDoubleStacks(3);

        int i1 = cu.queueRemoveElementUsingDoubleStacks();
        int i2 = cu.queueRemoveElementUsingDoubleStacks();
        int i3 = cu.queueRemoveElementUsingDoubleStacks();
        int i4 = cu.queueRemoveElementUsingDoubleStacks();

        Assert.assertEquals(i1, 1);
        Assert.assertEquals(i2, 2);
        Assert.assertEquals(i3, 3);
        Assert.assertEquals(i4, -1);
    }


    @Test
    public void doubleQueueTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        cu.stackAddElementUsingDoubleQueue(1);
        cu.stackAddElementUsingDoubleQueue(2);
        cu.stackAddElementUsingDoubleQueue(3);

        int i3 = cu.stackRemoveElementUsingDoubleQueue();
        int i2 = cu.stackRemoveElementUsingDoubleQueue();
        int i1 = cu.stackRemoveElementUsingDoubleQueue();

        Assert.assertEquals(i1, 1);
        Assert.assertEquals(i2, 2);
        Assert.assertEquals(i3, 3);
    }

    @Test
    public void minNumberInRotatedArrayTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int[] a = {3, 4, 5, 1, 2};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {1, 0, 1, 1, 1};
        int a1 = cu.minNumberInRotatedArray(a);
        int b1 = cu.minNumberInRotatedArray(b);
        int c0 = cu.minNumberInRotatedArray(c);

        Assert.assertEquals(a1, 1);
        Assert.assertEquals(b1, 1);
        Assert.assertEquals(c0, 0);
    }

    @Test
    public void cuttingTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int a4  = cu.maxProductAfterCutting(4);
        int a6  = cu.maxProductAfterCutting(5);
        int a9  = cu.maxProductAfterCutting(6);
        int a12 = cu.maxProductAfterCutting(7);
        int a18 = cu.maxProductAfterCutting(8);

        Assert.assertEquals(a4, 4);
        Assert.assertEquals(a6, 6);
        Assert.assertEquals(a9, 9);
        Assert.assertEquals(a12, 12);
        Assert.assertEquals(a18, 18);
    }

    @Test
    public void andOperatorTest(){
        // 1001
        int x = 9;

        int i = x & 1;
        Assert.assertEquals(i, 1);
    }

    @Test
    public void numberOfOne(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int i2 = cu.numberOfOne(9);
        int i1 = cu.numberOfOne(1);
        int i0 = cu.numberOfOne(0);
        int i = cu.numberOfOne(-3);

        Assert.assertEquals(i2, 2);
        Assert.assertEquals(i1, 1);
        Assert.assertEquals(i0, 0);
    }

    @Test
    public void addUsingBitOperationTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int a22= cu.AddUsingBitOperation(5, 17);
        int a12= cu.AddUsingBitOperation(-5, 17);

        Assert.assertEquals(a12, 12);
        Assert.assertEquals(a22, 22);
    }

    @Test
    public void findNumberAppearingOnceTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int[] nums = {2000, 2222, 11111, 2222, 2000};
        int result = cu.findNumberAppearingOnce(nums);

        Assert.assertEquals(result, 11111);
    }

    @Test
    public void findTwoNumberAppearingOnceTest(){
        ComprehensiveUtils cu = new ComprehensiveUtils();
        int[] nums = {2000, 2222, 11111, 2222, 2000, 333};
        ArrayList<Integer> result = cu.findTwoNumberAppearingOnce(nums);
    }
}

























