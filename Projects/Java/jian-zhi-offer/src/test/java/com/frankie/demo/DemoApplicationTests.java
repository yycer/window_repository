package com.frankie.demo;

import com.frankie.demo.binaryTree.BinaryTree;
import com.frankie.demo.binaryTree.BinaryTreePrinter;
import com.frankie.demo.review.linkList.LinkListUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
}


























