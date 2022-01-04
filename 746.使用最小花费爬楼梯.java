/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start

/**
 * 假设 cost 数组长度为 n，由于数组下标从0 -> n - 1
 * 那么可以从第 n - 1 级台阶向上爬1级或者从第 n - 2 级台阶向上爬2级到达楼梯顶部
 * 针对此问题有如下递推关系
 * 此时 stairMinTotalCost[n] = min(stairMinTotalCost[n - 1] + cost[n - 1], stairMinTotalCost[n - 2] + cost[n - 2])
 */
class Solution {
    // cost[] 的副本，用于在递归过程中方法间共享访问，stairCost[n] 存储在第 n 级台阶继续向上走所需开销
    private int[] stairCost;

    // 记忆化搜索，用与在递归过程中查找是否已经计算过该值，避免重复计算。stairMinTotalCost[n] 存储到达第 n 级台阶所需的最小开销
    private int[] stairMinTotalCost;

    public int minCostClimbingStairs(int[] cost) {
        // 比 cost[] 的长度多1位，因为cost[]的下标范围为0 -> cost.length - 1
        // 但是在 cost.length - 1 位置还能再向上走一级，即 stairMinTotalCost.length = cost.length + 1
        stairMinTotalCost = new int[cost.length + 1];
        int stairs = cost.length;
        stairCost = cost;
        return minCostClimbingStairs(stairs);
    }

    private int minCostClimbingStairs(int stairs) {
        // 由于可以选择从0或者1处的台阶出发，因此可以理解为到达0和1处台阶的开销为0
        if (stairs < 2) {
            stairMinTotalCost[stairs] = 0;
            return stairMinTotalCost[stairs];
        }
        if (stairMinTotalCost[stairs] != 0) {
            return stairMinTotalCost[stairs];
        }
        stairMinTotalCost[stairs] = Math.min(minCostClimbingStairs(stairs - 1) + stairCost[stairs - 1],
                minCostClimbingStairs(stairs - 2) + stairCost[stairs - 2]);
        return stairMinTotalCost[stairs];
    }
}

// @lc code=end

