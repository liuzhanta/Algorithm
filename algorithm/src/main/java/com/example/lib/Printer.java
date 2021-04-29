package com.example.lib;

/**
 * @Description:
 * @Author: Terry
 * @Date: 4/16/21 2:45 PM
 */
public class Printer {
    public static void print(int []array){
        StringBuilder sb=new StringBuilder();
        for (int i1 = 0; i1 < array.length; i1++) {
            int i = array[i1];
            sb.append(i);
            if (i1!=array.length-1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
