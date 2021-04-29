package com.tata.learn.算法.排序;

public class QuickSort1 implements ISort {
    @Override
    public int[] sort(int[] array) {
        quickSort(array);
        return array;
    }

    private void quickSort(int[] array) {

        int low = 0;
        int high = array.length - 1;
        quicksort(array, low, high);
    }

    private void quicksort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int start = low;
        int end = high;
        boolean flag = true;
        int pivot = array[low];
        while (true) {
            if (flag) {
                if (pivot < array[high]) {
                    high--;
                } else if (pivot > array[high]) {
                    array[low] = array[high];
                    low++;
                    flag = false;
                }
            } else {
                if (pivot > array[low]) {
                    low++;
                } else if (pivot > array[low]) {
                    array[high] = array[low];
                    high--;
                    flag = true;
                }
            }

            if (low == high) {
                array[low] = pivot;
                break;
            }
        }
        quicksort(array, start, low - 1);
        quicksort(array, low + 1, end);
    }


}
