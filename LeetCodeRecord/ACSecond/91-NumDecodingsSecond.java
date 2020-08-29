package ACSecond;

class NumDecodingsSecond {
    public int numDecodings(String s) {
        int sLen = s.length();
        if (sLen <= 0) {
            return sLen;
        }

        // dp 数组
        int[] dp = new int[sLen + 1];
        
        // base case
        dp[0] = 1;
        
        int num1 = s.charAt(0) - '0';
        if (num1 == 0) {
            return 0;
        }
        dp[1] = 1;
        
        int num2 = 0;
        for (int i = 2; i < sLen + 1; i++) {
            num1 = s.charAt(i - 1) - '0';
            num2 = s.charAt(i - 2) - '0';

            if (num1 != 0) {
                dp[i] += dp[i - 1];
            }

            int num = num2 * 10 + num1;
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[sLen];
    }     

    public static void main(String[] args) {
        NumDecodingsSecond nd = new NumDecodingsSecond();
        System.out.println(nd.numDecodings("12"));
        System.out.println(nd.numDecodings("226"));
        System.out.println(nd.numDecodings("27"));
    }
}