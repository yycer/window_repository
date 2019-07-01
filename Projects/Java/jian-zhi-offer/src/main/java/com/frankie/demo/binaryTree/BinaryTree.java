package com.frankie.demo.binaryTree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class BinaryTree {

    public Node root;

    private Node addNodeRecursive(Node cur, int val){
        if (cur == null) {
            return new Node(val);
        }

        if (val < cur.getVal()){
            cur.setLeftNode(addNodeRecursive(cur.getLeftNode(), val));
        } else if (val > cur.getVal()){
            cur.setRightNode(addNodeRecursive(cur.getRightNode(), val));
        } else{
            return cur;
        }
        return cur;
    }

    public void addNode(int val){
        root = addNodeRecursive(root, val);
    }

    private boolean containNodeRecursive(Node cur, int val){
        if (cur == null) return false;
        if (cur.getVal() == val) return true;

        // 如果待查询节点的值大于当前节点的值
        return (val > cur.getVal())
                // 继续遍历其右子树
                ? containNodeRecursive(cur.getRightNode(), val)
                // 否则继续遍历其左子树
                : containNodeRecursive(cur.getLeftNode(), val);
    }

    public boolean containNode(int val){
        return containNodeRecursive(root, val);
    }

    /**
     * 先序遍历(循环法、栈方式)
     */
    public void preOrderTraversal(Node node){

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        System.out.println("先序遍历: ");
        while (stack.size() > 0){
            Node curNode = stack.pop();
            System.out.print(curNode.getVal() + " ");

            // 先右再左的原因: 符合栈的特性，后进先出。
            if (curNode.getRightNode() != null){
                stack.push(curNode.getRightNode());
            }

            if (curNode.getLeftNode()  != null){
                stack.push(curNode.getLeftNode());
            }
        }
    }

    /**
     * 中序遍历(循环法、栈方式)
     */
    public void inOrderTraversal(Node node){
        Stack<Node> stack = new Stack<>();

        System.out.println("中序遍历: ");
        while (node != null || stack.size() > 0){

            // 将所有左子树压入栈中。
            while (node != null){
                stack.push(node);
                node = node.getLeftNode();
            }

            if (stack.size() > 0){
                node = stack.pop();
                System.out.print(node.getVal() + " ");
                node = node.getRightNode();
            }
        }
    }

    /**
     * 后续遍历(循环法、栈方式)
     * @param node
     */
    public void postOrderTraversal(Node node){
        Stack<Node> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        while (node != null || stack.size() > 0){
            // 先将右子树压栈。
            while (node != null){
                stack.push(node);
                valueStack.push(node.getVal());
                node = node.getRightNode();
            }

            node = stack.pop();
            node = node.getLeftNode();
        }

        System.out.println("后续遍历: ");
        while (!valueStack.isEmpty()){
            System.out.print(valueStack.pop() + " ");
        }
    }
}




















