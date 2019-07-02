package com.frankie.demo.binaryTree;

import com.frankie.demo.LinkedListUtils;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
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

    public int fibonacii(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;

        return fibonacii(n-1) + fibonacii(n - 2);
    }

    public int fibonaciiOptimize1(int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long result       = 0;

        for (int i = 2; i < n; i++){
            result       = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = result;
        }

        return (int)result;
    }

    /**
     * 先序遍历(递归法)
     * @param node
     */
    public void preOrderTraversalUsingRecursive(Node node){
        if (node == null) return;

        System.out.print(node.getVal() + " ");
        preOrderTraversalUsingRecursive(node.getLeftNode());
        preOrderTraversalUsingRecursive(node.getRightNode());
    }

    /**
     * 中序遍历(递归法)
     * @param node
     */
    public void inOrderTraversalUsingRecursive(Node node){
        if (node == null) return;

        inOrderTraversalUsingRecursive(node.getLeftNode());
        System.out.print(node.getVal() + " ");
        inOrderTraversalUsingRecursive(node.getRightNode());
    }

    /**
     * 后序遍历(递归法)
     * @param node
     */
    public void postOrderTraversalUsingRecursive(Node node){
        if (node == null) return;

        postOrderTraversalUsingRecursive(node.getLeftNode());
        postOrderTraversalUsingRecursive(node.getRightNode());
        System.out.print(node.getVal() + " ");
    }


    /**
     * 广度优先遍历(队列)
     */
    public void levelOrderTraserval(Node node){
        if (node == null){
            System.out.println("Empty tree!");
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node curNode = queue.remove();
            System.out.print(curNode.getVal() + " ");
            if (curNode.getLeftNode() != null){
                queue.add(curNode.getLeftNode());
            }
            if (curNode.getRightNode() != null){
                queue.add(curNode.getRightNode());
            }
        }
    }

    /**

     */
    /**
     * 删除树中节点。
     * 1. 删除的为叶子节点   => null
     * 2. 删除的包含一个节点 => 直接顶替。
     * 3. 删除的包含两个节点 => 找右子树中最小的顶替。
     * @param node
     * @param val: 待删除节点的值。
     */
    public Node deleteNode(Node node, int val){
        // Step0: Base check.
        if (node == null) return null;

        // Step1: 定位待删除元素。
        if      (node.getVal() > val){
            node.setLeftNode(deleteNode(node.getLeftNode(), val));
        }
        else if (node.getVal() < val){
            node.setRightNode(deleteNode(node.getRightNode(), val));
        }
        else {
            // Step2: 三种情况。
            // 情况1: 删除的包含两个节点。
            if      (node.getLeftNode() != null && node.getRightNode() != null){
                Node tmpNode = node;
                Node minNodeForRight = minElementInRight(tmpNode.getRightNode());
                node.setVal(minNodeForRight.getVal());
                deleteNode(node.getRightNode(), minNodeForRight.getVal());
            }
            // 情况2.1: 删除的包含一个节点(左)
            else if (node.getLeftNode() != null){
                node = node.getLeftNode();
            }
            // 情况2.2: 删除的包含一个节点(右)
            else if (node.getRightNode() != null){
                node = node.getRightNode();
            }
            // 删除的为叶子节点
            else{
                node = null;
            }
        }
        return node;
    }



    // region Private methods

    /**
     * 定位到当前结点右子树中最小的元素。
     * @param node
     * @return
     */
    private Node minElementInRight(Node node){
        if (node.getLeftNode() == null) {
            return node;
        } else {
            return minElementInRight(root.getLeftNode());
        }

    }

    // endregion
}




















