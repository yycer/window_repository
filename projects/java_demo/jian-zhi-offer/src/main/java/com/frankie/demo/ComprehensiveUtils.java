package com.frankie.demo;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.frankie.demo.model.ThreePart;
import javafx.scene.control.TableView;

import java.util.*;

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
     * 命中条件 - 解耦！
     * <1> 判断是否为奇数。
     * <2> 判断是否为负数。
     * <3> 判断是否能被3整除。
     */
    private boolean hitCondition(int[] nums, int i){
        return (nums[i] & 0x1) == 1;
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
     * 数字序列中某一位的数字
     */
    public int digitAtIndex(int index){

        if (index >= 0 && index < 10){
            return index;
        }

        int bit = 0;
        while (countOfIndexes(bit) < index){
            bit++;
        }

        /**
         * eg: index = 2803
         * bit       = 3;
         * restDigit = index - countOfIndexes(bit - 1) = 2803 - 190 = 2613;
         * realDigit = (restDigit / bit) + 10 ^ (bit - 1) = (2613 / 3) + 10 ^ 2 = 871 + 100 = 971;
         * digitBit  = restDigit % bit = 2613 % 3 = 0;
         * digitAtIndex = 1;
         */
        // 2613
        int restDigit = index - countOfIndexes(bit - 1);
        // 971
        int realDigit = (int) Math.pow(10, bit - 1) +  restDigit / bit;
        // 0
        // 从左到右，从1开始。
        int digitBit  = restDigit % bit;
        // 9
        int digit = getDigitByIndex(realDigit, digitBit);

        return digit;
    }

    public int countOfIndexes(int bit){
        if (bit == 0) {
            return 0;
        }
        else if (bit == 1){
            return 10;
        }
        else{
            return 9 * (int) Math.pow(10, bit - 1) * bit + countOfIndexes(bit - 1);
        }
    }

    /**
     * 根据位数推出该位上的数字。
     */
    public int getDigitByIndex(int num, int index){

//        int restNum = num / (int) Math.pow(10, index);
//        int digit = restNum % 10;

        int digit = String.valueOf(num).charAt(index) - '0';
        return digit;
    }

    /**
     * 判断是否为丑数(只能整除2、3、5的数，习惯上我们把1当做第一个丑数)。
     */
    public boolean isUgly(int x){

        while (x % 2 == 0){
            x /= 2;
        }
        while (x % 3 == 0){
            x /= 3;
        }
        while (x % 5 == 0){
            x /= 5;
        }

        return x == 1;
    }

    /**
     * 求第n个丑数(原始方法)
     */
    public int getUglyNumberByIndex1(int index){

        int count  = 0;
        int curNum = 0;

        while (count < index){
            curNum++;
            if (isUgly(curNum)){
                count++;
            }
        }
        return curNum;
    }

    /**
     * 查找三个元素中的最小值。
     */
    public int minAmongThreeElements(int a, int b, int c){
        int tmpMin = a > b ? b : a;
        return tmpMin > c ? c : tmpMin;
    }

    /**
     * 求第n个丑数(优化版)。
     */
    public int getUglyNumberOptimization(int index){
        if (index <= 0){
            return -1;
        }

        int[] uglyArray = new int[index];
        uglyArray[0] = 1;

        int multi2 = 0;
        int multi3 = 0;
        int multi5 = 0;
        int i      = 1;

        while (i < index){
            int min = minAmongThreeElements(uglyArray[multi2] * 2, uglyArray[multi3] * 3, uglyArray[multi5] * 5);
            uglyArray[i] = min;

            if (uglyArray[multi2] * 2 <= min){
                multi2++;
            }
            if (uglyArray[multi3] * 3 <= min){
                multi3++;
            }
            if (uglyArray[multi5] * 5 <= min){
                multi5++;
            }
            i++;
        }

        return uglyArray[index - 1];
    }

    /**
     * 第一次只出现一次的字符(维护一个hashMap，以空间换时间，O(n^2) -> O(n))
     */
    public char firstNotRepeatingChar(String s) throws Exception {
        if (s.length() <= 0){
            throw new Exception("The input is invalid");
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars){
            if (!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c: chars){
            if (map.get(c) == 1){
                return c;
            }
        }
        throw new Exception("Failed to find not repeating char from s");
    }

    // region Array

    /**
     * 股票的最大利润
     * <1> 依次遍历至某个元素a[i]，先找出之前所有元素中最小的那个，默认为第一个元素。
     * 然后求当前元素与最小值的差，若差大于maxProfit，则替换它。
     */
    public int maxProfit(int[] a){
        if (a.length < 2) {
            return -1;
        }

        int min       = a[0];
        int maxProfit = a[1] - min;

        for (int i = 2; i < a.length; i++){

            // 定位当前元素及之前的最小值。
            if (a[i] < min){
                min = a[i];
            }

            // 当前元素与最小值的差，若大于maxProfit，其替换之。
            int curDiff = a[i] - min;
            if ((curDiff) > maxProfit){
                maxProfit = curDiff;
            }
        }
        return maxProfit;
    }

    /**
     * 从一个递增数组中，找个和为sum的两个数字。
     */
    public int[] findNumbersWithSum(int[] a, int sum) throws Exception {
        int length = a.length;
        if (length <= 1 || sum <= 0){
            throw new Exception("Please check input!");
        }

        int[] result = new int[2];
        int start = 0;
        int end   = length - 1;

        while (start < end){
            if (a[start] + a[end] > sum){
                end--;
            }
            else if (a[start] + a[end] < sum) {
                start++;
            }
            else{
                result[0] = a[start];
                result[1] = a[end];
                break;
            }
        }
        return result;
    }

    /**
     * 在排序数组中查找数字。
     * 1. 二分法计算有序数组中k出现的次数。
     */
    public int countK(int[] a, int k){
        int start = 0;
        int end   = a.length - 1;
        int firstKIndex = getFirstK(a, start, end, k);
        int lastKIndex  = getLastK(a, start, end, k);
        if (firstKIndex == -1 && lastKIndex == -1){
            return 0;
        }
        return lastKIndex - firstKIndex + 1;
    }

    /**
     * 从有序数组中获得第一个k的索引。
     */
    public int getFirstK(int[] a, int start, int end, int k){
        if (a.length < 1 || start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        // 若当前元素为k，首先判断是否为首元素，若不是，接着判断当前元素的前一个元素是否为k，若也不是，往前找。
        if (a[mid] == k){
            if ((mid > 0 && a[mid - 1] != k) || mid == 0){
                return mid;
            } else {
                end = mid - 1;
            }
        }
        // 若当前元素小于k，说明k出现在后面。
        else if (a[mid] < k){
            start = mid + 1;
        }
        // 若当前元素大于k，说明k出现在前面。
        else {
            end   = mid - 1;
        }
        return getFirstK(a, start, end, k);
    }

    /**
     * 从有序数组中获得最后一个k的索引。
     */
    public int getLastK(int[] a, int start, int end, int k){
        if (a.length < 1 || start > end){
            return -1;
        }

        int mid = (start + end) >> 1;
        if (a[mid] == k){
            if ((mid > 0 && a[mid + 1] != k) || mid == a.length - 1) {
                return mid;
            } else{
                start = mid + 1;
            }
        }
        else if (a[mid] < k){
            start = mid + 1;
        }
        else{
            end   = mid - 1;
        }
        return getLastK(a, start, end, k);
    }

    /**
     * 查找o~n-1缺失数字（循环法）。
     */
    public int getMissingNumberUsingLoop(int[] a, int s, int e){
        if (a.length < 1){
            return -1;
        }

        while (s <= e){
            int mid = (s + e) >> 1;
            // 因为是递增数组，若中间元素值与索引相等，向后考虑。
            if (a[mid] == mid){
                s = mid + 1;
            }
            // 若当前元素为首元素、且与索引不等，或者当前元素值与索引值不等、且前一个值相等。
            else if (mid == 0 || a[mid - 1] == mid - 1){
                return mid;
            }
            // 前一个元素也不等，那就要往前考虑。
            else {
                e = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 在排序数组中查找数字。
     * 2. 获得长度为n-1的递增排序数组中的缺失数字(递归法、二分)。
     * <1> 缺失的数字位于数组的开始、中间。
     */
    public int getMissingNumberIndexWay(int[] a, int start, int end){
        if (a.length <= 0 || start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;

        if (a[mid] == mid){
            return getMissingNumberIndexWay(a, mid + 1, end);
        }
        // 终结条件: mid元素与索引mid不定，但是前一个元素相等。
        else if (mid == 0 || (a[mid - 1] == mid - 1)){
            return mid;
        }
        else {
            return getMissingNumberIndexWay(a, start, mid - 1);
        }
    }

    /**
     * 在排序数组中查找数字。
     * 3. 在递增数组中，获得首个索引与元素相等的元素（循环法）。
     * 边界条件
     * <1> 数组中没有这样的元素，返回-1。
     * <2> 符合要求的元素出现在数组开头或结尾。
     */
    public int getNumberSameAsIndexUsingLoop(int[] a){
        if (a.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;

        while (left <= right){
            int mid = (left + right) >> 1;
            if (a[mid] == mid){
                return mid;
            }
            // 若当前值大于索引，说明要往前找。
            else if (a[mid] > mid){
                right = mid - 1;
            }
            // 若当前值小于索引，说明要往后找。
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在递增数组中，查找首个与其索引相等的元素（递归法）。
     */
    public int getNumberSameAsIndexUsingRecursively(int[] a, int l, int r){
        if (a.length < 1 || l > r){
            return -1;
        }

        int m = (l + r) >> 1;
        if (a[m] == m){
            return m;
        }
        else if (a[m] < m){
            return getNumberSameAsIndexUsingRecursively(a, m + 1, r);
        }
        else {
            return getNumberSameAsIndexUsingRecursively(a, l, m - 1);
        }
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
     * 从旋转数组中查找最小值, eg: {3, 4, 5, 1, 2}
     */
    public int minNumberInRotatedArray(int[] a){

        // Step1: Base check.
        if (a.length <= 0) {
            return -1;
        }

        int l  = 0;
        int r = a.length - 1;
        // 跳出循环的标志就是low == high。
        while (l < r){
            int mid = (l + r) >> 1;
            // Step2: 若数组中间值比尾元素大，说明最小值在右边。
            if (a[mid] > a[r]){
                l = mid + 1;
            }
            // Step3: 若数组中间值比尾元素小，说明最小值在左边。
            else if (a[mid] < a[r]){
                r = mid;
            }
            // Step4: eg. {1, 0, 1, 1, 1}
            else {
                r--;
            }
        }
        return a[l];
    }

    /**
     * 找出数组中重复的数字。
     * 1. 在一个长度为n的数组中，所有数字都在0~n-1范围内，请找出数组中重复的数字。
     */
    public static boolean isDuplicated(int[] a) {

        int length = a.length;
        if (length == 0) {
            return false;
        }

        /**
         * 数组元素限制(0 ~ n-1)。
         */
        for (int i: a){
            if (i < 0 || i > length - 1){
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (i != a[i]) {
                if (a[i] == a[a[i]]) {
                    return true;
                }
                SortUtils.swap(a, i, a[i]);
            }
        }
        return false;
    }

    /**
     * 找出数组中重复的数字。
     * 2. 在一个长度为n+1的数组中，其中的所有数字的范围都在1~n内，请找出重复的数字。
     */
    public static int isDuplicateDichotomy(int[] a) {

        int length = a.length;
        if (length == 0) {
            return -1;
        }

        int s = 0;
        int e = length - 1;

        while (s <= e) {
            int mid = (s + e) >> 1;
            Integer count = count(a, s, mid);

            if (e == s) {
                if (count > 1) {
                    return e;
                } else {
                    break;
                }
            }

            if (count > (mid - s)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private static Integer count(int[] a, int start, int end) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= start && a[i] <= end) {
                count++;
            }
        }

        return count;
    }
    // endregion

    // region String
    /**
     * 字符串的排列。
     * 1. 递归结束条件: start等于end，拼buf，加入list即可。
     * 2. 否则调整数组、递归(start+1)、还原数组。
     */
    private ArrayList<String> permutationList = new ArrayList<>();
    public List<String> permutation(char[] buf, int start, int end){

        if (start == end){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < end; i++){
                sb.append(buf[i]);
            }
            permutationList.add(new String(sb));
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
             * 1. 正负值符号。
             */
            if (s.charAt(i) == '+' ||s.charAt(i) == '-'){
                // 不合理情况：不在头元素出现，同时前一个元素不是e/E。
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
    public boolean isNumericRegExp(String s){
        /**
         * [\\+\\-]?            : 代表正负符号出现与否。
         * \\d*                 : 代表整数部分是否出现，如: -.314
         * (\\.\\d+)?           : 代表如果出现过小数点，就一定会伴随着数字，否则都不出现。
         * ([eE][\\+\\-]?\\d+)? : 代表如果存在指数，e/E一定会出现，正负号可以不出现，但必须紧跟数字，要么全部不出现。
         */
        return s.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
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
     * 替换空格
     */
    public String replaceBlank(String s){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 32) {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return new String(sb);
    }
    // endregion

    // region Stack、Queue
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
            while (queuePrimary.size() != 1) {
                queueAuxiliary.addLast(queuePrimary.removeFirst());
            }
            return queuePrimary.removeFirst();
        }
    }

    // endregion

    // region Others

    /**
     * @param n: 代表第几位fibonacci。
     */
    public int fibonacciOptimization(int n){
        if (n <= 1){
            return n;
        }
        int x0 = 0;
        int x1 = 1;
        int tempSum = 0;

        for (int i = 2; i < n; i++){
            tempSum = x1 + x0;
            x0 = x1;
            x1 = tempSum;
        }
        return tempSum;
    }

    /**
     * 剪绳子，获取最大乘积(贪婪算法)。
     */
    public int maxProductAfterCutting(int length){
        if (length <  2) {
            return 0;
        }
        // 长度为2，只能切成两段: 1 + 1
        if (length == 2) {
            return 1;
        }
        // 长度为3，只能切成两段: 1 + 2
        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;
        /**
         *  重点: 2 * 2 > 3 * 1
         *  eg: length = 16, 3^5*1 = 243, 3^4*2^2 = 324
         */

        if (length % 3 == 1) {
            timesOf3--;
        }
        /**
         * 下面不能写(length % 3) / 2的原因:
         * 若length = 4, length % 3的结果为1，但是真正想要的结果是 4 / 2 = 2, 而不是 1 / 2 = 0;
         * 那么这个4怎么来的？ 4 = length - 3 * timesOf3 = 4 - 3 * 0 = 4;
         */
        int timeOf2 = (length - 3 * timesOf3) / 2;

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
     * 数组中数字出现的次数。
     * 1. 查询数组中仅出现一次的数字。
     */
    public int findNumberAppearingOnce(int[] nums){
        int result = 0;
        for (int i: nums){
            result = result ^ i;
        }

        return result;
    }

    /**
     * 数组中数字出现的次数。
     * 2. 查询数组中出现二次的数字。
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
        // i为什么等于1？ 因为循环的总结条件是 high != 0。
        int i = 1, high = x, sum = 0;

        while (high != 0){
            ThreePart threePart = getThreePart(x, i);
            high = threePart.getHigh();
            int cur = threePart.getCur();
            int low = threePart.getLow();

            if (cur > 1){
                sum += ((high + 1) * powHelper(i - 1));
            }
            else if (cur < 1){
                sum += (high * powHelper(i - 1));
            }
            else{
                sum += (high * powHelper(i - 1) + low + 1);
            }
            // Don't forget!
            i++;
        }
        return sum;
    }

    /**
     * 根据索引(从1开始)，获得当前高位值、当前值、低位值。
     * 如： x = 12345, i = 2
     * high = 123
     * cur  = 4
     * low  = 5
     */
    public ThreePart getThreePart(int x, int i){
        ThreePart result = new ThreePart();
        int high = x / (int) Math.pow(10, i);
        int rest = (int) (x - high * Math.pow(10, i));
        int cur  = rest / (int) Math.pow(10, i - 1);
        int low  = rest  - cur * (int) Math.pow(10, i - 1);

        result.setHigh(high);
        result.setCur(cur);
        result.setLow(low);
        return result;
    }

    /**
     * 将平方值转换为整数。
     */
    public int powHelper(int i){
        return (int) Math.pow(10, i);
    }

    // endregion
}























