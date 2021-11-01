/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        int countU = 0;
        int countD = 0;
        int countL = 0;
        int countR = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'U') {
                countU++;
            }
            if (chars[i] == 'D') {
                countD++;
            }
            if (chars[i] == 'L') {
                countL++;
            }
            if (chars[i] == 'R') {
                countR++;
            }
        }
        return (countU == countD) && (countL == countR);
    }
}
// @lc code=end

