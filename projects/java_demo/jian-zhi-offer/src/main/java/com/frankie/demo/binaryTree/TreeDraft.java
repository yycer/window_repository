package com.frankie.demo.binaryTree;


import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayDeque;
import java.util.Stack;

public class TreeDraft {

    public Node addNodeRecuresively(Node node, int val){

        if (node == null) {
            return new Node(val);
        }

        if (val < node.getVal()) {
            addNodeRecuresively(node.getLeftNode(), val);
        } else if (val > node.getVal()) {
            addNodeRecuresively(node.getRightNode(), val);
        } else {
            return node;
        }

        return node;
    }

    public boolean containNode(Node curNode, int val){
        if (curNode == null){
            return false;
        }

        if (curNode.getVal() == val){
            return true;
        }

        return val < curNode.getVal()
             ? containNode(curNode.getLeftNode(), val)
             : containNode(curNode.getRightNode(), val);
    }

//    public void preOrder(Node node){
//        if (node == null) return;
//
//        Stack<Node> stack = new Stack<>();
//        stack.push(node);
//        System.out.println("pre order");
//
//        while (stack.size() > 0){
//            Node pop = stack.pop();
//            System.out.print(pop.getVal() + " ");
//
//            if (pop.getRightNode() != null) stack.push(pop.getRightNode());
//            if (pop.getLeftNode() != null) stack.push(pop.getLeftNode());
//        }
//    }
//
//    public void inOrder(Node node){
//        if (node == null) return;
//
//        Stack<Node> nodes = new Stack<>();
//
//        while (node != null || nodes.size() > 0){
//
//            while (node != null){
//                nodes.push(node);
//                node = node.getLeftNode();
//            }
//            node = nodes.pop();
//            System.out.print(node.getVal() + " ");
//            node = node.getRightNode();
//        }
//    }
//
//
//    public void postOrder(Node node){
//        if (node == null) return;
//
//        Stack<Node> nodes = new Stack<>();
//        Stack<Integer> values = new Stack<>();
//
//        while (node != null || nodes.size() > 0){
//            while (node != null){
//                nodes.push(node);
//                values.push(node.getVal());
//                node = node.getRightNode();
//            }
//
//            node = nodes.pop();
//            node = node.getLeftNode();
//        }
//
//        while (!values.isEmpty()){
//            System.out.print(values.pop() + " ");
//        }
//    }
//
//    public void levelOrder(Node node){
//        if (node == null) return;
//        ArrayDeque<Node> queue = new ArrayDeque<>();
//        queue.add(node);
//
//        while (queue.size() > 0){
//            node = queue.removeFirst();
//            System.out.print(node.getVal() + " ");
//
//            if (node.getLeftNode() != null) queue.add(node.getLeftNode());
//            if (node.getRightNode() != null) queue.add(node.getRightNode());
//        }
//    }


    public void preOrderRecursively(Node node){
        if (node == null) return;

        System.out.print(node.getVal() + " ");
        preOrderRecursively(node.getLeftNode());
        preOrderRecursively(node.getRightNode());
    }

    public void inOrderRecursively(Node node){
        if (node == null) return;

        inOrderRecursively(node.getLeftNode());
        System.out.print(node.getVal() + " ");
        inOrderRecursively(node.getRightNode());
    }


    public Node deleteNode(Node node, int val){
        if (node == null) return null;

        if (val < node.getVal()) {
            node.setLeftNode(deleteNode(node.getLeftNode(), val));
        } else if (val > node.getVal()) {
            node.setRightNode(deleteNode(node.getRightNode(), val));
        } else{
            if (node.getLeftNode() != null && node.getRightNode() != null){

                Node tempNode = node;
                Node minNode = minElementInRight(tempNode.getRightNode());
                node.setVal(minNode.getVal());
                node.setRightNode(deleteNode(node.getRightNode(), minNode.getVal()));
            }
            else if (node.getLeftNode() != null){
                node = node.getLeftNode();
            }
            else if (node.getRightNode() != null){
                node = node.getRightNode();
            }
            else{
                return null;
            }
        }
        return node;
    }


    public Node minElementInRight(Node node) {

        if (node == null){
            return null;
        }

        while (node.getLeftNode() != null){
            node = node.getLeftNode();
        }

        return node;
    }

    public Node findNextTreeNode(Node node){
        if (node == null) return null;

        if (node.getRightNode() != null){
            Node minNode = getMinNodeFromRight(node.getRightNode());
            return minNode;
        }

        while (node.getParentNode() != null){
            if (node.getParentNode().getLeftNode() == node){
                return node.getParentNode();
            }
            node = node.getParentNode();
        }

        return null;
    }

    private Node getMinNodeFromRight(Node node) {
        while (node.getLeftNode() != null){
            node = node.getLeftNode();
        }

        return node;
    }

}




















