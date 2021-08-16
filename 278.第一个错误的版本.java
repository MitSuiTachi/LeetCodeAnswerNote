/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        return judgeMiddle(1, n);
    }

    private int judgeMiddle(int head, int tail) {
        if (head + 1 == tail) {
            return isBadVersion(head) ? head : tail;
        }
        int middle = head + (tail - head) / 2;
        if (isBadVersion(middle) == false) {
            return judgeMiddle(middle, tail);
        } else {
            return judgeMiddle(head,middle);
        }
    }
}
// @lc code=end

