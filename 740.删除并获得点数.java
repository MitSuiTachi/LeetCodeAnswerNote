/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start

/**
 * 在删除 n 后，可以获得 n 个点数，并且需要同时删除所有 n - 1 和 n + 1
 * 针对删除 n 的操作，在删除一个 n 后，我们可以通过删除所有 n 以获得最多点数
 * 题目可以做如下理解，
 * 对于一个整数数组 nums, 设其元素最大值为 N, 则 nums 中元素的范围一定在 [0, N]中，
 * 设每个元素出现的次数为 Ci(i = 0, 1, 2..., N), 则删除某个数 n 所能获得最多点数为 Ci * i,
 * 构建数组 earningsForNums 用于统计删除某个元素所能获得的最多点数，即 earningsForNums[i] = Ci * i (i = 0, 1, 2..., N);
 * 问题可转换为在 earningsForNums 数组上进行遍历操作所能获得的最大点数，
 * 遍历条件如下：
 * 1.遍历了元素 n 后，不可再遍历相邻的 n - 1 和 n + 1 元素
 *
 * 问题转换为了与 LeetCode198.打家劫舍相同的问题
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 统计 nums 数组中的最大值，用于构建 earningsForNums 数组
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // 构建 earningsForNums 数组，用于统计删除某个数 n，所能获得最大点数
        // 未出现在 nums 数组中的数为0
        int[] earningsForNums = new int[max];
        for (int i = 0; i < nums.length; i++) {
            earningsForNums[nums[i] - 1] += nums[i];
        }

        // maxEarnings 数组用于统计遍历前 n 个能获得的最大点数
        // 这里是针对打家劫舍问题的另一种解法，之前是通过从尾部向头部递归，递推关系为 maxEarnings[n] = Math.max(maxEarnings[n - 2] + earningsForNums[n - 1], maxEarnings[n - 1])
        // 即，from n -> 0
        // 这里是通过滑动数组从头部向尾部滑动，递推关系同上，初始入口为 maxEarnings[0] = earningsForNums[0] 和 maxEarnings[1] = Math.max(earningsForNums[0], earningsForNums[1]);
        // 注意，这里的 maxEarnings[0] 对应的是有一件屋子（或者只有一个数字时）时能获得最大收益（或者点数），故为 earningsForNums[0];
        // 即，from 0 -> n
        int[] maxEarnings = new int[max];
        if (maxEarnings.length == 0) {
            return 0;
        }
        if (maxEarnings.length == 1) {
            return earningsForNums[0];
        }
        maxEarnings[0] = earningsForNums[0];
        maxEarnings[1] = Math.max(earningsForNums[0], earningsForNums[1]);
        for (int i = 2; i < max; i++) {
            maxEarnings[i] = Math.max(maxEarnings[i - 2] + earningsForNums[i], maxEarnings[i - 1]);
        }
        return maxEarnings[max - 1];
    }
}

// @lc code=end

