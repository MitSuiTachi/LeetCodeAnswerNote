/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start

/**
 * 假设数量为 n 的房屋进行偷窃，所能取得的最大收益为 maxEarnings[n]
 * 那么对 maxEarnings[n] 而言，由于只能偷窃相邻2间房屋中的一个，存在如下递推关系：
 * maxEarnings[n] = max(maxEarnings[n - 2] + nums[n], maxEarnings[n - 1])
 * 即偷不偷第 n 间房屋？偷，则收益为 maxEarnings[n - 2] + nums[n]；不偷，则收益为 maxEarnings[n - 1]。
 * 且当 n = 0 时，maxEarnings[0] = 0
 * 当 n = 1 时，maxEarnings[1] = nums[0];
 * 当 n = 2 时，maxEarnings[2] = max(maxEarnings[0] + nums[1], maxEarnings[1]) => max(nums[0], nums[1]);
 */
class Solution {
    // 记忆化搜索，用于存储已经计算过的值，避免重复计算
    private int[] maxEarnings;
    // nums 的副本，用于在递归中共享访问
    private int[] numsCopy;

    public int rob(int[] nums) {
        maxEarnings = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxEarnings[i] = -1;
        }
        numsCopy = nums;
        return robForMaxEarnings(nums.length);
    }

    /**
     * 计算对 n 间房屋进行偷窃能获得的最大收益
     * @param n 房间总数[0, Integer.MAX_VALUE]
     * @return
     */
    private int robForMaxEarnings(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            maxEarnings[0] = numsCopy[0];
            return maxEarnings[0];
        }
        if (maxEarnings[n - 1] >= 0) {
            return maxEarnings[n - 1];
        }

        // 由于数组下标是从[0, n - 1]，因此偷窃 n 间房屋所能获得的最大收益存储在 maxEarnings[n - 1]
        // 第 n 间房屋的收益为 numsCopy[n - 1]
        maxEarnings[n - 1] = Math.max(robForMaxEarnings(n - 2) + numsCopy[n - 1], robForMaxEarnings(n - 1));
        return maxEarnings[n - 1];
    }
}

// @lc code=end

