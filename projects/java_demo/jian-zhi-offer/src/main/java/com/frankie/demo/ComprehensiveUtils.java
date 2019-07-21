package com.frankie.demo;

import com.sun.org.apache.bcel.internal.generic.FASTORE;
import com.sun.org.apache.bcel.internal.generic.FREM;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import netscape.security.ForbiddenTargetException;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;

import java.security.interfaces.RSAKey;
import java.util.*;
import java.util.concurrent.ExecutionException;
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
        if (queuePrimary.isEmpty()) {
            queueAuxiliary.addLast(x);
        }
        // 否则，往主栈里面压入元素。
        else {
            queuePrimary.addLast(x);
        }
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
            while (queueAuxiliary.size() != 1) {
                queuePrimary.addLast(queueAuxiliary.removeFirst());
            }
            return queueAuxiliary.removeFirst();
        } else {
            while (queuePrimary.size()   != 1) {
                queueAuxiliary.addLast(queuePrimary.removeFirst());
            }
            return queuePrimary.removeFirst();
        }
    }

    /**
     * 从旋转数组中查找最小值, eg: {3, 4, 5, 1, 2}
     */
    public int minNumberInRotatedArray(int[] a){

        // Step1: Base check.
        if (a.length <= 0) {
            return -1;
        }

        int low  = 0;
        int high = a.length - 1;
        // 跳出循环的标志就是low == high。
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
        if (length <  2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;
        /**
         *  重点: 2 * 2 > 3 * 1
         *  eg: length = 16, 3^5*1 = 243, 3^4*2^2 = 324
         */

        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
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
        int count = 0;
        while (x != 0){
            x = x & (x - 1);
            count++;
        }
        return count;
    }


    /**
     * 不用四则运算做加法(按位亦或、按位与)
     */
    public int AddUsingBitOperation(int x, int y){

        int sum;
        int carry;
        do {
            sum   = x ^ y;
            // 进位是关键。
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
        if (nums.length < 1) {
            return null;
        }

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

        // Step3: 根据异或结果的第一位1的位置，虚拟地分为两个集合(因为遍历次数仍为1)，然后依次做异或。
        int x = 0, y = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i: nums){
            if (((i >> position) & 1) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        result.add(x);
        result.add(y);

        return result;
    }

    /**
     * 计算二进制表示中第一个1的位置(从低位到高位遍历)，仅考虑正数。
     */
    public int calculateFirstOnePosition(int x){
        if (x <= 0) {
            return -1;
        }
        int pos = 0;
        // 当最后一位不是1时
        while ((x & 0x1) == 0){
            x >>= 1;
            pos++;
        }
        return pos;
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
        if (expo == 0) {
            return 1;
        }
        if (expo == 1) {
            return base;
        }
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
        if (str.length() == 0 || pattern.length() == 0) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    /**
     * 总结步骤:
     * 1. 递归结束条件: 字符串与模式同时走到头，返回true，任意一个先走到头，返回false.
     * 2. 任意时刻模式的第二个元素是否为*，需要注意是否在模式长度范围内，若首元素匹配，则递归三种情况，否则模式往后走2步。
     * 3. 当模式的第二个元素不是*，且字符串与模式首元素匹配时，各往后走1步。
     */
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

        if (s.length() == 0) {
            return false;
        }
        boolean hasDecimal  = false;
        boolean hasExponent = false;

        for (int i = 0; i < s.length(); i++){

            /**
             * 1. 正负值符号(以下为不合理的情况)
             * 不在首元素出现，同时前一个元素不是e。
             */
            if (s.charAt(i) == '+' ||s.charAt(i) == '-'){
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            /**
             * 2. 小数点
             * <1> 正常情况下第一次出现小数，指数一定没有出现，eg: -0.5e2
             * <2> 小数不能出现两次。
             */
            else if (s.charAt(i) == '.'){
                if (hasDecimal || hasExponent) {
                    return false;
                }
                hasDecimal = true;
            }

            /**
             * 3. 指数
             * <1> 指数后面不可能是最后一个元素，后面一个跟整数。
             * <2> 不能出现两个指数。
             */
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if (i == s.length() - 1 || hasExponent) {
                    return false;
                }
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
        if (nums.length <= 1) {
            return nums;
        }

        // 第一个偶数的索引。
        int firstEvenIndex  = 0;

        for (int i = 0; i < nums.length; i++){
            if (hitCondition(nums, i)){
                ArrayUtils.swap(nums, i, firstEvenIndex);
                firstEvenIndex++;
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
        // 1 << buf.length，即2的buf.length次方。
        for(int i = 1 ; i < (1 << buf.length); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < buf.length; j++){
                //判断哪一位为1
                if((i & (1 << j)) != 0){
                    sb.append(buf[j]);
                }
            }
            list.add(new String(sb));
        }
        return list;
    }

    private ArrayList<String> permutationList = new ArrayList<>();
    /**
     * 字符串的排列。
     * 1. 递归结束条件: start等于end，拼buf，加入list即可。
     * 2. 否则调整数组、递归(start+1)、还原数组。
     */
    public List<String> permutation(char[] buf, int start, int end){

        if (start == end){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < end; i++){
               sb.append(buf[i]);
            }
            permutationList.add(new String(sb));
            sb = new StringBuilder();
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

    /**
     * 找出数组中出现次数超过一半的数字。
     * 1. 判断数组是否有效。
     * 2. 次数法，次数数量需要大于0，返回结果。
     * 3. 验证该结果在数组中出现的次数是否大于一半。
     */
    public int moreThanHalfNumber(int[] a) throws Exception {
        // Step1: 判断数组是否有效。
        if (a.length <= 0){
            throw new Exception("The array is invalid!");
        }

        // Step2: 次数法，次数数量需要大于0，返回结果。
        int result = a[0];
        int times  = 1;
        for (int i = 1; i < a.length; i++){
            if (times == 0){
                result = a[i];
                times  = 1;
            }
            else if (a[i] == result){
                times++;
            }
            else {
                times--;
            }
        }

        // Step3: 验证该结果在数组中出现的次数是否大于一半。
        int resultCount = 0;
        for (int i: a){
            if (i == result) {
                resultCount++;
            }
        }
        if (resultCount * 2 > a.length) {
            return result;
        } else {
            throw new Exception("The array is invalid!");
        }
    }

    /**
     * 连续子数组的最大和。
     * 1. 需要两个临时变量，当前累计和(curSum)、当前最大累计和(greatestSum)。
     * 2. 当前累计和一旦小于0，则令其等于当前元素，一旦curSum > greatestSum, greatestSum = curSum.
     */
    public int findGreatestSumOfSubArray(int[] a){
        if (a.length <= 0) {
            return -1;
        }

        int curSum      = a[0];
        int greatestSum = a[0];

        for (int i = 1; i < a.length; i++){
            if (curSum < 0){
                curSum = a[i];
            } else{
                curSum += a[i];
            }

            if (curSum > greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    /**
     * 连续子数组的最大和(动态规划)。
     */
    public int findGreatestSumOfSubArrayUsingDP(int[] a){

        if (a.length <= 0) {
            return -1;
        }
        int curSum      = a[0];
        int greatestSum = a[0];

        for (int i = 1; i < a.length; i++){
            curSum      = Math.max(curSum + a[i], a[i]);
            greatestSum = Math.max(curSum, greatestSum);
        }

        return greatestSum;
    }

    /**
     * 礼物的最大价值
     */
    public int maxGift(int[][] matrix){
       if (matrix.length <= 0 || matrix[0].length <= 0) {
           return -1;
       }

       for (int i = 0; i < matrix.length; i++){
           for (int j = 0; j < matrix[i].length; j++){
               int top  = i > 0 ? matrix[i - 1][j] : 0;
               int left = j > 0 ? matrix[i][j - 1] : 0;

               matrix[i][j] += Math.max(top, left);
           }
       }

       // 返回二维数组的最后一个元素。
       return matrix[matrix.length - 1][matrix[0].length - 1];
    }


    /**
     * 计算1~n整数中1出现的次数。
     */
    public int numberOf1Between1AndN(int n){
        if (n <= 0){
            return -1;
        }

        int start = 1;
        int count = 0;
        // 1 ~ n => [1, n]
        while (start <= n){
            count += numberOf1(start);
            start++;
        }
        return count;
    }

    /**
     * 计算某个正整数中1的个数。
     */
    public int numberOf1(int x){
        if (x <= 0) {
            return -1;
        }

        int count = 0;

        while (x != 0){
            if (x % 10 == 1){
                count++;
            }
            x /= 10;
        }
        return count;
    }

    /**
     * 从0打印到n
     */
    public void print1ToN(int n){
        int flag = 0;
        int i    = 1;
        while (i <= n){
            if (flag == 10){
                flag = 0;
                System.out.println();
            }
            System.out.print(i + " ");
            flag++;
            i++;
        }
    }

    /**
     * 计算1~n整数中1出现的次数(优化版)。
     * 1. i初始值为1，循环跳出条件为high = 0;
     * 2. 高位  (high): x / 10 ^ i;
     * 3. 当前位(cur) : (x / 10 ^ (i - 1)) % 10;
     * 4. 低位  (low): x - (x / 10 ^ (i - 1) * (10 ^ (i - 1)))
     */
    public int numberOf1Between1AndNOptimization(int x){

        if (x <= 0) {
            return -1;
        }

        /**
         * 为什么需要i，事关定位高位、当前位、低位。
         * 为什么需要high，事关循环。
         * 为什么需要sum，事关1的总数。
         */
        int i = 1, high = x, sum = 0;

        while (high != 0){
            high = x / (int) Math.pow(10, i);
            // temp存在的意义在于，方便求出当前位、低位。
            int temp = x / (int) Math.pow(10, i - 1);
            int cur  = temp % 10;
            int low  = x - temp * (int) Math.pow(10, i - 1);

            if (cur >  1){
                sum += (high + 1) * (int) Math.pow(10, i - 1);
            }
            else if (cur < 1){
                sum += high * (int) Math.pow(10, i - 1);
            }
            else{
                sum += high * (int) Math.pow(10, i - 1) + low + 1;
            }
            i++;
        }

        return sum;
    }
}























