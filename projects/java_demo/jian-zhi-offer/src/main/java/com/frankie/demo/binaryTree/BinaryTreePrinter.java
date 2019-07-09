package com.frankie.demo.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

    public static void printNode(Node root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);
        /**
         * singletonList(T o): return ann immutable list containing only the specified object.
         */
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.getVal());
                newNodes.add(node.getLeftNode());
                newNodes.add(node.getRightNode());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeftNode() != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightNode() != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(node.getLeftNode()),
                        BinaryTreePrinter.maxLevel(node.getRightNode())) + 1;
    }

    private static  boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
