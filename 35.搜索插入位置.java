/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if(nums[i] > target) {
                return i;
            }
            if(i == nums.length - 1) {
                return nums.length;
            }
        }
        return 0;
    }
}
// @lc code=end

