class CountSubstrings {
    public int countSubstrings(String s) {
        int sLen = s.length();

        if (sLen == 0) {
            return 0;
        }

        // dp 数组
        boolean[][] dp = new boolean[sLen][sLen];

        // base case
        int count = 0;
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
            count ++;
        }

        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return count; 
    }

    public int countSubstrings2(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < sLen - 1; i++) {
            int re1 = this.countStrings(i, i, s);
            int re2 = this.countStrings(i, i + 1, s);
            count += re1;
            count += re2;
        }
        
        return count + 1;
    }

    public int countStrings(int i, int j, String s) {
        int count = 0;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count ++;
            i--;
            j++;
        }

        return count;
    }
    public static void main(String[] args) {
        CountSubstrings cs = new CountSubstrings();
        System.out.println(cs.countSubstrings("aaa"));
        System.out.println(cs.countSubstrings("abc"));
        System.out.println(cs.countSubstrings2("aaa"));
        System.out.println(cs.countSubstrings2("abc"));
    }
}