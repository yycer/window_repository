package com.frankie.demo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {

    private Integer value;
    private Node next;

    public Node(int val){
        value  = val;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
