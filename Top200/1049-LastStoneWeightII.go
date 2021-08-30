package main

import "math"

func lastStoneWeightII(stones []int) int {
	l := len(stones)

	if l == 1 {
		return stones[0]
	}

	sum := 0
	for _, stone := range stones {
		sum += stone
	}

	target := sum >> 1

	dp := make([]int, target+1)
	dp[0] = 0

	for i := 0; i < l; i++ {
		for j := target; j >= stones[i]; j-- {
			dp[j] = int(math.Max(float64(dp[j]), float64(dp[j-stones[i]]+stones[i])))
		}
	}

	return sum - 2*dp[target]
}
