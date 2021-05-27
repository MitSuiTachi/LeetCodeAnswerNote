/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
//        if(n < 5) {
//            return 0;
//        }
//        double num = 1;
//
//        while(n > 0) {
//            num = num * n;
//            n--;
//        }
//        int result = 0;
//        while (num % 10 == 0) {
//            num = num / 10;
//            result++;
//        }
//        return result;
        int result = 0;
        for(int i = 1; i <= n; i++){
            int j = i;
            while (j % 5 == 0) {
                result++;
                j = j / 5;
            }
        }
        return result;
    }
}
// @lc code=end

