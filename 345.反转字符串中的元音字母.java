/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
import java.util.Locale;

class Solution {
    public String reverseVowels(String s) {
        char[] judgeChars = s.toLowerCase().toCharArray();
        char[] chars = s.toCharArray();
        char temp;
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            while (!isVowel(judgeChars[head]) && head < tail) {
                head ++;
            }
            while (!isVowel(judgeChars[tail]) && head < tail) {
                tail --;
            }
            temp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = temp;
            head ++;
            tail --;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
// @lc code=end

