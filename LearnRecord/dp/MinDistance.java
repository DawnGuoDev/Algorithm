package dp;

/**
 * LeetCode-72 
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        // 状态转移表，下标为 0 处的地方的值相当于空格符
        int[][] dp = new int[word1Chars.length + 1][word2Chars.length + 1];
        
        // base case
        for (int i = 0; i < word1Chars.length + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < word2Chars.length + 1; j++) {
            dp[0][j] = j;
        }

        // 动态规划转移
        for (int i = 1; i < word1Chars.length + 1; i++) {
            for (int j = 1; j < word2Chars.length + 1; j++) {
                if (word1Chars[i-1] == word2Chars[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = this.min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + 1);
                }
            }
        }


        return dp[word1Chars.length][word2Chars.length];
    }

    public int min(int val1, int val2, int val3) {
        int min = val1;
        if (val2 < min) {
            min = val2;
        }
        if (val3 < min) {
            min = val3;
        }

        return min;
    }


    public static void main(String[] args) {
        MinDistance md = new MinDistance();
        System.out.println(md.minDistance("horse", "ros"));
    }
}