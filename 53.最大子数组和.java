/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start

/**
 * 对数组 nums 中的任意一个元素 nums[i] 而言，如果我们用 currentMax[i] 表示以它为结尾的连续子串的最大和，则有如下递推式：
 * currentMax[0] = nums[0];
 * currentMax[i] = Math.max(currentMax[i - 1] + nums[i], nums[i]) (i = 1, 2,...,nums.length - 1)
 * currentMax 中的最大值即为所求
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] currentMax = new int[nums.length];
        currentMax[0] = nums[0];
        int result = currentMax[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax[i] = Math.max(currentMax[i - 1] + nums[i], nums[i]);
            result = Math.max(result, currentMax[i]);
        }
        return result;
    }
}

// @lc code=end

