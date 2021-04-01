package com.tata.learn.算法.动态规划;

/**
 * Description:
 *
 * @Author: mobike
 * @Date:2021/1/19,下午3:42
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 分别拿到奇数偶数的回文子串长度
            int oddLen = expandAroundtCenter(s, i, i);
            int evenLen = expandAroundtCenter(s, i, i + 1);

            // 对比最大的长度
            int len = Math.max(oddLen, evenLen);
            // 计算对应最大回文子串的起点和终点
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundtCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
