package main

import "math"

func maxProfit(prices []int) int {
	l := len(prices)
	if l <= 1 {
		return 0
	}

	dp := make([][]int, 2)
	dp[0] = make([]int, l) // 不持有
	dp[1] = make([]int, l) // 持有

	dp[0][0] = 0          // 第 0 天不持有
	dp[1][0] = -prices[0] // 第 0 天持有

	for i := 1; i < l; i++ {
		dp[0][i] = int(math.Max(float64(dp[0][i-1]), float64(dp[1][i-1]+prices[i])))
		dp[1][i] = int(math.Max(float64(dp[1][i-1]), float64(dp[0][i-1]-prices[i])))
	}

	return dp[0][l-1]
}
