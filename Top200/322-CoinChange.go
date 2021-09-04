package main

import "math"

func coinChange(coins []int, amount int) int {
	l := len(coins)

	if amount == 0 {
		return 0
	}

	dp := make([]int, amount+1)

	dp[0] = 0
	for i := 1; i < amount+1; i++ {
		dp[i] = amount + 1
	}

	for i := 0; i < l; i++ {
		for j := coins[i]; j <= amount; j++ {
			dp[j] = int(math.Min(float64(dp[j-coins[i]]+1), float64(dp[j])))
		}
	}

	if dp[amount] == amount+1 {
		return -1
	}
	return dp[amount]
}
