/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    private int result[] =  new int[2];

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i< nums.length; i++) {
            result[0] = i;
            int targetPart = target - nums[i];
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] == targetPart){
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}
// @lc code=end

