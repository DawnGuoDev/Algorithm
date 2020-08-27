class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp 数组
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

    public int uniquePaths2(int m, int n) {
        long factorial1 = 1;
        long factorial2 = 1;
        
        /* 
         因为 C(m+n-2, m-1) == C(m+n-2, n-1)
         假如 m > n 的话，m-1 可能会超出值的范围；
         所以将 m 和 n 进行交换，这样 m-1 其实是 n-1，那么超出值的概率不会那么大
         */
        if (m > n) {    
            int temp = n;
            n = m;
            m = temp;
        }

        for (int i = 1; i <= m-1; i++) {
            factorial1 *= i;
        }

        for (int i = n; i <= m + n - 2; i++) {
            factorial2 *= i;
        }

        return (int)(factorial2/factorial1);
    }
    
    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 2));
        System.out.println(up.uniquePaths(23, 12));
        System.out.println(up.uniquePaths2(23, 12));
    }
}