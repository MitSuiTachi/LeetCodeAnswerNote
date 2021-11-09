/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int index = 0;
        int length = s.length();
        String result = "";
        String temp;
        int flag = 1;
        while (index + k < length) {
            if (flag % 2 == 1) {
                temp = reverseSubStr(s.substring(index, index + k));
            } else {
                temp = s.substring(index, index + k);
            }
            result = result + temp;
            flag++;
            index += k;
        }
        if (flag % 2 == 1) {
            result = result + reverseSubStr(s.substring(index, length));
        } else {
            result = result + s.substring(index, length);
        }
        return result;
    }

    private String reverseSubStr(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        char temp;
        while (head < tail) {
            temp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = temp;
            head++;
            tail--;
        }
        return new String(chars);
    }
}
// @lc code=end

