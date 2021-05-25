/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "").toLowerCase();
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j;) {
            if (!isLowCaseLetterOrNumber(ch[i])) {
                i = i + 1;
                continue;
            }
            if(!isLowCaseLetterOrNumber(ch[j])) {
                j = j -1;
                continue;
            }
            if (ch[i] != ch[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isLowCaseLetterOrNumber(char c) {
        if ((97 <= c && c <= 122) || (48 <= c && c <= 57)) {
            return true;
        }
        return false;
    }
}
// @lc code=end

