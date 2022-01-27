/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start

class Solution {
    public int maxProduct(int[] nums) {
        // 记录第一个负数的下标
        int firstNegativeIndex = -1;
        // 记录当前负数数量
        int countOfNegatives = 0;
        // 记录当前的连续乘积
        int[] currentProduct = new int[nums.length];
        int temp = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < currentProduct.length; i++) {
            temp = temp * nums[i];
            currentProduct[i] = temp;
            if (nums[i] < 0) {
                countOfNegatives++;
                if (firstNegativeIndex < 0) {
                    firstNegativeIndex = i;
                }
            }
            if (nums[i] == 0) {
                temp = 1;
                firstNegativeIndex = -1;
                countOfNegatives = 0;
            }
            if (countOfNegatives % 2 == 0) {
                result = Math.max(result, currentProduct[i]);
            } else {
                result = Math.max(result, i == firstNegativeIndex ? currentProduct[i] : currentProduct[i] / currentProduct[firstNegativeIndex]);
            }
        }
        return result;
    }
}

// @lc code=end

