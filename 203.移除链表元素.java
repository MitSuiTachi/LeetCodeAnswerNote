/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temphead = head;
        Queue<ListNode> queue = new LinkedList<>();
        while (temphead != null) {
            if(temphead.val != val) {
                queue.offer(temphead);
            }
            temphead = temphead.next;
        }
        ListNode result = new ListNode();
        temphead = result;
        while (!queue.isEmpty()) {
            temphead.next = queue.poll();
            temphead = temphead.next;
        }
        if (temphead.next != null) {
            temphead.next = null;
        }
        return result.next;
    }
}
// @lc code=end

