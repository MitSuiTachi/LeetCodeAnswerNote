/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int remainder = 0;
        while (n != 1 && remainder == 0) {
            remainder = n % 2;
            n = n / 2;
        }
        if (remainder != 0) {
            return false;
        } else {
            return true;
        }
    }
}
// @lc code=end

