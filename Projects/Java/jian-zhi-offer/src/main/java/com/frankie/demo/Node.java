package com.frankie.demo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {

    private Integer val;
    private Node next;

    public Node(int val){
        val  = val;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
