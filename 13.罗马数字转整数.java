/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    private int mResult = 0;
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length;) {
            if ( i + 1 < ch.length) {
                if(isNeedMove2(ch[i], ch[i + 1])) {
                    i = i + 2;
                }
                else {
                    i++;
                }
            } else {
                mResult = mResult + chToInt(ch[i]);
                i++;
            }
        }
        return mResult;
    }

    private boolean isNeedMove2(char c1, char c2) {
        if(chToInt(c1) < chToInt(c2)) {
            mResult = mResult + chToInt(c2) - chToInt(c1);
            return true;
        } else {
            mResult = mResult + chToInt(c1);
            return false;
        }
    }

    private int chToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
// @lc code=end

