package com.frankie.demo;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

public class ArrayUtils {

    public static void printMatrix() {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean findElementFromMatrix(int[][] matrix, int val) {
        if (matrix == null || matrix.length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == val) return true;
            }
        }
        return false;
    }

    public static boolean topRightCornerWay(int[][] matrix, int v) {

        boolean found = false;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {

            int rows = matrix.length;
            int columns = matrix[0].length;
            int row = 0, column = columns - 1;

            while (row < rows && column >= 0) {
                if (matrix[row][column] == v) {
                    found = true;
                    break;
                } else if (matrix[row][column] > v) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }

    /**
     * 根据索引，交换数组中两个元素的值。
     */
    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i]    = a[j];
        a[j]    = tmp;
    }

    public static void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i]     = a[j];
        a[j]     = tmp;
    }

}
