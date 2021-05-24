/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    private boolean mResult;
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack stack = new Stack();
        for(int i = 0; i < ch.length; i++) {
            if(isLeft(ch[i])) {
                stack.push(ch[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (!checkIsPair((char)stack.peek(), ch[i])) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    private boolean isLeft(char c) {
        if(c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    private boolean checkIsPair(char c1, char c2) {
        if((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
            return true;
        }
        return false;
    }
}
// @lc code=end

