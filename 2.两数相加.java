/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private boolean isNeedUp = false;
    //通过p1和p2遍历两个链表
    private ListNode mResult;

    private ListNode p;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            ListNode temp = new ListNode();
        }
    }

    private int add(int a, int b) {
        int add = isNeedUp ? 1 : 0;
        if(a + b > 10) {
            isNeedUp = true;
            return a + b + add -10;
        } else {
            isNeedUp = false;
            return a + b + add;
        }
    }
}
// @lc code=end

