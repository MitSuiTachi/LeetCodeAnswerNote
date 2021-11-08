/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    /**
     * 本解法要求 secret 的长度和 guess 的长度相等
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        char[] sChars = secret.toCharArray();
        char[] gChars = guess.toCharArray();
        // A for Bulls
        int A = 0;
        // B for Cows;
        int B = 0;
        int[] countS = new int[10];
        int[] countG = new int[10];
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == gChars[i]) {
                A++;
            } else {
                countS[sChars[i] - '0']++;
                countG[gChars[i] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (countG[i] != 0 && countS[i] != 0) {
                B = B + Math.min(countG[i], countS[i]);
            }
        }
        return String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }
}
// @lc code=end

