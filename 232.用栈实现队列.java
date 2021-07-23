/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!s1.isEmpty()) {
            s1.push(new Integer(x));
        } else {
            s2.push(new Integer(x));
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = getOutStack(s1, s2).pop();
        reverse(s1, s2);
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = getOutStack(s1, s2).peek();
        reverse(s1, s2);
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private Stack<Integer> getOutStack(Stack<Integer> s1, Stack<Integer> s2) {
        reverse(s1, s2);
        return s1.isEmpty() ? s2 : s1;
    }

    private void reverse(Stack<Integer> s1, Stack<Integer> s2) {
        if (!s1.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        } else {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

