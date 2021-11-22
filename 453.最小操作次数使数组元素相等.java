/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        int result = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result = result + (nums[i] - min);
        }
        return result;
    }
}
// @lc code=end

