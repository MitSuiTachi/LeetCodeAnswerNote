/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int squareRoot = (int) Math.sqrt(area);
        for (int i = squareRoot; i < area; ) {
            if (area % i == 0) {
                result[0] = (area / i) > i ? area / i : i;
                result[1] = area / result[0];
                return result;
            }
            i++;
        }
        result[0] = area;
        result[1] = 1;
        return result;
    }
}
// @lc code=end

