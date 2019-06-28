package com.frankie.demo.binaryTree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
    public int val;
    private Node leftNode;
    private Node rightNode;

    Node(int val){
        this.val  = val;
        leftNode  = null;
        rightNode = null;
    }
}
