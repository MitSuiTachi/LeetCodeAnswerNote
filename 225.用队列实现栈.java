/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// 用队列实现栈，队列是先进先出的数据结构，栈是先进后出的数据结构「
// @lc code=start
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(new Integer(x));
        } else {
            q2.offer(new Integer(x));
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int result;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            result = q1.peek();
            q2.offer(q1.poll());
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            result = q2.peek();
            q1.offer(q2.poll());
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

