/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start

//row = 4
//0     6       12
//1   5 7    11
//2 4   8 10
//3     9
// 如上，我们以row = 4为例，对待构建字符串的下标（索引值）进行构建，所完成的Z型图由4行组成，第一列有row = 4个元素，从第一完整列到第二完整列中有 (row = 4) - 2个元素
// 因此对于任意的row = n而言，它的周期为 n + (n - 2) = 2n - 2，即一个完整列的开头（例中的0元素）到下一个完整列的开头（例中的6元素）之间，
// 一共隔了2n - 2个元素，即对于第一行而言，它的每个元素所在的下标（索引值），均为2n - 2的整数倍，即index % (2n - 2) == 0
// 同理第二行中每个元素所在的下标（索引值）对2n - 2取余，有，index % (2n - 2) == 1 || index % (2n - 2) == 2n - 1
// 第n行中每个元素所在的下标（索引值）对2n - 2取余，有，index % (2n - 2) == n - 1
// 根据此规律，我们可以推出待构建字符串中每个字符在构建完成后的Z型图中所在行数，我们将每行存储在独立的字符串中，最后对其进行拼接即可
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] results = new String[numRows];
        for (int i = 0; i < results.length; i++) {
            results[i] = "";
        }
        char[] chars = s.toCharArray();
        int modNum;
        int cycleSize = 2 * numRows - 2;
        int middele = numRows - 1;
        for (int i = 0; i < chars.length; i++) {
            modNum = i % cycleSize;
            if (modNum == 0) {
                results[0] += chars[i];
            } else if (modNum == middele) {
                results[numRows - 1] += chars[i];
            } else {
                if (modNum > middele) {
                    results[cycleSize - modNum] += chars[i];
                } else {
                    results[modNum] += chars[i];
                }
            }
        }
        String result = "";
        for (int i = 0; i < results.length; i++) {
            result += results[i];
        }
        return result;
    }
}

// @lc code=end

