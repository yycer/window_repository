package com.frankie.demo.binaryTree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
    public int val;
    private Node leftNode;
    private Node rightNode;
    private Node parentNode;

    public Node(int val){
        this.val  = val;
        leftNode  = null;
        rightNode = null;
    }
}
