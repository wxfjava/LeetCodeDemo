package com.wxfjava.leetcode.solution1;

import java.util.List;
import java.util.ArrayList;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution9 {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        List<Integer> nums = new ArrayList();

        while (x != 0) {
            nums.add(x % 10);
            x = x / 10;
        }

        int mid = nums.size() / 2;
        for (int i = 0; i < mid; i++) {
            if (nums.get(i) != nums.get(nums.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        int x = 10;

        System.out.println(sol.isPalindrome(x));
    }
}
