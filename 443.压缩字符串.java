// LeetCode链接：https://leetcode-cn.com/problems/string-compression/
class Solution {
    public int compress(char[] chars) {
// 题目要求在原数组上进行修改 以下方法返回了新数组 故答案是错误的
//        String resultString = "";
//        int index = 0;
//        int count = 0;
//        char currentLetter;
//        while (index < chars.length) {
//            currentLetter = chars[index];
//            while (index < chars.length && chars[index] == currentLetter) {
//                count ++;
//                index ++;
//            }
//            if (count == 1) {
//                resultString = resultString + String.valueOf(currentLetter);
//            } else {
//                resultString = resultString + String.valueOf(currentLetter) + String.valueOf(count);
//            }
//            count = 0;
//        }
//        return resultString.toCharArray().length;
        // 解题思路为采用双指针便利原数组 在原数组的基础上进行修改
        int length = chars.length;
        // left和right为双指针 left指向新字母的开始 right通过遍历走到下一个新字母所在的位置
        int left = 0;
        int right = 0;
        // 因为要在原数组基础上进行修改 index用于记录当前需要写入的位置
        int index = 0;
        while (right < length) {
            // right通过遍历找到下一个新字母的位置 此处判断条件一定要要用right < length截断与 不然会出现边界问题
            while (right < length && chars[left] == chars[right]) {
                right++;
            }
            // right和left的差值即为当前left所指向字母的重复个数
            if (right - left == 1) {
                // 两个指针同时指向新的字母开始位置 即right所在位置
                left = right;
                // 只有一个字母 不需要写入数量 直接在index位置写入即可
                chars[index] = chars[right - 1];
                // index指向下一个写入位置
                index++;
            } else {
                // 这部分和if中部分相同 可以提到if前面
                chars[index] = chars[right - 1];
                // 当前字母已经写入到index位置了 index向后移动一位 准备写入数量
                index++;
                int count = right - left;
                // 计算重复字母数量的位数
                int bits = String.valueOf(count).length();
                for (int i = 0; i < bits; i++) {
                    // 逐步将数量的每一位写入到index上 同时index向后移动一位 指向下一个要写入的位置
                    chars[index++] = String.valueOf(count).charAt(i);
                }
                // 同if中的逻辑
                left = right;
            }
        }
        // index即为压缩后的数组长度
        return index;
    }
}
