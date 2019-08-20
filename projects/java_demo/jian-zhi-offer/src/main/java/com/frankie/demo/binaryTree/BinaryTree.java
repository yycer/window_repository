package com.frankie.demo.binaryTree;

import java.util.*;

public class BinaryTree {

    public Node root;

    /**
     * 递归法构建二叉搜索树。
     */
    public void addNode(int val){
        // 根节点随着新节点的增加而改变。
        root = addNodeRecursive(root, val);
    }

    private Node addNodeRecursive(Node curNode, int val){
        if (curNode == null) {
            return new Node(val);
        }

        if (val < curNode.getVal()){
            curNode.setLeftNode(addNodeRecursive(curNode.getLeftNode(), val));
        } else if (val > curNode.getVal()){
            curNode.setRightNode(addNodeRecursive(curNode.getRightNode(), val));
        } else{
            return curNode;
        }
        return curNode;
    }

    /**
     * 判断一棵二叉搜索树中是否包含值为某个数的节点。
     */
    public boolean containNode(int val){
        return containNodeRecursive(root, val);
    }

    private boolean containNodeRecursive(Node curNode, int val){
        if (curNode          == null) {
            return false;
        }
        if (curNode.getVal() == val) {
            return true;
        }

        // 如果待查找节点的值小于当前节点的值。
        return (val < curNode.getVal())
                // 继续遍历其左子树。
                ? containNodeRecursive(curNode.getLeftNode(), val)
                // 否则继续遍历其右子树。
                : containNodeRecursive(curNode.getRightNode(), val);
    }


    /**
     * 先序遍历(循环法、栈方式)
     * 1. 先将根节点压入栈中。
     * 2. 出栈、先定位右子树、然后左子树，并将它们压入栈中。
     */
    public void preOrderTraversal(Node node){

        Stack<Node> stack = new Stack<>();
        // Step1: 先将根节点压入栈中。
        stack.push(node);
        System.out.println("先序遍历: ");

        while (stack.size() > 0){
            // Step2: 出栈、先定位右子树、然后左子树，并将它们压入栈中。
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
     * 1. 先将所有左子树压入栈中。
     * 2. 出栈、定位到右子树。
     */
    public void inOrderTraversal(Node node){
        if (node == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        System.out.println("中序遍历: ");

        while (node != null || deque.size() > 0){
            // Step1: 先将所有左子树压入栈中。
            while (node != null){
                deque.push(node);
                node = node.getLeftNode();
            }

            // Step2: 出栈、定位到右子树。
            // 执行下一个语句前，node为null，需要回溯到上一个叶子节点！
            node = deque.pop();
            System.out.print(node.getVal() + " ");
            node = node.getRightNode();
        }
    }

    /**
     * 后续遍历(循环法、双栈方式)
     * 1. 先将右子树压入节点栈中
     * 2. 出栈、定位到左子树。
     * 3. 打印后续遍历
     */
    public void postOrderTraversal(Node node){
        if (node == null) {
            return;
        }
        ArrayDeque<Node>    nodeDeque  = new ArrayDeque<>();
        ArrayDeque<Integer> valueDeque = new ArrayDeque<>();

        while (node != null || nodeDeque.size() > 0){
            // Step1: 先将右子树压入节点栈中
            while (node != null){
                nodeDeque.push(node);
                valueDeque.push(node.getVal());
                node = node.getRightNode();
            }

            // Step2: 出栈、定位到左子树。
            // 执行下一个语句前，node为null，需要回溯到上一个叶子节点！
            node = nodeDeque.pop();
            node = node.getLeftNode();
        }

        System.out.println("后续遍历: ");
        // Step3: 打印后续遍历
        while (!valueDeque.isEmpty()){
            System.out.print(valueDeque.pop() + " ");
        }
    }

    public int fibonacci(int n){
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n - 2);
    }

    /**
     * @param n: 代表第几位fibonacci。
     */
    public int fibonacciOptimization(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int nMinustwo = 0;
        int nMinusOne = 1;
        int result    = 0;

        for (int i = 2; i < n; i++){
            result    = nMinusOne + nMinustwo;
            nMinustwo = nMinusOne;
            nMinusOne = result;
        }
        return result;
    }

    /**
     * 先序遍历(递归法)
     */
    public void preOrderTraversalUsingRecursive(Node node){
        if (node == null) {
            return;
        }

        System.out.print(node.getVal() + " ");
        preOrderTraversalUsingRecursive(node.getLeftNode());
        preOrderTraversalUsingRecursive(node.getRightNode());
    }

    /**
     * 中序遍历(递归法)
     */
    public void inOrderTraversalUsingRecursive(Node node){
        if (node == null) {
            return;
        }

        inOrderTraversalUsingRecursive(node.getLeftNode());
        System.out.print(node.getVal() + " ");
        inOrderTraversalUsingRecursive(node.getRightNode());
    }

    /**
     * 后序遍历(递归法)
     */
    public void postOrderTraversalUsingRecursive(Node node){
        if (node == null) {
            return;
        }

        postOrderTraversalUsingRecursive(node.getLeftNode());
        postOrderTraversalUsingRecursive(node.getRightNode());
        System.out.print(node.getVal() + " ");
    }


    /**
     * 广度优先遍历(队列)
     */
    public void levelOrderTraserval2(Node node){
        if (node == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(node);
        System.out.println("广度优先遍历: ");

        while (!deque.isEmpty()){
            // 重点！不能创建一个新的变量喔，否则会造成node永远为根节点，进一步导致死循环！！！
            node = deque.removeFirst();
            System.out.print(node.getVal() + " ");

            if (node.getLeftNode()  != null){
                deque.addLast(node.getLeftNode());
            }

            if (node.getRightNode() != null){
                deque.addLast(node.getRightNode());
            }
        }
    }

    /**
     * 删除树中节点。
     * 1. 删除的为叶子节点   => null
     * 2. 删除的包含一个节点 => 直接拿其子节点顶替。
     * 3. 删除的包含两个节点 => 找右子树中最小的顶替。
     * @param val: 待删除节点的值。
     */
    public Node deleteNode(Node node, int val){
        // Step0: Base check.
        if (node == null) {
            return null;
        }

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
            if (node.getLeftNode() != null && node.getRightNode() != null){
                Node tmpNode = node;
                Node minNodeForRight = minElementInRight(tmpNode.getRightNode());
                node.setVal(minNodeForRight.getVal());
                node.setRightNode(deleteNode(node.getRightNode(), minNodeForRight.getVal()));
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

    /**
     * 判断树1是否包含树2。
     */
    public boolean hasSubtree(Node root1, Node root2){
        boolean result = false;
        if (root1 != null && root2 != null){
            // 从树1定位与树2根节点一致的子树。
            if (root1.getVal() == root2.getVal()) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.getLeftNode(), root2);
            }
            if (!result) {
                result = hasSubtree(root1.getRightNode(), root2);
            }
        }
        return result;
    }

    /**
     * 判断子树1是否包含子树2。
     * 1. 不包含的情况
     * <1> tree1 == null
     * <2> 树1、2当前节点的值不相等。
     */
    public boolean doesTree1HasTree2(Node n1, Node n2){
        // line1在line2之上的原因是，母树除了包含子树外，还可能会有些节点延伸。
        if (n2 == null) {
            return true;  // line1
        }

        // 子树怎么可能比母树大叻
        if (n1 == null) {
            return false; // line2
        }
        if (n1.getVal() != n2.getVal()) {
            return false;
        }

        return doesTree1HasTree2(n1.getLeftNode(), n2.getLeftNode()) &&
               doesTree1HasTree2(n1.getRightNode(), n2.getRightNode());
    }


    /**
     * 返回二叉树的下一个节点
     * 1. 若该节点包含右节点，取其右子树中最小值(most leftNode)
     * 2. 若该节点为父节点的左子树，返回父节点。
     * 3. 若该节点为父节点的右子树，一路向上遍历，直至找到一个其父节点为左子树的节点，返回其爷爷节点。
     */
    public Node returnNextNode(Node curNode){
        if (curNode == null) {
            return null;
        }

        // Step1: 该节点包含右节点，取其右子树中最小值(最左左叶子节点)
        if (curNode.getRightNode() != null){
            Node rightNode = curNode.getRightNode();
            while (rightNode.getLeftNode() != null){
                rightNode = rightNode.getLeftNode();
            }
            return rightNode;
        }

        /**
         * 结合了2、3两种情况
         * 2. 如果该节点为父节点的左节点，就直接返回其父节点。
         * 3. 如果该节点为父节点的右节点，一直往上遍历，直至发现它的父节点是爷爷节点的左节点，返回爷爷节点。
         */
        while (curNode.getParentNode() != null){
            if (curNode.getParentNode().getLeftNode() == curNode) {
                return curNode.getParentNode();
            }
            curNode = curNode.getParentNode();
        }

        return null;

    }


    /**
     * 重建二叉树
     */
    public Node rebuildBinaryTree(int[] pre, int[] in){

        return rebuildBTCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private Node rebuildBTCore(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        Node root = new Node(pre[preLeft]);
        for (int i = inLeft; i <= inRight; i++){
            // 定位中序遍历中的根节点
            if (in[i] == pre[preLeft]){
                root.setLeftNode(rebuildBTCore(pre, preLeft + 1, preLeft + i - inLeft, in, inLeft, i - 1));
                root.setRightNode(rebuildBTCore(pre, preLeft + i - inLeft + 1, preRight, in, i + 1, inRight));
            }
        }

        return root;
    }

    /**
     * 二叉树的镜像
     */
    public Node mirrorRecursively(Node node){
        if (node == null) {
            return null;
        }
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return null;
        }

        // 交换左右子树、节点
        Node tmpNode = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(tmpNode);

        if (node.getLeftNode()  != null) {
            mirrorRecursively(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            mirrorRecursively(node.getRightNode());
        }
        return node;
    }

    /**
     * 判断二叉树的对称性
     */
    public boolean isSymmetrical(Node node){
        return isSymmetrical(node, node);
    }

    private boolean isSymmetrical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.getVal() != node2.getVal()) {
            return false;
        }

        return isSymmetrical(node1.getLeftNode(),  node2.getRightNode()) &&
               isSymmetrical(node1.getRightNode(), node2.getLeftNode());

    }

    /**
     * 校验是否为后续遍历序列
     */
    public boolean verifySequenceOfBST(int[] sequence){
        int length = sequence.length;
        if (length <= 0){
            return false;
        }

        int root = sequence[length - 1];

        // 定位到第一个大于根节点的节点索引。
        int i = 0;
        for (; i < length - 1; i++){
            if (sequence[i] > root) {
                break;
            }
        }

        // 防止处于右子树中的节点比根节点小。
        int j = i;
        for (; j < length - 1; j++){
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0){
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        boolean right = true;
        if (i < length - 1){
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, i, length -1));
        }

        return left && right;
    }


    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private ArrayList<Integer>            path  = new ArrayList<>();
    /**
     * 返回树中和为某个值的所有路径。
     */
    public ArrayList<ArrayList<Integer>> returnPaths(Node node, int target){
        if (node == null) {
            return paths;
        }
        path.add(node.getVal());
        target -= node.getVal();

        if (target == 0 && node.getLeftNode() == null && node.getRightNode() == null){
            paths.add(new ArrayList<>(path));
        }

        if (node.getLeftNode() != null){
            returnPaths(node.getLeftNode(),target);
        }

        if (node.getRightNode() != null){
            returnPaths(node.getRightNode(), target);
        }
        // 回溯，删除最后一个元素。
        path.remove(path.size() - 1);
        return paths;
    }


    private int index = 0;
    /**
     * 返回二叉搜索树中第k个节点
     */
    public Node returnFirstKNode(Node node, int k){
        if (node != null){
            Node curNode = returnFirstKNode(node.getLeftNode(), k);
            if (curNode != null){
                return curNode;
            }
            index++;
            if (index == k){
                return node;
            }
            curNode = returnFirstKNode(node.getRightNode(), k);
            if (curNode != null){
                return curNode;
            }
        }
        return null;
    }


    /**
     * 计算二叉树深度
     */
    public int treeDepth(Node node){
        if (node == null) {
            return 0;
        }

        int left  = treeDepth(node.getLeftNode());
        int right = treeDepth(node.getRightNode());

        return (left > right) ? (left + 1) : (right + 1);
    }

    /**
     * 判断是否为平衡二叉树
     */
    public boolean isBalancedTree(Node node){
        if (node == null) {
            return true;
        }
        int left  = treeDepth(node.getLeftNode());
        int right = treeDepth(node.getRightNode());
        int diff = left - right;
        if (diff > 1 || diff < -1){
            return false;
        }

        // 这一步非常重复，重蹈fibonacci的覆辙！！！
        return isBalancedTree(node.getLeftNode()) && isBalancedTree(node.getRightNode());
    }

    /**
     * 判断是否为平衡二叉树(优化版)
     */
    public boolean isBalancedTreeOptimization(Node node){
        // -1代表非平衡二叉树，即左右子树之间的深度大于1。
        return getDepth(node) != -1;
    }

    private int getDepth(Node node){
        if (node == null) {
            return 0;
        }
        int left  = getDepth(node.getLeftNode());
        if (left  == -1) {
            return -1;
        }
        int right = getDepth(node.getRightNode());
        if (right == -1) {
            return -1;
        }
        /**
         * 若任何父节点下的左右子树的深度差大于1，则返回-1(非平衡二叉树)，否则返回左右子树中更大的深度。
         */
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    // region Private methods

    /**
     * 定位到当前结点右子树中最小的元素。
     */
    private Node minElementInRight(Node node){
        if (node.getLeftNode() == null) {
            return node;
        } else {
            return minElementInRight(node.getLeftNode());
        }

    }

    // endregion
}




















