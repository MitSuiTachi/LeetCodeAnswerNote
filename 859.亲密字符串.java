/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null || (s.length() != goal.length())) {
            return false;
        }
        int count = 0;
        int firstIndex = 0;
        int nextIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (count == 0) {
                    firstIndex = i;
                    count++;
                } else if (count == 1) {
                    nextIndex = i;
                    count++;
                } else {
                    return false;
                }
            }
        }
        if (count == 0) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    return true;
                }
                set.add(s.charAt(i));
            }
            return false;
        }
        if (s.charAt(firstIndex) == goal.charAt(nextIndex) && s.charAt(nextIndex) == goal.charAt(firstIndex)) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

