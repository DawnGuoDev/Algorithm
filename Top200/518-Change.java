package Top200;

class Solution {
    public int change(int amount, int[] coins) {
        // dp 数组定义，dp[i] 表示数量为 i 的种数
        int[] dp = new int[amount + 1];

        // dp 数组初始化
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                    dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
