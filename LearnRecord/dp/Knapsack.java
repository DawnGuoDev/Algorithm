package dp;

/**
 * 0-1 背包问题
 */
public class Knapsack {

    /**
     * 背包问题-基础版：求最大重量
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int knapsack1(int[] items, int n, int w) {
        boolean[][] dp = new boolean[n][w+1];   // 状态转移表

        // base case
        dp[0][0] = true;    // 不取 item 0
        if (items[0] <= w) {    // 取 item 0
            dp[0][items[0]] = true;
        }

        // 动态规划迭代
        for (int i = 1; i < n; i++) {
            // 不取 item i
            for (int j = 0; j < w+1; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                } 
            }
            
            // 取 item i
            for (int j = 0; j <= w - items[i]; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j+items[i]] =  true;
                }
            }
        }

        // 返回重量最大值
        for (int j = w; j >= 0; j--) {
            if (dp[n-1][j] == true) {
                return j;
            }
        }

        return -1;
    }

    /**
     * 双 11 满减问题
     * @param items
     * @param n
     * @param w
     */
    public void doubleEleven(int[] items, int n, int w) {
        boolean[][] dp = new boolean[n][w+6];
        
        // base case 
        dp[0][0] = true;
        if (items[0] <= w + 5) {
            dp[0][0] = true;
        }

        // 动态规划迭代
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w+6; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }

            for (int j = 0; j < w + 6 - items[i]; j++) {
                if (dp[i-1][j] == true) {
                    dp[i][j+items[i]] =  true;
                }
            }
        }

        int cw;
        for (cw = w; cw <= w+5; cw++) {
            if (dp[n-1][cw] == true) {
                break;
            }
        } 
        
        if (cw >= w+6) {
            return;
        }

        System.out.println(cw);
        for (int i = n-1; i >= 1; i--) {
            if (items[i] <= cw && dp[i-1][cw - items[i]] == true) {
                System.out.print(i + "\t");
                cw -= items[i];
            }
        }
        if (cw > 0) {
            System.out.print(0);
        }

        System.out.println();
    }

    /**
     * 背包问题-升级版：求最大价值
     * @param items
     * @param values
     * @param n
     * @param weight
     */
    public int knapsackTwo(int[] weights, int[] values, int n, int weight) {
        int[][] dp = new int[n][weight+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= weight; j++) {
                dp[i][j] = -1;
            }
        }
        
        // base case
        dp[0][0] = 0;
        if (weights[0] < weight) {
            dp[0][weights[0]] = values[0];
        }

        // 动态规划迭代
        for (int i = 1; i < n; i++) {
            // 不取 item i，j 是在 i-1 上的指针
            for (int j = 0; j <= weight; j++) {
                if (dp[i-1][j] != -1) {
                    dp[i][j] = dp[i-1][j];
                }
            }
            
            // 取 item i，j 是在 i-1 上的指针
            for (int j = 0; j <= weight-weights[i]; j++) {
                if (dp[i-1][j] != -1) {
                    int newValue= dp[i-1][j] + values[i];
                    if (newValue > dp[i][j+weights[i]]) {
                        dp[i][j+weights[i]] = newValue;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = weight; j >=0; j--) {
            if(dp[n-1][j] > max) {
                max = dp[n-1][j];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        // int[] items = {2, 3, 4, 5, 6, 7};
        Knapsack ks = new Knapsack();
        // System.out.println(ks.knapsack1(items, 6, 100));
        
        // int[] items2 = {100, 300, 67, 73, 65, 25, 56, 45};
        // ks.double11(items2, 8, 200);
        
        int[] weights = {2, 2, 4, 6, 3};
        int[] values = {3, 4, 8, 9, 6};
        System.out.println(ks.knapsack2(weights, values, 5, 12));
    }

}