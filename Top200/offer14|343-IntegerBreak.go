package main

func cuttingRope(n int) int {
	dp := make([]int, n+1)

	dp[0] = 1
	dp[1] = 1

	for i := 2; i < n+1; i++ {
		for j := 1; j < i; j++ {
			max1 := dp[i-j]
			if max1 < (i - j) {
				max1 = i - j
			}

			max2 := dp[j]
			if max2 < j {
				max2 = j
			}

			if max1*max2 > dp[i] {
				dp[i] = max1 * max2
			}
		}
	}

	return dp[n]
}
