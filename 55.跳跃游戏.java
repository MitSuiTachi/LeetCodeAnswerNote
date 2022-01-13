/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start

/**
 * 对于 nums 数组中的某一元素 nums[i] = k, 则它可以到达的位置有 i + 1, i + 2,...i + k;
 * 如果用一个 boolean 数组 canJumptoEnd 表示 nums 中的元素是否可以到达最后一个位置，
 * 则，canJumptoEnd[i] 的值有如下的情况
 * 1.如果 i + nums[i] >= nums.length，则 canJumptoEnd[i] = true
 * 2.如果 nums[i] == 0 && i < nums.length，则 canJumptoEnd[i] = false
 * 3.canJumptoEnd[i] = canJumptoEnd[i + 1] || canJumptoEnd[i + 2] ||...|| canJumptoEnd[i + k];
 * 1和2可以作为递归出口，3可以将问题转换为子问题进行求解，canJumptoEnd 数组还可以为记忆化搜索提供查询。
 */
class Solution {
    // 一开始用的是 boolean 数组存储这个值，但是由于 boolean 默认会被初始化为 false
    // 这样无法判断是未遍历到还是遍历到了并设置为 false
    // 此处改用 int 数组表示，0为默认值（未遍历），1表示 false，2表示 true
    private int[] canJumptoEnd;
    private int[] nums;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        canJumptoEnd = new int[nums.length];
        return canJumpToEnd(0);
    }

    private boolean canJumpToEnd(int current) {
        if (canJumptoEnd[current] != 0) {
            return canJumptoEnd[current] == 2 ? true : false;
        }
        if (nums[current] == 0 && current < nums.length - 1) {
            canJumptoEnd[current] = 1;
            return false;
        }
        if (current + nums[current] >= nums.length - 1) {
            canJumptoEnd[current] = 2;
            return true;
        }
        for (int i = 1; i <= nums[current]; i++) {
            if (canJumpToEnd(current + i)) {
                canJumptoEnd[current] = 2;
                return true;
            }
        }
        canJumptoEnd[current] = 1;
        return false;
    }
}

/**
 * 贪心算法
 * 用一个变量 maxRange 存储能访问到的最远距离
 * 当 maxRange >= nums.length 时，表明能访问到最后一个位置
 * 并且当 i + nums[i] > maxRange 时更新 maxRange
 */
class Solution_2 {
    private int maxRange;

    public boolean canJump(int[] nums) {
        for (int i = 0; i <= maxRange; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (maxRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 基于贪心算法的贪心算法
 * 在 Solution_2 解法的基础上，做了如下优化，当 maxRange 发生变化时，下一次判断我们直接从 maxRange 往前判断
 * 因为，最容易突破当前 maxRange 的位置，较大概率是离当前 maxRange 较近的位置，因此从 maxRange -> 0，可以较快发现能够突破当前 maxRange 的位置
 * 尽管从理论分析上 Solution_3 是要优于 Solution_2 的，但是在 LeetCode 实际提交中，两者运行时间差距不大，内存使用 Solution_3 略优于 Solution_2
 * 后面两种解法要明显优于第一种
 */
class Solution_3 {
    private int maxRange;

    public boolean canJump(int[] nums) {
        for (int i = 0; i >= 0; ) {
            if (maxRange < i + nums[i]) {
                maxRange = i + nums[i];
                i = maxRange;
            } else {
                i--;
            }
            if (maxRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

// @lc code=end

