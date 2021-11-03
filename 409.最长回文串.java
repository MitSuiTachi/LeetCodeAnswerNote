/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[52];
        int result = 0;
        boolean hasOdd = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a') {
                counts[26 + chars[i] - 'a']++;
            } else {
                counts[chars[i] - 'A']++;
            }
        }
        for (int i = 0; i < 52; i++) {
            if (counts[i] != 0) {
                if (counts[i] % 2 == 0) {
                    result = result + counts[i];
                } else {
                    if (!hasOdd) {
                        hasOdd = !hasOdd;
                    }
                    result = result + counts[i] - 1;
                }
            }
        }
        return hasOdd ? result + 1 : result;
    }
}
// @lc code=end

