/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            n = n - i;
            result++;
        }
        return result;
    }
}
// @lc code=end

