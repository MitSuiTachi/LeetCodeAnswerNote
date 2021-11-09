/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        char[] ch = s.toCharArray();
        int totalA = 0;
        int continueL = 0;
        for (int i = 0; i < ch.length && (totalA < 2) && (continueL < 3); i++) {
            if (ch[i] == 'L') {
                continueL ++;
            } else if (ch[i] == 'A') {
                totalA ++;
                continueL = 0;
            } else {
                continueL = 0;
            }
        };
        if (totalA == 2 || continueL == 3) {
            return false;
        }
        return true;
    }
}
// @lc code=end

