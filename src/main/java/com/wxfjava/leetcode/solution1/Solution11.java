package com.wxfjava.leetcode.solution1;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Solution11 {


    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {

            int indexLeft = -1;
            for (int l = 0; l < height.length; l++) {
                if (height[l] >= height[i]) {
                    indexLeft = l;
                    break;
                }
            }
            int indexRight = -1;
            for (int r = height.length - 1; r >= 0; r--) {
                if (height[r] >= height[i]) {
                    indexRight = r;
                    break;
                }
            }

            if (indexLeft < indexRight) {
                int area = height[i] * (indexRight - indexLeft);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    /**
     * 双指针法
     *
     *
     */
    public class Solution {
        public int maxArea(int[] height) {
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r])
                    l++;
                else
                    r--;
            }
            return maxarea;
        }
    }

    public static void main(String[] args) {
        Solution11 sotution = new Solution11();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(sotution.maxArea(heights));
    }
}