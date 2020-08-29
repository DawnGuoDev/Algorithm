package ACFirst;

class NumDecoding {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        // base case
        int num = s.charAt(0) - '0';
        if (num == 0) {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        
        // 动态规划迭代
        int num1;
        int num2;
        for (int i = 2; i <= s.length(); i++) {
            num1 = s.charAt(i-2) - '0';
            num2 = s.charAt(i-1) - '0';
             
            if (num2 == 0 && (num1 == 1 || num1 == 2)) {
                dp[i] = dp[i-2];
            } else if (num2 == 0 && (num1 != 1 && num1 != 2)) {
                return 0;
            } else if (num2 != 0 && (num1 * 10 + num2 >= 10 && num1*10 + num2 <= 26)){
                dp[i] = dp[i-1] + dp[i-2];
            } else if (num2 != 0 && (num1 * 10 + num2) > 26) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-2];
            }
        }
        
        return dp[s.length()];
    }

    public int numDecodings2(String s) {
        int[] dp = new int[s.length() + 1];

        // base case
        int num = s.charAt(0) - '0';
        if (num == 0) {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        
        // 动态规划迭代
        int num1;
        int num2;
        for (int i = 2; i <= s.length(); i++) {
            num1 = s.charAt(i-2) - '0';
            num2 = s.charAt(i-1) - '0';
            
            if (num2 != 0) {
                dp[i] += dp[i-1];
            }

            if (num1 * 10 + num2 >= 10 && num1 * 10 + num2 <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        NumDecoding nd = new NumDecoding();
        System.out.println(nd.numDecodings2("101"));
    }
}