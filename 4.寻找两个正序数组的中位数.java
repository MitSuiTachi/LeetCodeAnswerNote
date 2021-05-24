/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private double mResult;
    private List list = new ArrayList<Integer>();
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                addIntoList(nums1[i]);
                i++;
            } else {
                addIntoList(nums2[j]);
                j++;
            }
        }
        if(i == nums1.length) {
            for(; j < nums2.length ; j++) {
                addIntoList(nums2[j]);
            }
        } else {
            for(; i < nums1.length ; i++) {
                addIntoList(nums1[i]);
            }
        }
        if(list.size() % 2 == 0) {
            mResult = (((Integer)list.get(list.size()/2)).doubleValue() + ((Integer)list.get(list.size()/2 - 1)).doubleValue()) / 2;
            return mResult;
        } else {
            mResult = ((Integer)list.get((list.size() + 1) / 2 - 1)).doubleValue() / 1;
            return mResult;
        }
    }

    private void addIntoList(int temp) {
        // if(!list.contains(temp)){
        //     list.add(temp);
        // }
        list.add(temp);
    }
}
