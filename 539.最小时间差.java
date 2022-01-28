/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start

/**
 * 对于一个时间序列来说，时间差最小的两个时间点一定是相邻的（距离0点最近的时间点和距离0点最远的时间点也可以被视作响铃的时间）
 * 可以将 HH:MM 的24小时制时间转换为距离0点过去了多少分钟，再进行排序，遍历一次排序后的时间序列，并求相邻时间点的时间差，其最小值即为所求
 */
class Solution {
    private static final int TOTAL_MINS = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > TOTAL_MINS) {
            return 0;
        }
        int[] from24 = new int[timePoints.size()];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            from24[i] = getMinFrom24(timePoints.get(i));
        }
        // 排序
        Arrays.sort(from24);
        for (int i = 1; i < from24.length; i++) {
            min = Math.min(min, from24[i] - from24[i - 1]);
        }
        min = Math.min(min, from24[0] + TOTAL_MINS - from24[from24.length - 1]);
        return min;
    }

    /**
     * 计算字符串 s 所代表的时间点距离0点所过去的分钟数目
     */
    private int getMinFrom24(String s) {
        String[] times = s.split(":");
        int hour = Integer.valueOf(times[0]);
        int min = Integer.valueOf(times[1]);
        return hour * 60 + min;
    }
}

// @lc code=end

