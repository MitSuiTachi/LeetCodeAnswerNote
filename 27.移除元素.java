/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    private int mResult = 0;
    public int removeElement(int[] nums, int val) {
        int currentHeadIndex = 0;
        int temp;
        boolean isEnd = false;
        while(!isEnd) {
            
            if(currentHeadIndex >= nums.length - 1) {
                isEnd = true;
            }
            for(int i = currentHeadIndex; i < nums.length; i++) {
                if(nums[i] != val) {
                    temp = nums[currentHeadIndex];
                    nums[currentHeadIndex] = nums[i];
                    nums[i] = temp;
                    mResult++;
                    currentHeadIndex++;
                    break;
                } else {
                    if (i == nums.length - 1){
                        isEnd = true;
                    }
                }
            }
        }
        return mResult;
    }
}
// @lc code=end

