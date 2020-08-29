package ACFirst;

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row < 1) {
            return 0;
        }
        int column = matrix[0].length;

        // dp 数组，dp[i][j] 以 (i, j) 为右下角的正方形的最大边长
        int[][] dp = new int[row][column];

        // base case
        int max = 0;
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] ==  '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }   

        for (int j = 1; j < row; j++) {
            if (matrix[j][0] == '1') {
                dp[j][0] = 1;
                max = 1;
            }
        }

        // 动态规划转移
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        System.out.println(ms.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, 
                                                        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));

        System.out.println(ms.maximalSquare(new char[][]{}));
    }
}