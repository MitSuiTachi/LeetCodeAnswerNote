/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    /**
     * 解决思路是用键值对来解决 Map<K, V>
     * 例如 pattern = "abba", str = "dog cat cat dog"
     * 则 (Key = a, Value = d) (Key = b, Value = c)
     * 遍历到最后 如果所有的 Key 都唯一对应了一个 Value 则说明匹配成功
     * 否则 只要出现了一个 Key 对应了2个不同的 Value 则说明匹配失败
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        char[] keys = pattern.toCharArray();
        String[] values = s.split(" ");
        if (keys.length != values.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            if (!map.containsKey(Character.valueOf(keys[i]))) {
                if (map.containsValue(values[i])) {
                    return false;
                }
                map.put(Character.valueOf(keys[i]), values[i]);
            } else if (!map.get(Character.valueOf(keys[i])).equals(values[i])) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

