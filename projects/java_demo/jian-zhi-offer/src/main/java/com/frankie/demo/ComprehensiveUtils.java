package com.frankie.demo;

import com.sun.org.apache.bcel.internal.generic.FASTORE;
import com.sun.org.apache.bcel.internal.generic.FREM;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import netscape.security.ForbiddenTargetException;

import java.security.interfaces.RSAKey;
import java.util.*;
import java.util.regex.Pattern;

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

        if (stackPrimary.isEmpty() && stackAuxiliary.isEmpty()){
            throw new RuntimeException("Both stacks is empty!");
        }

        // Step1: 若辅栈不为空，直接弹出栈顶元素。
        while (!stackAuxiliary.isEmpty()){
            return stackAuxiliary.pop();
        }

        // Step2: 若辅栈为空，将主栈中的元素依次弹出，并插入辅栈中。
        while (!stackPrimary.isEmpty()){
            stackAuxiliary.push(stackPrimary.pop());
        }

        return stackAuxiliary.pop();
    }

    /**
     * 通过两个队列模拟压栈，需要保留一个空队列用于数据转移。
     */
    public void stackAddElementUsingDoubleQueue(int x){
        // 若主栈，则往辅栈压入元素。
        if (queuePrimary.isEmpty())
            queueAuxiliary.addLast(x);
        // 否则，往主栈里面压入元素。
        else
            queuePrimary.addLast(x);
    }

    /**
     * 通过两个队列模拟出栈。
     */
    public int stackRemoveElementUsingDoubleQueue(){

        // Step1: 当两个队列均为空、或均有值，则不符合逻辑，抛异常。
        if (queuePrimary.isEmpty() == queueAuxiliary.isEmpty()){
            throw new RuntimeException("Both queue is empty or has elements!");
        }

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

    /**
     * 正则表达式匹配(.*)
     */
    public boolean match(String str, String pattern){
        if (str.length() == 0 || pattern.length() == 0)
            return false;

//        int strIndex     = 0;
//        int patternIndex = 0;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(String str, int strIndex, String pattern, int patternIndex) {
        // 依次遍历，均匹配，字符串与模式同时到尾，表示匹配成功。
        if (strIndex == str.length() && patternIndex == pattern.length()){
            return true;
        }

        // 字符串、模式任意一个先到头，匹配失败。
        if (strIndex == str.length() || patternIndex == pattern.length()){
            return false;
        }

        boolean firstElementMatch = pattern.charAt(patternIndex) == str.charAt(strIndex) ||
                                    pattern.charAt(patternIndex) == '.';

        // 模式第二个字符为*，且字符串与模式的第一个字符匹配，分为三种匹配模式，否则模式向后移2位。
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*'){
            if (firstElementMatch){
                return matchCore(str, strIndex, pattern, patternIndex + 2) ||
                       matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                       matchCore(str, strIndex + 1, pattern, patternIndex);
            } else{
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        // 模式第二个字符不是*，且字符串与模式的第一个字符匹配，则各进一步，否则false。
        if (firstElementMatch){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }

    /**
     * 表示数值的字符串。
     */
    public boolean isNumeric(String s){

        if (s.length() == 0) return false;
        boolean hasSign     = false;
        boolean hasDecimal  = false;
        boolean hasExponent = false;

        for (int i = 0; i < s.length(); i++){

            /**
             * 1. 正负值符号
             * <1> 第一次, (开头) hasSign = false, i = 0; || (e/E后面) hasSign = false, i > 0, 符号前面一位必须是e/E
             * <2> 第二次, hasSign = true, 符号前面一位必须是e/E
             */
            if (s.charAt(i) == '+' ||s.charAt(i) == '-'){
                if (!hasSign && i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                if (hasSign && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
                hasSign = true;
            }

            /**
             * 2. 小数点
             * <1> 指数后面不能出现，小数点不能出现两次: if(hasDecimal || hasExpo) return false;
             */
            else if (s.charAt(i) == '.'){
                if (hasDecimal || hasExponent) return false;
                hasDecimal = true;
            }

            /**
             * 3. 指数
             * <1> 指数后面必须接数字: if(i == s.length - 1) return false;
             * <2> 不能出现两个指数:   if(hasExpo) return false;
             */
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if (i == s.length() - 1) return false;
                if (hasExponent)         return false;
                hasExponent = true;
            }

            else if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }

    /**
     * 表示数值的字符串(正则表达式方式)
     */
    public boolean isNumerciRegExp(String s){
        /**
         * [\\+\\-]?            : 代表正负符号出现与否。
         * \\d*                 : 代表整数部分是否出现，如: -.314
         * (\\.\\d+)?           : 代表如果出现过小数点，就一定会伴随着数字，否则都不出现。
         * ([eE][\\+\\-]?\\d+)? : 代表如果存在指数，e/E一定会出现，正负号可以不出现，但必须紧跟数字，要么全部不出现。
         */
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    /**
     * 调整数组顺序，使奇数位于偶数前面。
     */
    public int[] reorderOddEven(int[] nums){
        if (nums.length <= 1) return nums;

        // 符合要求元素的数量，如移到数组头部的奇数个数。
        int hit  = 0;

        for (int i = 0; i < nums.length; i++){
            if (hitCondition(nums, i)){
                ArrayUtils.swap(nums, i, hit);
                hit++;
            }
        }
        return nums;
    }

    /**
     * 命中条件 - 解耦！
     * <1> 判断是否为奇数。
     * <2> 判断是否为负数。
     * <3> 判断是否能被3整除。
     */
    private boolean hitCondition(int[] nums, int i){
        return (nums[i] & 0x1) == 1;
    }

    /**
     * 组合算法：[abc]的组合方式有[a,b,c,ab,bc,ac,abc]六种组合方式
     */
    public List<String> combination(char[] buf){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1 ; i < (1 << buf.length); i++){
            String result = "";
            for(int j = 0 ; j < buf.length; j++){
                //判断哪一位为1
                if((i & (1 << j)) != 0){
                    result += buf[j];
                }
            }
            list.add(result);
        }
        return list;
    }

    private ArrayList<String> permutationList = new ArrayList<>();
    /**
     * 字符串的排列。
     */
    public List<String> permutation(char[] buf, int start, int end){

        if (start == end){
            String result = "";
            for (int i = 0; i < end; i++){
                result += buf[i];
            }
            permutationList.add(result);
            result = "";
        } else {
            for (int i = start; i < buf.length; i++){
                // 排列
                ArrayUtils.swap(buf, i, start);
                permutation(buf, start + 1, end);
                // 还原
                ArrayUtils.swap(buf, i, start);
            }
        }
        return permutationList;
    }
}























