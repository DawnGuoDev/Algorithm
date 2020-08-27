import java.util.LinkedList;
import java.util.Queue;

class CoinChange {
    public int coinChange(final int[] coins, final int amount) {
        // dp 数组
        final int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }

        // base case
        dp[0] = 0;

        // 动态规划迭代
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }

                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        boolean[] visited = new boolean[amount + 1]; // 用于剪枝
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(amount);
        visited[amount] = true;

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int coin : coins) {
                    int next = num - coin;
                    if (next == 0) {
                        return step;
                    }

                    if (next < 0 || visited[next] == true) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(final String[] args) {
        final CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(cc.coinChange(new int[]{2}, 3));
        System.out.println(cc.coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(cc.coinChange2(new int[]{2}, 3));
    }
}