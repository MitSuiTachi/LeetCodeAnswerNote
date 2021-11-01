/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            result = result ^ sChars[i];
        }
        for (int i = 0; i < tChars.length; i++) {
            result = result ^ tChars[i];
        }

        return (char) result;
    }
}
// @lc code=end

