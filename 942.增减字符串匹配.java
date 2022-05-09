/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start

// 字符'I'代表一个小于下一位的数字，字符'D'代表一个大于下一位的数字
// 因此每当遇到一个'I'时，我们从[0, n]区间的“前部”取一个数；每当遇到一个'D'时，我们从区间的“后部”取一个数；
// 具体解决办法就是申明两个指针pre（代表区间的“前部”）和post（代表区间的“后部”），pre从前往后遍历区间，post从后往前遍历区间
// 遇到'I'则填入pre所指向的数（不管下一位是'I'或是'D',一定大于当前的数），同理，遇到'D'则填入post所指向的数

// Solution_2在Solution的基础上做了部分优化，提高了运行速度

class Solution {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int pre = 0;
        int post = s.length();
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = pre;
                pre++;
            }
            if (s.charAt(i) == 'D') {
                res[i] = post;
                post--;
            }
        }
        res[i] = post;
        return res;
    }
}

class Solution_2 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int pre = 0;
        int post = s.length();
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) == 'I' ? pre++ : post--;
        }
        res[res.length - 1] = post;
        return res;
    }
}

// @lc code=end

