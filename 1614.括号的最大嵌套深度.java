/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start

/**
 * 由于题目保证提供的字符串 s 为有效括号字符串，因此能够保证 "(" 和 ")" 为成对出现的
 * 因此可以利用一个变量记录 "(" 的数量，每遇到一个 "(" 就说明多了一层嵌套，每遇到一个 ")" 就说明有一对 "()" 结束，说明少了一层嵌套
 * 在遍历的过程中对嵌套数进行统计，并记录其最大值，即为所得。
 */
class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > max) {
                    max = count;
                }
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return max;
    }
}

// @lc code=end

