package com.wxfjava.leetcode.solution1;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class Solution10 {

    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        char[] schs = s.toCharArray();
        char[] pchs = p.toCharArray();

        int j = 0;
        int i = 0;
        while (i < pchs.length && j < schs.length) {

            char pcoptions = ' ';

            if (i + 1 < pchs.length) {
                if (pchs[i + 1] == '*') {
                    pcoptions = '*';
                }
            }

            if (pcoptions == '*') {

                boolean isDelAll = false;
                if (i + 2 < pchs.length) {
                    if (pchs[i] == pchs[i + 2]) {
                        isDelAll = true;
                    }
                }

                while (j < schs.length && (schs[j] == pchs[i] || pchs[i] == '.')) {
                    j++;
                }

                if (pchs[i] == '.') {
                    if (i + 2 < pchs.length) {

                        char pch = pchs[i + 2];
                        for (int x = 0; x < schs.length; x++) {
                            if (pch == schs[x]) {
                                j = x;
                            }
                        }

                        if (j >= schs.length) {
                            return false;
                        }
                    }
                }

                if (isDelAll) {

                    int x = i + 2 + 1;
                    while (x < pchs.length && pchs[i] != pchs[x]) {
                        x++;
                    }
                    i = x;
                    System.out.println("add");
                } else {
                    i = i + 2;
                }


            } else {

                if (pchs[i] == '.') {
                    i++;
                    j++;
                } else {
                    if (schs[j] != pchs[i]) {
                        return false;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
        }

        System.out.println("i:" + i + ",j:" + j);

        if (j >= schs.length && i >= pchs.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution10 sol = new Solution10();

        String s = "aaaaaaaaaaaa";
        String p = "c*a";

        System.out.println(sol.isMatch(s, p));
    }

}
