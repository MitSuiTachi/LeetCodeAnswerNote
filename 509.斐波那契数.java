/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

class Solution {
    /**
     * 以下方法为自上到下的递归（动态规划）
     * 从待求值 n 逐步逼近递归出口，即 n = 1 和 n =0 的情况
     * 缺点：存在大量的重复计算，例如，在计算 fib(n - 1) 时也会重复计算 fib(n - 2)
     * 优化：利用一个数组存储已经计算过的 fib 值，在迭代计算的过程中先去数组中查询该位置是否存在值，存在即返回改值
     */
    int[] fibs;

    public int fib(int n) {
        if (fibs == null) {
            fibs = new int[n + 1];
        }
        if (n == 0) {
            fibs[0] = 0;
            return fibs[0];
        }
        if (n == 1) {
            fibs[1] = 1;
            return fibs[1];
        }
        if (fibs[n] > 0) {
            return fibs[n];
        }
        fibs[n] = fib(n - 1) + fib(n - 2);
        return fibs[n];
    }
}

///**
// * 以下方法为利用滚动数组后的优化方案
// * pre, back, result 分别对应斐波那契数列中的连续三项
// * 通过一次滚动完成 back -> pre, result -> back, 在求得下一个 result
// */
//class Solution {
//    public int fib(int n) {
//        if (n < 2) {
//            return n;
//        }
//        int pre = 0;
//        int back = 1;
//        int result = 0;
//        for (int i = 1; i < n; i++) {
//            result = pre + back;
//            pre = back;
//            back = result;
//        }
//        return result;
//    }
//}
// @lc code=end

