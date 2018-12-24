package com.wxfjava.leetcode.solution1;

import java.util.List;
import java.util.ArrayList;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution6 {

    public String convert(String s, int numRows) {

        if (s == null || "".equals(s)) {
            return "";
        }
        if (numRows <= 1) {
            return s;
        }

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strs.add("");
        }

//        int interval = numRows;
//        if (numRows - 2 > 0) {
//            interval = interval + numRows - 2;
//        }
        int interval = 2 * numRows - 2;

        for (int i = 0; i < s.length(); i++) {
            int val = i % interval;
            int index = val;
            if (val >= numRows) {
                index = numRows - (val - numRows) - 2;
            }
            String str = strs.get(index);
            strs.set(index, str + String.valueOf(s.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * List中的String换成StringBuilder
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int rows = 4;
        Solution6 sol = new Solution6();
        System.out.println(sol.convert(s, rows));
    }
}
