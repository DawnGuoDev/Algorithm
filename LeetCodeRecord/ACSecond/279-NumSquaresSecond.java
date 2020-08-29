package ACSecond;

class NumSquaresSecond {
    public int numSquares(int n) {
        // dp 数组
        int[] dp = new int[n + 1];
       
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // base case
        dp[0] = 0;
        
        // 动态规划迭代
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumSquaresSecond  ns = new NumSquaresSecond();
        System.out.println(ns.numSquares(12));
        System.out.println(ns.numSquares(13));
    }
}