/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start

class Solution {
    // 本题的解题思路是，对于任意的多米诺骨牌序列而言，可能会倒下的多米诺骨牌只能是竖立的，也就是只有'.'可能会变为'R'或者'L'
    // 那么对于任意的连续'.'序列而言（单独的'.'可以视为数量为1的连续序列），其最终状态只和它左右两侧距离它最近的非竖立牌相关，即 R(L)....R(L)
    // 因此对于任意的连续'.'序列，我们只需要找到它左右两侧距离它最近的非竖立牌，即可模拟推出这一段'.'序列的最终状态
    // 因为可能存在"...XXXXX..."这样的序列，对于首尾两端，无法找到R(L)....R(L)这样的结构，我们采用手动对其补上边界的方式，如下，
    // "...XXXXX..." -> "L...XXXXX...R" 这样对于前端"L...X"和后端"X...R"而言，并不会改变中间'.'的最终状态
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        // 为初始序列手动增加边界
        char[] chs = ("L" + dominoes + "R").toCharArray();
        char[] res = new char[len];
        // 由于手动增加了边界，因此从位置1开始遍历，1 <= front <= n，此处注意转换到 [0, n - 1]
        int front = 1;
        int back;
        char right, left;
        while (front <= len) {
            // 利用back找到从front开始第一个不为'.'的位置
            // 则在[front, back)之间为连续的'.'
            back = front;
            while (back <= len && chs[back] == '.') {
                back++;
            }
            // 如果front == back，只有一种可能，chs[front] != '.'
            if (front == back) {
                // 对于这种情况，chs[front]当前值即为最终值，注意位置对齐 chs[front] 对应位置为 res[front - 1]
                res[front - 1] = chs[front];
                // 继续遍历后一个位置
                front++;
            } else {
                // 如果front != back，也只有一种可能，chs[front], ..., chs[back - 1]均为'.'
                // 对这一段连续的 '.' 而言，左右边界分别为 chs[front - 1] 和 chs[back]
                left = chs[front - 1];
                right = chs[back];
                // 如果左右边界相等，即"R...R"或者"L....L"的情况，则中间这段'.'的最终状态就是边界的状态，即，
                // "R...R" -> "RRRRR", "L...L" -> "LLLLL"
                if (left == right) {
                    // 注意位置对齐
                    for (int i = front - 1; i < back - 1; i++) {
                        res[i] = left;
                    }
                } else if (left == 'R' && right == 'L') {
                    // 只有当左边界是向右倒，右边界向左倒时，中间位置可能存在最终为'.'的情况
                    // 此处可能存在两种情况，即连续'.'的数量为奇数或者偶数
                    // "R...L" -> "RR.LL", "R....L" -> "RRRLLL"
                    // 奇数：[front,...,back - 1]，利用双指针分别从前往后和从后往前走（每次一步），最终双指针会相遇，且相遇位置最终状态为'.'
                    // 对应while出口 tempB == tempF
                    // 偶数：[front,....,back - 1]，利用双指针分别从前往后和从后往前走（每次一步），最终双指针会错开，
                    // 对应while出口 tempB < tempF
                    int tempB = back - 2;
                    int tempF = front - 1;
                    while (tempB > tempF) {
                        res[tempB--] = 'L';
                        res[tempF++] = 'R';
                    }
                    if (tempB == tempF) {
                        res[tempB] = '.';
                    }
                } else {
                    // 这里只剩下一种情况"L...R"
                    // 中间位置最终状态只可能为'.'
                    for (int i = front - 1; i < back - 1; i++) {
                        res[i] = '.';
                    }
                }
                // 下一轮循环从back开始，也就是连续'.'位置后的第一个非'.'位置
                // 这会保证每段序列均会有个非'.'的左侧
                front = back;
            }
        }
        return new String(res);
    }
    /**
     * 写完这题回头看代码，其实解题思路比较简单，就是一个单纯的模拟，
     * 写完觉得代码挺丑陋的，充满了边界判断和位置对齐（其实位置对齐可以通过在原数组上操作进行优化），可能比较考验代码功底吧 0-0
     * 虽然代码丑陋，不过写完还是有80%多的runtime击败率的
     * 比较巧妙点在于，1.手动添加边界 2.奇数和偶数的连续'.'对应了while循环的不同出口
     * 官方题解的BFS我是没看懂的，还需要多想想
     * 写于 2022年2月22日
     */
}

// @lc code=end

