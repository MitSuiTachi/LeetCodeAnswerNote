/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] counts = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
// @lc code=end

