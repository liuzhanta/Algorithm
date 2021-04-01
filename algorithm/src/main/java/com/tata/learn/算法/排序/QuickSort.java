package com.tata.learn.算法.排序;

public class QuickSort implements ISort {
    @Override
    public void sort(int[] array) {
        quickSort(array);
    }

    private void quickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    /**
     * a、确认列表第一个数据为中间值，第一个值看成空缺（低指针空缺）。
     * b、然后在剩下的队列中，看成有左右两个指针（高低）。
     * c、开始高指针向左移动，如果遇到小于中间值的数据，则将这个数据赋值到低指针空缺，并且将高指针的数据看成空缺值（高指针空缺）。然后先向右移动一下低指针，并且切换低指针移动。
     * d、当低指针移动到大于中间值的时候，赋值到高指针空缺的地方。然后先高指针向左移动，并且切换高指针移动。重复c、d操作。
     * e、直到高指针和低指针相等时退出，并且将中间值赋值给对应指针位置。
     * f、然后将中间值的左右两边看成行的列表，进行快速排序操作。
     *
     * @param array
     * @param low
     * @param high
     */
    private void quickSort(int[] array, int low, int high) {
        ////如果指针在同一位置(只有一个数据时)，退出
        if (low > high) {
            return;
        }
        //默认中间值为低指针的第一个值
        int pivot = array[low];

        //记录指针的其实位置
        int start = low;
        int end = high;

        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (array[high] > pivot) {
                    high--;
                } else if (array[high] < pivot) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    array[low] = array[high];
                    flag = false;
                    low++;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (array[low] < pivot) {
                    low++;
                } else if (array[low] > pivot) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    array[high] = array[low];
                    flag = true;
                    high--;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (high == low) {
                array[low] = pivot;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(array, start, low - 1);
        quickSort(array, low + 1, end);
    }


}
