/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start

/**
 * 对于 nums 数组中的任意一个元素 nums[i]，用数组 minSteps 记录到达 nums 中所有位置所需要的最小步数
 * 则 minSteps[i] = 1 + Math.min(minSteps[i - 1], minSteps[i - 1].....)
 * 其中 minSteps[0] = 0;
 * 对于 nums[i]，我们在计算 minSteps[i] 时需要计算所有在 i 之前的 minSteps 吗？答案是不用，我们只需要知道 nums 中的最大值，例如
 * nums = [1, 4, 2, 3, 1, 1, 2]，nums 中的最大值为 4，那么对任意的 i，我们只需要往前遍历到 i - 4 即可，毕竟超出了这个范围，就无法再一步走到位置 i 了
 */
class Solution {
    int[] minSteps;

    public int jump(int[] nums) {
        int max = nums[0];
        // 初始化 minSteps，除 minSteps[0] 之外全部置为 Integer.MAX_VALUE，不然后面 minSteps[j] + 1 < minSteps[i] 无法进行
        minSteps = new int[nums.length];
        for (int i = 1; i < minSteps.length; i++) {
            minSteps[i] = Integer.MAX_VALUE;
        }

        // 统计最大的步长
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // 对每个位置，向前统计 max 个元素，计算 minSteps[i]
        for (int i = 1; i < nums.length; i++) {
            // 增加边界判断 j >= 0 或 j > -1，防止越界
            for (int j = i - 1; j > -1 && j >= i - max; j--) {
                if (j + nums[j] >= i && minSteps[j] + 1 < minSteps[i]) {
                    minSteps[i] = minSteps[j] + 1;
                }
            }
        }
        return minSteps[minSteps.length - 1];
    }
}

// @lc code=end

