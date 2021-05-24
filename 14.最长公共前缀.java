/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    String mResult = "";
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return mResult;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || currentChar != strs[j].charAt(i)) {
                    return mResult;
                }
            }
            mResult = mResult + currentChar;
        }
        return mResult;
    }
}
// @lc code=end

