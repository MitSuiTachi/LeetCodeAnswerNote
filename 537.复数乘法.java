/*
 * @lc app=leetcode.cn id=537 lang=java
 *
 * [537] 复数乘法
 */

// @lc code=start

/**
 * 将字符类型的复数拆解为实部和虚部，分别进行乘法计算，再将结果拼接成字符类型的负数
 */
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] nums1 = splitComplexNum(num1);
        int[] nums2 = splitComplexNum(num2);

        int real1 = nums1[0] * nums2[0];
        int real2 = nums1[1] * nums2[1];
        int real = real1 + (-real2);

        int image1 = nums1[0] * nums2[1];
        int image2 = nums2[0] * nums1[1];
        int image = image1 + image2;

        return String.valueOf(real) + "+" + String.valueOf(image) + "i";
    }

    /**
     * 将String类型的虚数拆解为int类型的实部和虚部
     * @param num
     * @return
     */
    private int[] splitComplexNum(String num) {
        int[] result = new int[2];
        String[] nums = num.split("\\+");
        result[0] = Integer.valueOf(nums[0]);
        result[1] = Integer.valueOf(nums[1].substring(0, nums[1].length() - 1));
        return result;
    }
}

// @lc code=end

