package com.frankie.demo;

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

        for (int i = 0; i < a.length; i++){
            if (!uniqueList.contains(a[i])){
                uniqueList.add(a[i]);
            } else{
                repeatedList.add(a[i]);
            }
        }
        System.out.println("2");
    }

    @Test
    public void indexWayTest(){
        int[] a = {2, 0, 3, 1, 2};

        boolean duplicated = ArrayUtils.isDuplicated(a);
        System.out.println(2);
    }

    @Test
    public void localDatetimeTest(){
        LocalDateTime ldt = LocalDateTime.of(LocalDateTime.now().getYear(), 6, 13, 0, 0);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = ldt.format(dateTimeFormatter);

        System.out.println(2);
    }

    @Test
    public void getMonthAndDay(){
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
        if (c1 > 48 || c1 < 57){
            result = String.valueOf(c1) + c;
        } else{
            result = String.valueOf(c);
        }

        System.out.println(result);

        String dayDigit = s.substring(month + 1, day);

        System.out.println(2);

    }

    @Test
    public void duplicateDichotomyTest(){
        int[] a = {2, 7, 3, 4, 2, 6, 4, 1};
        Integer duplicateInteger = ArrayUtils.isDuplicateDichotomy(a);
        System.out.println(duplicateInteger);
    }

    @Test
    public void printMatrix(){
        ArrayUtils.printMatrix();
    }

    @Test
    public void isExistedInMatrix(){
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
    public void replaceBlank(){

        String s = "hello world a b c";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != 32) sb.append(s.charAt(i));
            else sb.append("%20");
        }
        String result = new String(sb);
        Assert.assertEquals(result, "hello%20world%20a%20b%20c");
    }

    @Test
    public void convertTest(){
        StreamUtils streamUtils = new StreamUtils();
//        streamUtils.convertInTwoListWay1();
        streamUtils.convertInTwoListWay2();
    }


    @Test
    public void deleteMiddleOfLinkListTest(){
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
    public void doWhileTest(){
        int i = 5;
        do {
            System.out.println(i);
            i++;
        }while (i < 10);
    }


    @Test
    public void deleteNodeTest(){
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
    public void deleteDuplicateNodesTest(){

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
}
