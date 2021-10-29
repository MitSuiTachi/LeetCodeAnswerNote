/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> kinds = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            if (!kinds.contains(candyType[i])) {
                kinds.add(candyType[i]);
            }
        }
        return kinds.size() > (candyType.length / 2) ? (candyType.length / 2) : kinds.size();
    }
}
// @lc code=end

