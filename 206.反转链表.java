/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tempHead = head;
        ListNode result = new ListNode();
        while (tempHead != null) {
            stack.push(tempHead);
            tempHead = tempHead.next;
        }
        tempHead = result;
        while (stack.size() > 1) {
            tempHead.next = stack.pop();
            tempHead = tempHead.next;
        }
        tempHead.next = stack.pop();
        tempHead.next.next = null;
        return result.next;
    }
}
// @lc code=end

