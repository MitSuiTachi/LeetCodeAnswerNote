/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    /*
        由于题目保证了输入字符串中 'L' 和 'R' 的数量是相等的
        因此可以采用栈的方式实现 每次栈空都意味着出现了一个平衡字符串 且构成该平衡字符串的字符数量是最少的
     */
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        char firstChar = chars[0];
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == firstChar) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result++;
                if (i != chars.length - 1) {
                    // 每次栈空都要记录一下下次入栈的字符
                    firstChar = chars[i + 1];
                }
            }
        }
        return result;
    }
}
// @lc code=end

