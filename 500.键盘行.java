/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    String line1 = "qwertyuiop";
    String line2 = "asdfghjkl";
    String line3 = "zxcvbnm";

    public String[] findWords(String[] words) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] tempArray = words[i].toLowerCase().toCharArray();
            if (judgeStructure(tempArray)) {
                resultList.add(words[i]);
            }
        }
        return (String[]) (resultList.toArray(new String[resultList.size()]));
    }

    private boolean judgeStructure(char[] chars) {
        int result;
        result = findLine(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (findLine(chars[i]) != result) {
                return false;
            }
        }
        return true;
    }

    private int findLine(char c) {
        if (line1.indexOf(c) >= 0) {
            return 1;
        } else if (line2.indexOf(c) >= 0) {
            return 2;
        } else {
            return 3;
        }
    }
}
// @lc code=end

