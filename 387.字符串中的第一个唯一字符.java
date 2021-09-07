/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for(int i = 0; i < s.length();i++) {
            chars[s.charAt(i) - 'a']++;
        }
        int result = 0;
        while (result < s.length() && chars[s.charAt(result) - 'a'] != 1) {
            result++;
        }
        if (result == s.length()) {
            return -1;
        }
        return result;
    }
}
// @lc code=end

