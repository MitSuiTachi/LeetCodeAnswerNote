/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(p1 != null) {
            p1 = p1.next;
            lengthA++;
        }
        while (p2 != null) {
            p2 = p2.next;
            lengthB++;
        }
        if(p1 != p2) {
            return null;
        }
        p1 = headA;
        p2 = headB;
        if (lengthA > lengthB) {
            for(int i = 0; i < lengthA - lengthB; i++) {
                p1 = p1.next;
            }
        } else {
            for(int i = 0; i < lengthB - lengthA; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
// @lc code=end

