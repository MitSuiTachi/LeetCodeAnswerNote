/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p1 = node;
        ListNode p2 = p1.next;
        while (p2.next != null) {
            p1.val = p2.val;
            p1 = p2;
            p2 = p2.next;
        }
        p1.val = p2.val;
        p1.next = null;
    }
}
// @lc code=end

