/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start

class Solution {

    /**
     * 以下方法为自上到下的递归（动态规划）
     * 从待求值 n 逐步逼近递归出口，即 n = 1 和 n =0 的情况
     * 缺点：存在大量的重复计算，例如，在计算 trub(n - 1) 时也会重复计算 trub(n - 2)
     * 优化：利用一个数组存储已经计算过的 trub 值，在迭代计算的过程中先去数组中查询该位置是否存在值，存在即返回改值
     * 避免重复计算
     */
    int[] trubonaccis;

    public int tribonacci(int n) {
        if (trubonaccis == null) {
            trubonaccis = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                trubonaccis[i] = -1;
            }
        }
        if (n < 2) {
            trubonaccis[n] = n;
            return n;
        }
        if (n == 2) {
            trubonaccis[2] = 1;
            return 1;
        }
        if (trubonaccis[n] >= 0) {
            return trubonaccis[n];
        }
        trubonaccis[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return trubonaccis[n];
    }
}

//class Solution {
/**
 * 以下方法为利用滚动数组进行计算
 * pre, mid, back, result 分别对应泰波那契数列中的连续四项
 * 通过一次滚动完成 mid -> pre, back -> mid, result -> back 再求得下一个 result
 */
//    public int tribonacci(int n) {
//        if (n < 2) {
//            return n;
//        } else if (n == 2) {
//            return 1;
//        }
//        int pre = 0;
//        int mid = 1;
//        int back = 1;
//        int result = 0;
//        for (int i = 3; i < n + 1; i++) {
//            result = pre + mid + back;
//            pre = mid;
//            mid = back;
//            back = result;
//        }
//        return result;
//    }
//}

// @lc code=end

