package ACFirst;

class MinPathSum {

    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int column = grid[0].length;

        // dp 数组
        int[][] dp = new int[row][column];

        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 状态转移
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][column-1]; 
    }

    /**
     * 内存优化版本
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
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
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[row-1][column-1];
    }

    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();
        System.out.println(mps.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(mps.minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(mps.minPathSum(new int[][]{{1, 2, 4}, {3, 2, 1}}));
    }
}