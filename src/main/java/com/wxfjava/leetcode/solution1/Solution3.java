package com.wxfjava.leetcode.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        int subLength = 1;

        for (int i = 0; i < s.length(); i++) {

            String sub = "";
            for (int j = i; j < s.length(); j++) {

                if (sub.contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                sub = sub + s.charAt(j);
            }

            if (subLength < sub.length()) {
                subLength = sub.length();
            }
        }

        return subLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }

            System.out.println("i:" + i + ",j:" + j);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int i = solution.lengthOfLongestSubstring2("pwwkew");
        System.out.println(i);
    }

}
