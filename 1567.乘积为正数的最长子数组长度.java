/*
 * @lc app=leetcode.cn id=1567 lang=java
 *
 * [1567] 乘积为正数的最长子数组长度
 */

// @lc code=start

/**
 * 对于一个整数数组，求其乘积为正的最长子数组长度，由于数组中的数可正可负也可为零
 */
class Solution {
    public int getMaxLen(int[] nums) {
        return Math.max(getMaxLenFront(nums), getMaxLenBehind(nums));
    }

    private int getMaxLenFront(int[] nums) {
        int result = 0;
        int countNegatives = 0;
        int frontLength = 0;
        int behindLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (countNegatives == 0) {
                    frontLength++;
                } else {
                    behindLength++;
                }
            }
            if (nums[i] < 0) {
                countNegatives++;
                if (countNegatives == 2) {
                    frontLength += behindLength;
                    frontLength += 2;
                    behindLength = 0;
                    countNegatives = 0;
                }
            }
            if (nums[i] == 0) {
                result = Math.max(result, frontLength);
                result = Math.max(result, behindLength);
                frontLength = 0;
                behindLength = 0;
                countNegatives = 0;
            }
        }
        result = Math.max(result, frontLength);
        result = Math.max(result, behindLength);
        return result;
    }

    private int getMaxLenBehind(int[] nums) {
        int result = 0;
        int countNegatives = 0;
        int frontLength = 0;
        int behindLength = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] > 0) {
                if (countNegatives == 0) {
                    frontLength++;
                } else {
                    behindLength++;
                }
            }
            if (nums[i] < 0) {
                countNegatives++;
                if (countNegatives == 2) {
                    frontLength += behindLength;
                    frontLength += 2;
                    behindLength = 0;
                    countNegatives = 0;
                }
            }
            if (nums[i] == 0) {
                result = Math.max(result, frontLength);
                result = Math.max(result, behindLength);
                frontLength = 0;
                behindLength = 0;
                countNegatives = 0;
            }
        }
        result = Math.max(result, frontLength);
        result = Math.max(result, behindLength);
        return result;
    }
}

class Solution_2 {
    public int getMaxLen(int[] nums) {
        int result = 0;
        int countN = 0;
        int countP = 0;
        int first = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                countP++;
            } else if (nums[i] < 0) {
                countN++;
                first = first >= 0 ? first : i;
            } else {
                countP = 0;
                countN = 0;
                first = -1;
            }
            if (countN % 2 == 0) {
                result = Math.max(result, countN + countP);
            } else {
                result = Math.max(result, i - first);
            }
        }
        return result;
    }
}

// @lc code=end

