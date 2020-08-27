class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        // dp 数组
        int[][] dp = new int[len][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 动态规划转移
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int i = 0; i < prices.length; i++) {   
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (profit < prices[i] - min) {
                    profit = prices[i] - min;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(mp.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(mp.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(mp.maxProfit2(new int[]{7,6,4,3,1}));
    }
}