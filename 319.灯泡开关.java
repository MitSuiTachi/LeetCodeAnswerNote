/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isSquareNum(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isSquareNum(int num) {
        double root;
        try {
           root = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        return root - (int)root == 0 ? true : false;
    }
}
// @lc code=end

