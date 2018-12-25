package com.wxfjava.leetcode.solution1;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution7 {

    public int reverse(int x) {
        long reslut = 0;
        long num = x;

        while (num != 0) {
            reslut = (reslut * 10) + (num % 10);
            num = num / 10;
        }

        if (reslut > Integer.MAX_VALUE || reslut < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reslut;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(1534236469));
    }

}
