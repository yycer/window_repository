package com.frankie.demo;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

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
    public void createLinkedList(){
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        linkedListUtils.addNode(3);
        linkedListUtils.addNode(6);
        linkedListUtils.addNode(9);
        linkedListUtils.addNode(5);
//        linkedListUtils.printNodes();
//        Integer count = linkedListUtils.countNodes();
        String s = linkedListUtils.printReverseNode();

    }

    @Test
    public void replaceStrTest(){
        String s = "5 -> 9 -> 6 -> 3 -> ";
        String substring = s.substring(0, s.length() - 4);
    }

}
