/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration > timeSeries[i + 1]) {
                result = result + timeSeries[i + 1] - timeSeries[i];
            } else {
                result = result + duration;
            }
        }
        return result + duration;
    }
}
// @lc code=end

