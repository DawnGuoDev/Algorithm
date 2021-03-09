package dp;

/**
 * 矩阵路径求最短
 */
public class MatrixPathMin {
    public int pathMin(int[][] matrix, int n) {
        int[][] dp = new int[n][n];

        // base case
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        // 递归迭代
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return dp[n-1][n-1];
    }

    public static void main(String[] args) {
        MatrixPathMin mpm = new MatrixPathMin();
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        System.out.println(mpm.pathMin(matrix, 4));
    }
}