package ACSecond;

class LongestPalindromeSecond {
    
    public String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen <= 1) {
            return s;
        }

        // dp 数组
        boolean[][] dp = new boolean[sLen][sLen];

        // base case
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }

        // 动态规划迭代
        int maxLen = 1;
        int begin = 0;
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] == true && (j - i + 1) > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        LongestPalindromeSecond lp = new LongestPalindromeSecond();
        System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.longestPalindrome("cbbd"));
        System.out.println(lp.longestPalindrome("bb"));
    }
}