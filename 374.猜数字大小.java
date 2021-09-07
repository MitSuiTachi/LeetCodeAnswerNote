/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int middle = (high - low) / 2 + low;
            if (guess(middle) == 0) {
                return middle;
            }
            if (guess(middle) == 1) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return high;
    }
}
// @lc code=end

