/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start

import java.util.Arrays;

/**
 * 对于数量为 n 的房屋，由于头尾相连，因此对于第一间房屋和最后一间房屋，只能对其中之一进行选择是否偷窃
 * 即问题可以分解为2个子集，即，是否偷第一间房屋？是，则可选房屋为 Front:[1, n - 1];否，则可选房屋为 Behind:[2, n]
 * 如果用函数 robForMaxEarnings(int[] houses) 计算对一个房屋集合 houses 进行偷窃所能获得的最大收益
 * 那么此题的答案就为 Math.max(robForMaxEarnings(Front), robForMaxEarnings(Behind))
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int housesNum = nums.length - 1;
        int[] maxEarningsForFront = new int[housesNum];
        int[] maxEarningsForBehind = new int[housesNum];
        for (int i = 0; i < housesNum; i++) {
            maxEarningsForFront[i] = -1;
            maxEarningsForBehind[i] = -1;
        }
        int[] front = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] behind = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robForMaxEarnings(housesNum, front, maxEarningsForFront), robForMaxEarnings(housesNum, behind, maxEarningsForBehind));
    }

    /**
     * 计算对前 n 间房屋进行偷窃所能获得的最大收益
     *
     * @param n           房屋数量
     * @param nums        存储每间房屋所能获得收益的集合
     * @param maxEarnings 记忆化搜索，maxEarnings[i] 存储偷窃前 i 间房屋所能获得最大收益，避免重复计算
     * @return
     */
    private int robForMaxEarnings(int n, int[] nums, int[] maxEarnings) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            maxEarnings[0] = nums[0];
            return maxEarnings[0];
        }
        if (maxEarnings[n - 1] >= 0) {
            return maxEarnings[n - 1];
        }
        maxEarnings[n - 1] = Math.max(robForMaxEarnings(n - 2, nums, maxEarnings) + nums[n - 1], robForMaxEarnings(n - 1, nums, maxEarnings));
        return maxEarnings[n - 1];
    }
}

// @lc code=end

