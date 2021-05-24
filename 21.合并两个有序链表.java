/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    private ListNode mResult = new ListNode();
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempTailNode = mResult;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                tempTailNode.next = l1;
                l1 = l1.next;
            } else {
                tempTailNode.next = l2;
                l2 = l2.next;
            }
            tempTailNode = tempTailNode.next;
        }
        if (l1 == null) {
            tempTailNode.next = l2;
        } else {
            tempTailNode.next = l1;
        }
        return mResult.next;
    }
}
// @lc code=end

