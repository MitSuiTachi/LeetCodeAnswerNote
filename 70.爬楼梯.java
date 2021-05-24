/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    private static int[] fbArray = new int[100];
    static {
        fbArray[0] = 1;
        fbArray[1] = 2;
        for (int i = 2; i < 100; i++) {
            fbArray[i] = fbArray[i - 1] + fbArray[i - 2];
        }
    }
    public int climbStairs(int n) {
        return fbArray[n - 1];
    }
}
// @lc code=end

