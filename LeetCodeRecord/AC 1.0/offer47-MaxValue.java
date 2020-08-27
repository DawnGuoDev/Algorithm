class MaxValue {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        // dp 数组
        int[][] dp = new int[row][column];

        // base case
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < column; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i =1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][column-1];
    }

    /**
     * 内存空间优化版本
     */
    public int maxValue2(int[][] grid) {
        int row = grid.length;
        int column =  grid[0].length;

        // base case
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int j = 1; j < column; j++) {
            grid[0][j] += grid[0][j-1];
        }

        // 开始填表格
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[row-1][column-1];

    }
    public static void main(String[] args) {
        MaxValue mv =  new MaxValue();
        System.out.println(mv.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(mv.maxValue2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}