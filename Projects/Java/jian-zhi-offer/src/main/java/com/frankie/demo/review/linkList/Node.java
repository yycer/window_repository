package com.frankie.demo.review.linkList;/*
 @author: Administrator
 @date: 2019/6/29-16:25
*/

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {

    private int  val;
    private Node next;

    Node(int val){
        this.val  = val;
        this.next = null;
    }
}
