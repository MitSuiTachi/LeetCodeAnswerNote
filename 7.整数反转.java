/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
import java.util.Stack;

class Solution {
    private double mResult = 0;
    private boolean isNegative = false;
    public int reverse(int x) {
        if(x < 0) {
            isNegative = true;
            if(x < Integer.MIN_VALUE) {
                return 0;
            }
        }
        if(x > Integer.MAX_VALUE) {
            return 0;
        }
        int[] tempInt = intToArray(x);
        Stack tempStack = new Stack();
        int i = 0;
        for(; i < tempInt.length; i++){
            tempStack.push(new Integer(tempInt[i]));
        }
        for(; i > 0; i--){
            mResult = mResult + ((Integer)tempStack.pop()).intValue() * Math.pow(10, i - 1);
        }
        if(isOutOfBound(mResult)) {
            return 0;
        }

        if(isNegative){
            return 0 - (int)mResult;
        }

        return (int)mResult;
    }

    private int[] intToArray(int x) {
        if(x < 0) {
            x = 0 - x;
        }
        String str = String.valueOf(x);
        int[] result = new int[str.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }

    private boolean isOutOfBound(double i) {
        if((double)(int)i == i) {
            return false;
        }
        return true;
    }
}
// @lc code=end

