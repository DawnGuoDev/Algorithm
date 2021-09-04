package Top200;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp 数组定义
        int[] dp = new int[target + 1];

        // dp 数组初始化
        dp[0] = 1;

        // dp 迭代
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
