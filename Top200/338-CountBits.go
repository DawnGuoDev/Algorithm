package main

func countBits(n int) []int {
	if n == 0 {
		return []int{0}
	}

	dp := make([]int, n+1)

	dp[0] = 0
	dp[1] = 1

	for i := 2; i <= n; i++ {
		dp[i] = dp[i>>1] + i%2
	}

	return dp
}
