/*
 * @lc app=leetcode.cn id=1791 lang=java
 *
 * [1791] 找出星型图的中心节点
 */

// @lc code=start

// 统计每个节点的度，度为节点数量减1的节点即为中心节点
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == map.keySet().size() - 1) {
                return i;
            }
        }
        return -1;
    }
}

// 由于题目保证输入的边集为星型图的边集，在星型图中，只有中心节点会在边集中出现超过1次
// 因为其他节点的度都为1
// 因此对于边(edges[0][0], edges[0][1])和(edges[1][0], edges[1][1])，而言重复的节点即为中心节点
class Solution_2 {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] ? edges[0][0] : edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}

// @lc code=end

