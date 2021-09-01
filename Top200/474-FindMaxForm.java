package Top200;

class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            int[] count = countStr(strs[i]);
            zeros[i] = count[0];
            ones[i] = count[1];
        }

        int[][] dp = new int[m + 1][n + 1];
        

        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= zeros[i]; j--) {   // 这里的顺序需要注意
                for (int k = n; k >= ones[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros[i]][k-ones[i]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public int[] countStr(String str) {
        if (str == null || str.length() == 0) {
            return new int[]{0, 0};
        }

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        return new int[]{zeroCount, oneCount};
    }
}