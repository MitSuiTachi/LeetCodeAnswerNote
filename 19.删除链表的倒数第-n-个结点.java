/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    /**
     * 找到倒数第n+1个节点，将该节点的next指向原next节点的next
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            if(p1 == null) {
                return head;
            }
            p1 = p1.next;
        }
        if(p1 == null) {
            return head.next;
        }
        
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p2.next = p2.next.next;
        
        return head;
    }
}
// @lc code=end

