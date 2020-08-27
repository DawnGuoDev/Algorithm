package dynamic;

/**
 * LeetCode-1143
 */
public class LongestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Chars = text1.toCharArray();
        char[] text2Chars = text2.toCharArray();
        
        // 状态转移矩阵
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // base case
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < text2.length() + 1; j++) {
            dp[0][j] = 0;
        }

        // 动态规划转移
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1Chars[i-1] == text2Chars[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}