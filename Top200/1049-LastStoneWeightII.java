package Top200;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        // 其实就是转换为类似等和子集的情况，就是竟然把石头分成相等的两堆
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum >> 1;

        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] * 2;
    }
}