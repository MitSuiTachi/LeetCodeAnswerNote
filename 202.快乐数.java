/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    private Set<Integer> mSet = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (mSet.contains(n)) {
            return false;
        } else {
            mSet.add(n);
        }
        char[] chars = String.valueOf(n).toCharArray();
        int nextGen = 0;
        for (int i = 0; i < chars.length; i++) {
            nextGen = nextGen + (int) Math.pow(chars[i] - '0', 2);
        }
        return isHappy(nextGen);
    }
}
// @lc code=end

