/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int head = 0;
        int tail = 0;
        for (; tail < nums.length - 1; ) {
            if(nums[tail] + 1 != nums[tail + 1]) {
                if (tail == head) {
                    result.add(nums[head] + "");
                } else {
                    result.add(nums[head] + "->" + nums[tail]);
                }
                tail = tail + 1;
                head = tail;
            } else {
                tail++;
            }
        }
        
        if (head != tail) {
            result.add(nums[head] + "->" + nums[tail]);
        }
        if (head == nums.length - 1) {
            result.add(nums[head] + "");
        }
        return result;
    }
}
// @lc code=end

