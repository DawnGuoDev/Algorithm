package Top200;

class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S > sum) {
            return 0;
        }
        
        if ((sum + S) % 2 == 1) {
            return 0;
        }

        int target = (sum + S) >> 1;
        // dp 数组定义
        int[] dp = new int[target + 1];     // dp[i] 表示加和为 i 的种数

        // 初始化
        dp[0] = 1;

        // dp 迭代
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
