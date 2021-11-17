/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            long temp = (long) middle * middle;
            if (temp == num) {
                return true;
            }
            if (temp > num) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }
}
// @lc code=end

