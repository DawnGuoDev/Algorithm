package ACFirst;

class LongestPalindrome {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return "";
        }
        // dp 数组
        boolean[][] dp = new boolean[sLen][sLen];

        // base case
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }

        // 动态规划迭代
        int begin = 0;
        int subLen = 1;
        for (int i = sLen - 1; i >= 0; i--) { // 从字符串后面开始
            for (int j = i + 1; j <= sLen - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > subLen) {
                        begin = i;
                        subLen = j - i + 1; 
                    } 
                } else {
                    dp[i][j] = false;
                }

            }
        }
        
        return s.substring(begin, begin + subLen);
    }    

    public String longestPalindrome2(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return "";
        }
        
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i <= sLen - 2; i++) {
            int[] re1 = this.findLongest(i, i, s);
            int[] re2 = this.findLongest(i, i + 1, s);

            if (maxLen < re1[1]) {
                maxLen = re1[1];
                begin = re1[0];
            }

            if (maxLen < re2[1]) {
                maxLen = re2[1];
                begin = re2[0];
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public int[] findLongest(int i, int j, String s) {
        int maxLen = 0;
        int begin = 0;
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            maxLen = j - i + 1;
            begin = i;
            i--;
            j++;
        }
        
        return new int[]{begin, maxLen};
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.longestPalindrome("cbbd"));
        System.out.println(lp.longestPalindrome("abcda"));
        System.out.println(lp.longestPalindrome2("abcda"));
        System.out.println(lp.longestPalindrome2("cbbd"));
        System.out.println(lp.longestPalindrome2("babad"));
    }
}