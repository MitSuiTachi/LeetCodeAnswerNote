/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    private Set<Integer> set = new HashSet<>();
    private int[] result;
    private Set<Integer> resultSet = new HashSet<>();

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        /** 要在长的set里面找短的set中的元素是否包含在其中
         *  因为HashSet可以在O(1)时间内找到是否重复
         *  因此查找的次数越少，时间开销越少
         */
        if (nums1.length > nums2.length) {
            constructSet(nums1);
            findSame(nums2);
        } else {
            constructSet(nums2);
            findSame(nums1);
        }
        int index = 0;
        result = new int[resultSet.size()];
        for (int num : resultSet) {
            result[index] = num;
            index++;
        }
        return result;
    }

    private void constructSet(int[] array) {
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
    }

    private void findSame(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                resultSet.add(array[i]);
            }
        }
    }
}
// @lc code=end

