/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                tempArray[k] = nums1[i];
                i++;
            } else {
                tempArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i == m) {
            while (j < n) {
                tempArray[k] = nums2[j];
                j++;
                k++;
            }
        }
        if(j == n) {
            while(i < m) {
                tempArray[k] = nums1[i];
                i++;
                k++;
            }
        }
        for(k = k - 1;k > -1; k--) {
            nums1[k] = tempArray[k];
        }
    }
}
// @lc code=end

