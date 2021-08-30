package Top200;

class MaxProfit2 {
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

        // 动态规划迭代
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 这里的动态规划需要注意
        }

        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; ) {
            while (i < prices.length && prices[i] <= min) {
                min = prices[i];
                i++;
            }

            while (i < prices.length && prices[i] > prices[i - 1] ) {
                i++;
            }

            profit += prices[i - 1] - min;
            min = prices[i - 1];
        }

        return profit;
    }

    /**
     * 实现细节上有点卡顿
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int profit = 0;

        int min = 0;
        int max = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            min = prices[i];

            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            max = prices[i];

            profit += (max - min);
        }

        return profit;
    }

    public int maxProfit4(int[] prices) {
        int profit = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        MaxProfit2 mp = new MaxProfit2();
        System.out.println(mp.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(mp.maxProfit(new int[]{1, 2, 3, 4, 5}));

        System.out.println(mp.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(mp.maxProfit2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(mp.maxProfit2(new int[]{3, 3}));
        
        System.out.println(mp.maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(mp.maxProfit3(new int[]{1, 2, 3, 4, 5}));
        System.out.println(mp.maxProfit3(new int[]{3, 3}));

        System.out.println(mp.maxProfit4(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(mp.maxProfit4(new int[]{1, 2, 3, 4, 5}));
        System.out.println(mp.maxProfit4(new int[]{3, 3}));
    }
}