/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start

/**
 * 循环遍历，当循环到一个 '?' 时，通过其前后元素（不存在就传-1和1），重新生成一个字符替换它
 */
class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                chars[i] = findChar(i - 1 > -1 ? chars[i - 1] : -1, i + 1 < s.length() ? chars[i + 1] : 1);
            }
        }
        return String.valueOf(chars);
    }

    private char findChar(int front, int behind) {
        char ch = (char) ((int) (Math.random() * 26) + 'a');
        while (ch == front || ch == behind) {
            ch = (char) ((int) (Math.random() * 26) + 'a');
        }
        return ch;
    }
}

// @lc code=end

