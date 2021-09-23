/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
/**
 * 解决思路
 * 用一组数组 mSums 记录 nums 的前缀和
 * 即 mSums[i] = nums[0] + nums[1] + ... + nums[i]
 * 那么对于任意的 Range[l, r]
 * 有 Range[l, r] = nums[l] + nums[l + 1] + ... + nums[r] = mSums[r] - mSums[l - 1]
 * 可以在构造函数中遍历一遍 nums[] 就可构造出 mSums[]
 * 后面计算 sumRange() 时，时间复杂度为 O(1)
 */
public class NumArray {
    private int[] mSums;

    public NumArray(int[] nums) {
        int currentSum = 0;
        mSums = new int[nums.length + 1];
        mSums[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            currentSum += nums[i - 1];
            mSums[i] = currentSum;
        }
    }

    public int sumRange(int left, int right) {
        return mSums[right + 1] - mSums[left];
    }
}
// class NumArray {
//     private int[] mNums;
//
//     public NumArray(int[] nums) {
//         mNums = new int[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             mNums[i] = nums[i];
//         }
//     }
/**
 * 头尾指针遍历 提高求和速度
 */
//     public int sumRange(int left, int right) {
//         if (right > mNums.length) {
//             return -1;
//         }
//         int result = 0;
//         while (left < right) {
//             result = result + mNums[left] + mNums[right];
//             left++;
//             right--;
//         }
//         if (left == right) {
//             result = result + mNums[left];
//         }
/**
 * 顺寻遍历
 */
// //        for (int i = left; i<=right;i++) {
// //            result = result + mNums[i];
// //        }
//         return result;
//     }
// }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

