/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start

/**
 * 双指针遍历，pre 从前往后遍历找字母，back 从后往前遍历找字母
 * 交换 pre 和 back 所指向的字母
 */
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] res = s.toCharArray();
        int len = res.length;
        int pre = 0;
        int back = len - 1;
        char temp;
        while (pre < back) {
            while (pre < len && !isLetter(res[pre])) {
                pre++;
            }
            while (back > -1 && !isLetter(res[back])) {
                back--;
            }
            if (pre < back) {
                temp = res[back];
                res[back] = res[pre];
                res[pre] = temp;
                pre++;
                back--;
            }
        }
        return new String(res);
    }

    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}

// @lc code=end

