/*
 * @lc app=leetcode.cn id=1816 lang=java
 *
 * [1816] 截断句子
 */

// @lc code=start
class Solution {
    public String truncateSentence(String s, int k) {
//        String[] words = s.split(" ");
//        String result = "";
//        if (k >= words.length) {
//            return s;
//        } else {
//            int i = 0;
//            while (i < k) {
//                result += words[i];
//                i++;
//            }
//        }
//        return result.trim();
        int countBlank = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countBlank++;
                if (countBlank == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
}
// @lc code=end

