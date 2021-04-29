package com.example.lib;

import com.tata.learn.算法.排序.InsertionSort;
import com.tata.learn.算法.排序.SelectionSort;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        int [] array= {8,5,6,9,3,1,4};
        //选择排序
//        new SelectionSort().sort(array);

        // 插入排序
        new InsertionSort().sort(array);

        int sum= 12/9;
        int carry = 12%9;
        System.out.println("sum = "+sum+" ,carry = "+carry);

        Printer.print(array);

    }
}