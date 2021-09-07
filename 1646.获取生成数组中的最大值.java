/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    private int[] resultArray;
    private int result = 0;

    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        resultArray = new int[n + 1];
        resultArray[0] = 0;
        resultArray[1] = 1;
        constructArray(n);
        return result;
    }

    private void constructArray(int n) {
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = computeItem(i);
            resultArray[i] = temp;
            if (temp > result) {
                result = temp;
            }
        }
    }

    private int computeItem(int n) {
        if (n % 2 == 0) {
            return resultArray[n / 2];
        }
        int k = (n - 1) / 2;
        return resultArray[k] + resultArray[k + 1];
    }
}
// @lc code=end

