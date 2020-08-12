package dynamic;

/**
 * 零钱兑换问题，其实本质跟背包问题类似，相当于 0-1 
 * 背包问题的进阶版本，因为 0-1 背包问题中，只能取
 * 或者不取，但是这个不是，这个相当于可以 0-n 都行。
 * 原题可看：LeetCode-322
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount+1; i++) {
            dp[i] = amount + 1;
        }
        
        // base case
        dp[0] = 0;

        // 递归迭代
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }    

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 3, 5}, 9));
    }
}