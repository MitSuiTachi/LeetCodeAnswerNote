/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * 遍历到0 则将0后面的数字往前挪一位 并用currentZero记录当前0的数量
 * 在挪的时候只需要挪动到 nums.length - currentZero 前即可
 * 相比较后一种方法 可以减少挪动的次数
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int currentZero = 0;
        int index = 0;
        while (index < nums.length - currentZero) {
            if (nums[index] == 0) {
                for (int i = index + 1; i < nums.length - currentZero; i++) {
                    nums[i - 1] = nums[i];
                }
                currentZero++;
                nums[nums.length - currentZero] = 0;
            } else {
                index++;
            }
        }
    }
}
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int currentZero = 0;
//         int index = 0;
//         while (index < nums.length - currentZero) {
//             if (nums[index] == 0) {
//                 currentZero++;
//                 for (int i = index + 1; i < nums.length; i++) {
//                     nums[i - 1] = nums[i];
//                 }
//                 nums[nums.length - currentZero] = 0;
//             } else {
//                 index++;
//             }
//         }
//     }
// }
// @lc code=end