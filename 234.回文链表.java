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
<<<<<<< HEAD
<<<<<<< HEAD
        if (head == null) {
=======
        if(head == null) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
=======
        if(head == null) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
            return false;
        }
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
<<<<<<< HEAD
<<<<<<< HEAD
        while (p != null) {
=======
        while(p != null) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
=======
        while(p != null) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
            stack.push(new Integer(p.val));
            p = p.next;
        }
        p = head;
<<<<<<< HEAD
<<<<<<< HEAD
        while (p != null) {
            if (p.val == stack.peek()) {
=======
        while(p != null) {
            if(p.val == stack.peek()) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
=======
        while(p != null) {
            if(p.val == stack.peek()) {
>>>>>>> 1fa991af811163dd4afee1478cdd86d075daead0
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

