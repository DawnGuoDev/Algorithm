package ACFirst;

class NumTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        // dp 数组
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }    
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees nt = new NumTrees();
        System.out.println(nt.numTrees(3));
    }
}