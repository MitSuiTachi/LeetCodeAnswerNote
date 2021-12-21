/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        result.next = head;
        reverseNextKNode(result, k);
        return result.next;
    }

    private void reverseNextKNode(ListNode mountNode, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = mountNode.next;
        int count = 0;
        boolean isNeedPushToStack = true;
        while (isNeedPushToStack && count != k) {
            if (node != null) {
                stack.push(node);
                node = node.next;
                count++;
            } else {
                isNeedPushToStack = false;
            }
        }
        // 当 count 为 k 时， 表示入栈了 k 个节点
        if (count == k) {
            ListNode currentKTail = mountNode;
            ListNode nextKHeadNode = stack.peek().next;
            while (!stack.isEmpty()) {
                currentKTail.next = stack.pop();
                currentKTail = currentKTail.next;
            }
            currentKTail.next = nextKHeadNode;
            reverseNextKNode(currentKTail, k);
        } else {
            return;
        }
    }
}
// @lc code=end

