package com.tata.learn.数据结构.数组;

/**
 * @Description:数组相关题目
 * @Author: Terry
 * @Date: 2/24/21 10:57 PM
 */
public class Array_Level_Easy {
    /**
     * 螺旋矩阵
     *
     * @param matrix https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (true) {
            //left to right
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // right to left
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }

            // bottom to top
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }

        return res;

    }
}
