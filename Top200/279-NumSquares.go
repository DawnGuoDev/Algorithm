package main

import "math"

func numSquares(n int) int {
	dp := make([]int, n+1)

	for i := 0; i <= n; i++ {
		dp[i] = n + 1
	}
	dp[0] = 0
	dp[1] = 1

	for i := 2; i <= n; i++ {
		for j := 1; i >= j*j; j++ {
			dp[i] = int(math.Min(float64(dp[i]), float64(dp[i-j*j]+1)))
		}
	}

	return dp[n]
}
