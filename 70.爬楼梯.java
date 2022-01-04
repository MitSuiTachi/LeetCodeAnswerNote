/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start

/**
 * 对于第 n 级台阶，只能是从第 n - 1 级或者第 n - 2 级台阶直接到达
 * 因此只要找到有多少种到达第 n - 1 级和到达第 n - 2 级台阶的方案即可推出到达第 n 级台阶的方案
 * 即存在 f(n) = f(n - 1) + f(n - 2)
 * 下列方法在初始化过程中就将前100个台阶的答案均记载在其中，对于问题集大小固定或者可推断并且查找频繁的问题具有较好的查找效率
 * 不过扩展能力基本为0,当问题集数量超出此范围（[0, 100]）不具备求解能力
 */
//class Solution {
//    private static int[] fbArray = new int[100];
//    static {
//        fbArray[0] = 1;
//        fbArray[1] = 2;
//        for (int i = 2; i < 100; i++) {
//            fbArray[i] = fbArray[i - 1] + fbArray[i - 2];
//        }
//    }
//    public int climbStairs(int n) {
//        return fbArray[n - 1];
//    }
//}

/**
 * 利用动态规划将问题分解成子问题，对子问题进行相同处理，直到找到递归出口
 * 以下方法在LeetCode提交中会超时，同之前LeetCode509和LeetCode1137一样，在递归的过程中存在大量的重复计算
 * 例，在计算 climbStairs(n - 1) 时会再计算一次 climbStairs(n - 2)
 * 可以利用记忆话搜索改进
 */
//class Solution {
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//
//        if (n == 2) {
//            return 2;
//        }
//
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
//}

/**
 * 利用记忆话搜索改进
 * 45/45 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 74.73 % of java submissions (35 MB)
 */
class Solution {
    int[] stepsForNStairs;

    public int climbStairs(int n) {
        if (stepsForNStairs == null) {
            stepsForNStairs = new int[n + 1];
        }
        if (n < 3) {
            stepsForNStairs[n] = n;
            return stepsForNStairs[n];
        }
        if (stepsForNStairs[n] != 0) {
            return stepsForNStairs[n];
        }
        stepsForNStairs[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return stepsForNStairs[n];
    }
}

/**
 * 从下至上递推出所求解
 * 45/45 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 45.89 % of java submissions (35.2 MB)
 */
//class Solution {
//    public int climbStairs(int n) {
//        if (n < 3) {
//            return n;
//        }
//        int pre = 1;
//        int back = 2;
//        int result = 0;
//        for (int i = 3; i < n + 1; i++) {
//            result = pre + back;
//            pre = back;
//            back = result;
//        }
//        return result;
//    }
//}

// @lc code=end

