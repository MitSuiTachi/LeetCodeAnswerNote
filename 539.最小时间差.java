/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start

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
        Arrays.sort(from24);
        for (int i = 1; i < from24.length; i++) {
            min = Math.min(min, from24[i] - from24[i - 1]);
        }
        min = Math.min(min, from24[0] + TOTAL_MINS - from24[from24.length - 1]);
        return min;
    }
    private int getMinFrom24(String s) {
        String[] times = s.split(":");
        int hour = Integer.valueOf(times[0]);
        int min = Integer.valueOf(times[1]);
        return hour * 60 + min;
    }
}

// @lc code=end

