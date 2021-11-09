/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic_2(s, t) && isIsomorphic_2(t, s);
    }

    private boolean isIsomorphic_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                if (map.get(sChars[i]) != sChars[i] - tChars[i]) {
                    return false;
                }
            }
            map.put(sChars[i], sChars[i] - tChars[i]);
        }
        return true;
    }
}
// @lc code=end

