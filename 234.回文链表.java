/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while(p != null) {
            stack.push(new Integer(p.val));
            p = p.next;
        }
        p = head;
        while(p != null) {
            if(p.val == stack.peek()) {
                p = p.next;
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

