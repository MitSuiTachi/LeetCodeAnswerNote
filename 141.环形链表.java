/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        while (true) {
            if(node2 != null) {
                node2 = node2.next;
            }else {
                return false;
            }
            if(node2 != null) {
                node2 = node2.next;
            } else {
                return false;
            }
            node1 = node1.next;

            if(node1 == node2) {
                return true;
            }
        }
    }
}
// @lc code=end

