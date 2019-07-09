package com.frankie.demo;

import java.util.ArrayDeque;
import java.util.Stack;

public class ComprehensiveUtils {

    // 主要栈
    private Stack<Integer> stackPrimary = new Stack<>();
    // 辅助栈
    private Stack<Integer> stackAuxiliary = new Stack<>();
    // 主队列
    private ArrayDeque<Integer> queuePrimary = new ArrayDeque<>();
    // 辅助队列
    private ArrayDeque<Integer> queueAuxiliary = new ArrayDeque<>();

    /**
     * 通过两个栈的方式实现队列的元素插入。
     */
    public void queueAddElementUsingDoubleStacks(int x){
        stackPrimary.push(x);
    }

    /**
     * 一. 通过两个栈的方式实现队列的元素删除。
     * 1. 若辅栈不为空，直接弹出栈顶元素。
     * 2. 若辅栈为空，将主栈中的元素依次弹出，并插入辅栈中。
     *
     * 二. 边界条件:
     * 1. 主、辅栈均为空。
     */
    public int queueRemoveElementUsingDoubleStacks(){

        // Step1: 若辅栈不为空，直接弹出栈顶元素。
        while (!stackAuxiliary.isEmpty()){
            return stackAuxiliary.pop();
        }

        // Step2: 若辅栈为空，将主栈中的元素依次弹出，并插入辅栈中。
        while (!stackPrimary.isEmpty()){
            stackAuxiliary.push(stackPrimary.pop());
        }

        // 边界条件: 主、辅栈均为空。
        if (stackAuxiliary.isEmpty())
            return -1;
        else
            return stackAuxiliary.pop();
    }

    /**
     * 通过两个队列模拟压栈。
     */
    public void stackAddElementUsingDoubleQueue(int x){
        if (queuePrimary.size() == 0)
            queueAuxiliary.addLast(x);
        else
            queuePrimary.addLast(x);
    }

    /**
     * 通过两个队列模拟出栈。
     */
    public int stackRemoveElementUsingDoubleQueue(){

        // Step1: Base check.
        if (queuePrimary.isEmpty() && queueAuxiliary.isEmpty()) return -1;

        if (queuePrimary.isEmpty()){
            // 将辅助队列中的元素依次插入主队列中，仅保留最后弹出的一个。
            while (queueAuxiliary.size() != 1)
                queuePrimary.addLast(queueAuxiliary.removeFirst());
            return queueAuxiliary.removeFirst();
        } else {
            while (queuePrimary.size()   != 1)
                queueAuxiliary.addLast(queuePrimary.removeFirst());
            return queuePrimary.removeFirst();
        }
    }

    /**
     * 从旋转数组中查找最小值, eg: {3, 4, 5, 1, 2}
     */
    public int minNumberInRotatedArray(int[] a){

        // Step1: Base check.
        if (a.length <= 0) return -1;

        int low  = 0;
        int high = a.length - 1;
        while (low < high){
            int mid = low + ((high - low) >> 1);
            // Step2: 若数组中间值比尾元素大，说明最小值在右边。
            if      (a[mid] > a[high]){
                low = mid + 1;
            }
            // Step3: 若数组中间值比尾元素小，说明最小值在左边。
            else if (a[mid] < a[high]){
                high = mid;
            }
            // Step4: eg. {1, 0, 1, 1, 1}
            else {
                high--;
            }
        }
        return a[low];
    }

}
