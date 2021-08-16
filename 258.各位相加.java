/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        char[] ch = String.valueOf(num).toCharArray();
        int result = 0;
        for (int i = 0; i < ch.length; i++) {
            result = result + (ch[i] - '0');
        }
        return addDigits(result);
    }
}
// @lc code=end

