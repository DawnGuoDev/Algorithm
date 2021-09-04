package Top200;

class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // base case
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i-j*j >= 0; j++) {  // 这边等于号要注意，需要加上去，比如组成 4 的这个平方数个数只有 1 个。
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);                    
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares ns = new NumSquares();
        System.out.println(ns.numSquares(4));
        System.out.println(ns.numSquares(5));
        System.out.println(ns.numSquares(6));
        System.out.println(ns.numSquares(7));
        System.out.println(ns.numSquares(12));
    }
}