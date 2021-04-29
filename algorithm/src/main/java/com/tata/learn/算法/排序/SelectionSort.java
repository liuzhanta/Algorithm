package com.tata.learn.算法.排序;

import com.example.lib.Printer;

/**
 * 选择排序
 * a、将第一个值看成最小值
 * <p>
 * 　　b、然后和后续的比较找出最小值和下标
 * <p>
 * 　　c、交换本次遍历的起始值和最小值
 * <p>
 * 　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
 */
public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
             int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            Printer.print(array);
        }
        return array;
    }


}
