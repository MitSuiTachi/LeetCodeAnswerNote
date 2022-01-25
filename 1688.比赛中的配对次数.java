/*
 * @lc app=leetcode.cn id=1688 lang=java
 *
 * [1688] 比赛中的配对次数
 */

// @lc code=start

/**
 * 模拟比赛场数
 */
class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            count += n / 2;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n - 1) / 2 + 1;
            }
        }
        return count;
    }
}

/**
 * 不管有多少支队伍参赛，最后只有一支队伍获奖，每经历一场比赛就会淘汰一支队伍，因此为了决出唯一一支获奖队伍，需要淘汰 n - 1 支队伍
 * 因此需要 n - 1 场比赛
 */
class Solution_2 {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}

// @lc code=end

