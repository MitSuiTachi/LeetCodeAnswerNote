/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    private boolean isNeedUp = false;
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for(; i > -1; i--) {
            if(i == digits.length - 1 || isNeedUp) {
                digits[i]++;
                if(digits[i] >= 10) {
                    digits[i] -= 10;
                    isNeedUp = true;
                }else {
                    isNeedUp = false;
                }
            }
            if(!isNeedUp && i != 0) {
                return digits;
            }
        }
        if(!isNeedUp) {
            return digits;
        }else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                result[j + 1] = digits[j];
            }
            return result;
        }
    }
}
// @lc code=end

