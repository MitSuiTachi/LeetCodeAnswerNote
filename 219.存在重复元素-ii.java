/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start

// 利用 set 来查重，并利用 head 记录距离当前位置为 k 的元素下标，从前往后滑动遍历
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            // 一旦 i > k，每往 set 中插入一个元素，就要将 nums[head] 从 set中移除，且 head++
            // 保证 set 中只存储距离当前位置距离小于等于 k 的元素
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[head]);
                head++;
            }
        }
        return false;
    }
}

// @lc code=end

