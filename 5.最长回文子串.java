/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    private String mResult = "";

    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length(); j > i; j--) {
                isPalindrome(s.substring(i, j));
            }
        }
        return mResult;
    }

    private boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int startIndex = 0;
        int endIndex = ch.length - 1;
        for (;startIndex < endIndex; startIndex++,endIndex--) {
            if(!(ch[startIndex] == ch[endIndex])) {
                return false;
            }
        }
        if(s.length() > mResult.length()) {
            mResult = s;
        }
        return true;
    }
}
// @lc code=end

