package dp;

/**
 * 杨辉三角路径求最短
 */
public class YangHui {

    public int yanghui(int[][] items, int n) {
        // dp 状态转移表的初始化
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i+1];
        }

        // base case
        dp[0][0] = items[0][0];
        
        // 动态规划迭代
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + items[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + items[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + items[i][j];
                }
            }
        }

        // 选择最小值
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[n-1][j] < min) {
                min = dp[n-1][j];
            }
        }
        
        return min;
    }

    public static void main(String[] args) {
        YangHui yh = new YangHui();
        int[][] items = {{5}, {7, 8}, {2, 3, 4}, {4, 9, 6, 1}, {2, 7, 9, 4, 5}};

        System.out.println(yh.yanghui(items, 5));
    }
}