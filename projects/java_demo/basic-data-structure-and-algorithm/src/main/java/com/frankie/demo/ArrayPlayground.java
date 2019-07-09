package com.frankie.demo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArrayPlayground {

    public static int getMinimumElement(int[] a){

        if(a.length < 1) return 0;

        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if(Sort.less(a[i], min)) min = a[i];
        }

        return min;
    }

    public static int getSecondMinElement(int[] a){
        // Step1: Get minimum element.
        int minimumElement = ArrayPlayground.getMinimumElement(a);

        // Step2: Remove minimum element.
        int[] deleteMinArray = ArrayUtils.removeElement(a, minimumElement);

        // Step3: Get second minimum element.
        int secondMinElement = ArrayPlayground.getMinimumElement(deleteMinArray);

        return secondMinElement;
    }

    public static int getSecondMinElementOptimization(int[] a){

        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i: a){
            if(Sort.less(i, min)){
                secondMin = min;
                min = i;
            } else if (Sort.less(i, secondMin) && i != min){
                secondMin = i;
            }
        }
        return secondMin;
    }

    public static int getFirstNonRepeatingElem(int[] a){

        int length = a.length;
        for (int i = 0; i < length; i++){
            int j;
            for (j = 0; j < length; j++){
                if (i != j && a[i] == a[j]) break;
            }
            if(j == length) return a[i];
        }
        return -1;
    }

    public static int getFirstNonRepeatingElemUsingHashMap(int[] a){

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i: a){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        for (int i: a){
            if(hashMap.get(i) == 1){
                return i;
            }
        }
        return -1;
    }

    public static int[] mergeTwoSortedArray(int[] a, int[] b){
        int aLength = a.length;
        int bLength = b.length;
        int[] result = new int[aLength + bLength];
        int i = 0, j = 0, k = 0;

        while (i < aLength && j < bLength){
            if (Sort.less(a[i], b[j])){
                result[k++] = a[i++];
            } else{
                result[k++] = b[j++];
            }
        }

        while (i < aLength) result[k++] = a[i++];
        while (j < bLength) result[k++] = b[j++];

        return result;
    }
}
