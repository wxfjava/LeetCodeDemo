package com.wxfjava.leetcode.solution1;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public long getLength(ListNode l) {
        if (l == null) {
            return 0;
        }

        int length = 1;
        ListNode p = l;

        while (p.next != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        long length1 = getLength(l1);
        long length2 = getLength(l2);
        if (length1 > length2) {
            p1 = l2;
            p2 = l1;
        }

        int last = 0;
        int sum = p1.val + p2.val;
        last = sum / 10;
        ListNode resultList = new ListNode(sum % 10);
        ListNode pr = resultList;

        while (p1.next != null) {

            p1 = p1.next;
            p2 = p2.next;

            int s = p1.val + p2.val + last;
            last = s / 10;
            pr.next = new ListNode(s % 10);
            pr = pr.next;
        }

        while (last != 0) {

            p2 = p2.next;
            if (p2 == null) {
                p2 = new ListNode(0);
            }

            int s = p2.val + last;
            last = s / 10;
            pr.next = new ListNode(s % 10);
            pr = pr.next;
        }
        if (p2 != null) {
            pr.next = p2.next;
        }

        return resultList;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(9);

        ListNode list2 = new ListNode(5);

        Solution2 solution = new Solution2();
        solution.display(list1);
        System.out.println("----");
        solution.display(list2);
        System.out.println("----");
        long s = System.currentTimeMillis();
        ListNode result = solution.addTwoNumbers(list1, list2);
        solution.display(result);
        System.out.println("time:" + (System.currentTimeMillis() - s));
        System.out.println("---- ");
        s = System.currentTimeMillis();
        ListNode listNode = solution.addTwoNumbers2(list1, list2);
        System.out.println("time:" + (System.currentTimeMillis() - s));
        solution.display(listNode);
    }

    public void display(ListNode node) {

        ListNode p = node;
        System.out.println(p.val);
        while (p.next != null) {
            p = p.next;
            System.out.println(p.val);
        }
    }


}
