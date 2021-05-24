/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode frontNode = head;
        ListNode behindNode = head;
        while (behindNode.next != null) {
            behindNode = behindNode.next;
            if(behindNode.val != frontNode.val) {
                frontNode.next = behindNode;
                frontNode = behindNode;
            }
        }
        if (behindNode.val == frontNode.val) {
            frontNode.next = null;
        }
        
        return head;
    }
}
// @lc code=end

