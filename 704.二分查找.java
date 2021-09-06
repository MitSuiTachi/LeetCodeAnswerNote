/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int middle = (high - low) / 2 + low;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return -1;
    }
}
// @lc code=end

