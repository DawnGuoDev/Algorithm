package main

import "math"

func maxProfit(prices []int) int {
	l := len(prices)
	if l == 0 || l == 1 {
		return 0
	}

	dp := make([][]int, 2)
	dp[0] = make([]int, l)
	dp[1] = make([]int, l)

	dp[0][0] = 0          // 第 0 天不持有股票
	dp[1][0] = -prices[0] // 第 0 天持有股票

	for i := 1; i < l; i++ {
		dp[0][i] = int(math.Max(float64(dp[1][i-1]+prices[i]), float64(dp[0][i-1])))
		dp[1][i] = int(math.Max(float64(-prices[i]), float64(dp[1][i-1])))
	}

	return dp[0][l-1]
}
