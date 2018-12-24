package com.wxfjava.leetcode.solution1;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {


    public String longestPalindrome(String s) {

        if (s == null || "".equals(s)) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        String sub = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {

            for (int j = s.length() - 1; j > i; j--) {
                if (((j - i + 1) < sub.length())) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {


                    boolean flag = true;
                    for (int n = i, m = j; n < m; n++, m--) {
                        if (s.charAt(n) != s.charAt(m)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if ((j - i + 1) > sub.length()) {
                            sub = s.substring(i, j) + s.charAt(j);

                            if (i < ((i + j) / 2 - 1)) {
                                i = (i + j) / 2 - 1;
                            }
                        }
                    }
                }
            }
        }
        return sub;
    }

    /**
     * 中心扩展法.
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "bb";
        Solution5 solution = new Solution5();

        System.out.println(solution.longestPalindrome2(s));

    }
}
