/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start

class Solution {
    int[] originArray;
    int[] resultArray;

    public Solution(int[] nums) {
        originArray = nums;
        resultArray = Arrays.copyOf(originArray, originArray.length);
    }

    public int[] reset() {
        resultArray = Arrays.copyOf(originArray, originArray.length);
        return originArray;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < resultArray.length; i++) {
            int swap = i + random.nextInt(originArray.length - i);
            int temp = resultArray[swap];
            resultArray[swap] = resultArray[i];
            resultArray[i] = temp;
        }
        return resultArray;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

