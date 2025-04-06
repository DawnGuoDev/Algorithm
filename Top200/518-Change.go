package main

func change(amount int, coins []int) int {
	l := len(coins)

	if l == 0 {
		return 0
	}

	dp := make([]int, amount+1)

	dp[0] = 1

	for i := 0; i < l; i++ {
		for j := coins[i]; j <= amount; j++ {
			dp[j] += dp[j-coins[i]]
		}
	}

	return dp[amount]
}
