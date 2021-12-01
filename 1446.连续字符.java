/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start

// class Solution {
//     public int maxPower(String s) {
//         int maxLength = 0;
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (stack.isEmpty() || stack.peek() == s.charAt(i)) {
//                 stack.push(s.charAt(i));
//             } else {
//                 maxLength = maxLength > stack.size() ? maxLength : stack.size();
//                 stack.clear();
//                 stack.push(s.charAt(i));
//             }
//         }
//         return maxLength > stack.size() ? maxLength : stack.size();
//     }
// }

public class Solution {
    public int maxPower(String s) {
        int result = 0;
        for (int i = 0; i< s.length();) {
            int j = i;
            int currentLength = 0;
            char currentChar = s.charAt(i);
            while (j < s.length() && s.charAt(j) == currentChar) {
                j++;
                currentLength++;
            }
            result = result > currentLength ? result : currentLength;
            i = j;
        }
        return result;
    }
}
// @lc code=end

