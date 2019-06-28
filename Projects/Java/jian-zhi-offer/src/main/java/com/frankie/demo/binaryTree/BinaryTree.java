package com.frankie.demo.binaryTree;

public class BinaryTree {

    public Node root;

    public Node addRecursive(Node cur, int val){
        if (cur == null) {
            return new Node(val);
        }

        if (val < cur.getVal()){
            cur.setLeftNode(addRecursive(cur.getLeftNode(), val));
        } else if (val > cur.getVal()){
            cur.setRightNode(addRecursive(cur.getRightNode(), val));
        } else{
            return cur;
        }
        return cur;
    }

    public void addNode(int val){
        root = addRecursive(root, val);
    }

}
