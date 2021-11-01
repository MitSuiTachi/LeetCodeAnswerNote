/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    /**
     * 判断字符串s是否为字符串t的子序列
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length == 0) {
            return true;
        }
        int currentIndex = 0;
        char currentChar = sChars[currentIndex];
        for (int i = 0; i < tChars.length; i++) {
            if (currentChar == tChars[i]) {
                if (currentIndex == sChars.length - 1) {
                    return true;
                }
                currentChar = sChars[++currentIndex];
            }
        }
        return false;
    }
}
// @lc code=end

