/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    private int mResult = 1;

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int currentMaxIndex = 0;
        boolean isEnd = false;
        while (!isEnd) {
            for (int i = currentMaxIndex + 1; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    isEnd = true;
                }
                if (nums[i] > nums[currentMaxIndex]) {
                    nums[currentMaxIndex + 1] = nums[i];
                    mResult++;
                    break;
                }
            }
            currentMaxIndex = currentMaxIndex + 1;
            if (currentMaxIndex > nums.length) {
                isEnd = true;
            }
        }

        return mResult;
    }
}
// @lc code=end

