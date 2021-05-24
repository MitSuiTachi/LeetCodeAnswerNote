/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    private boolean mResult;
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        return isPalindrome(s);
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
        return true;
    }
}
// @lc code=end

