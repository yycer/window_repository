package com.frankie.demo;

import com.sun.org.apache.bcel.internal.generic.FREM;
import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.security.interfaces.RSAKey;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumSet;
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

    /**
     * 剪绳子，获取最大乘积(贪婪算法)。
     */
    public int maxProductAfterCutting(int length){
        if (length <  2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1)
            timesOf3--;
        int timeOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timeOf2));
    }


    /**
     * 计算二进制中1的个数。
     * @x: 代表整数, eg: x = 15(1111)
     *       count    x-1          x
     * init    0                 15(1111)
     * 1       1     14(1110)    14(1110) = 15 & 14;
     * 2       2     13(1101)    12(1100) = 14 & 13;
     * 3       3     11(1011)     8(1000) = 12 & 11;
     * 4       4      7(0111)     0(0000) =  8 &  7; -> out
     */
    public int numberOfOne(int x){

        String s = Integer.toBinaryString(x);

        int count = 0;
        while (x != 0){
            count++;
            x = x & (x - 1);
        }
        return count;
    }


    /**
     * 不用四则运算做加法
     */
    public int AddUsingBitOperation(int x, int y){

        int sum;
        int carry;
        do {
            sum   = x ^ y;
            carry = (x & y) << 1;
            x     = sum;
            y     = carry;
        } while (y != 0);

        return x;
    }

    /**
     * 查询数组中仅出现一次的数字。
     */
    public int findNumberAppearingOnce(int[] nums){
        int result = 0;
        for (int i: nums){
            result = result ^ i;
        }

        return result;
    }

    /**
     * 查询数组中出现二次的数字。
     */
    public ArrayList<Integer> findTwoNumberAppearingOnce(int[] nums){

        // Base check.
        if (nums.length < 1) return null;

        // Step1: 依次遍历数组，进行异或操作。
        int xor = 0;
        for (int i: nums){
            xor = xor ^ i;
        }

        // Step2: 定位异或结果中最低位为1的位置。
        int position =  0;
        while ((xor & 1) == 0){
            xor >>= 1;
            position++;
        }

        // Step3: 根据定位位置，将元素数组一分为二，然后分别执行一遍异或操作即可。
        int x = 0, y = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i: nums){
            if (((i >> position) & 1) == 0)
                x ^= i;
            else
                y ^= i;
        }
        result.add(x);
        result.add(y);

        return result;
    }

    /**
     * 一. 数值的整数次方
     * 二. Corner case
     * <1> 底数为0.0，同时指数小于0。
     *
     */
    public double power(double base, int exponent){

        // Step1: 考虑特殊情况，底数为0.0，同时指数小于0。
        if (DoubleUtils.equals(base, 0.0) && exponent < 0){
            return 0.0;
        }

        int absExponent = Math.abs(exponent);
        double result = powerRecursively(base, absExponent);

        // Step2: 如果指数小于0，取其倒数。
        if (exponent < 0){
            return 1.0 / result;
        } else {
            return result;
        }
    }

    /**
     * Origin way:       3^8 = 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3
     * Optimization way: 3^8 = ((3 * 3) * (3 * 3)) * ((3 * 3) * (3 * 3))
     */
    public double powerRecursively(double base, int expo){
        if (expo == 0) return 1;
        if (expo == 1) return base;
        // 细节1: expo >> 1与expo /= 2运算结果上一致，但性能上更优。
        double result = powerRecursively(base, expo >> 1);
        result *= result;

        // 如果expo为奇数，再乘以底数。
        // 细节2: 与运算判断指数是否为奇数。
        if ((expo & 0x1) == 1){
            result *= base;
        }

        return result;
    }
}























