/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            if(set.contains(s)) {
                return true;
            }
            set.add(s);
        }
        return false;
    }
}
// @lc code=end

