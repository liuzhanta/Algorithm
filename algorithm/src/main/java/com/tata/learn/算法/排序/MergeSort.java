package com.tata.learn.算法.排序;

import java.util.Arrays;

/**
 * @Description: 步骤1：把长度为n的输入序列分成两个长度为n/2的子序列；
 * 步骤2：对这两个子序列分别采用归并排序；
 * 步骤3：将两个排序好的子序列合并成一个最终的排序序列。
 * @Author: Terry
 * @Date: 4/16/21 2:58 PM
 */
public class MergeSort implements ISort {
    @Override
    public int[] sort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(sort(left), sort(right));

    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if(i>=left.length){

            }
        }
        return null;

    }
}
