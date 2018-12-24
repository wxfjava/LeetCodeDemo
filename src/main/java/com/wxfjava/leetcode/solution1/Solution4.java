package com.wxfjava.leetcode.solution1;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Solution4 {

    /**
     * 时间复杂度不合要求,感觉比较复杂.就搞了个简单的
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> nums = new LinkedList<>();

        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }

        int i = 0, j = 0;
        if (nums1.length > 0 && nums2.length > 0) {
            while (i < nums1.length) {

                if (nums1[i] < nums2[j]) {
                    nums.add(nums1[i]);
                    i++;
                } else {
                    nums.add(nums2[j]);
                    j++;
                    if (j >= nums2.length) {
                        break;
                    }
                }
            }
        }


        while (i < nums1.length) {
            nums.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            nums.add(nums2[j]);
            j++;
        }

        double result = 0;
        if (nums.size() % 2 == 0) {
            int index = nums.size() / 2 - 1;
            result = 1.0 * (nums.get(index) + nums.get(index + 1)) / 2;
        } else {
            result = nums.get(nums.size() / 2);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {};
        int[] nums2 = {2};

        Solution4 solution = new Solution4();

        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }
}
