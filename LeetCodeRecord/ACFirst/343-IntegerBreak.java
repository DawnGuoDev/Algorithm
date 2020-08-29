package ACFirst;

class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        
        //base case
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i-j], (i-j)), dp[i]);
            }
        }

        return dp[n];
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * Math.max(i - j, dp[i - j]), dp[i]);
            }
        }

        return dp[n];
    }

    public int integerBreak3(int n) {
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        // 这种需要注意 n == 3 的情况
        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(Math.max(2 * dp[i - 2], 2 * (i-2)), Math.max(3 * dp[i - 3], 3 * (i - 3))), dp[i]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(2));
        System.out.println(ib.integerBreak2(10));
        System.out.println(ib.integerBreak3(2));
        System.out.println(ib.integerBreak3(10));
    }
}

