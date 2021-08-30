package main

import "math"

func rob(nums []int) int {
	l := len(nums)

	if l == 0 {
		return 0
	}

	if l == 1 {
		return nums[0]
	}

	dp := make([]int, l)
	dp[0] = nums[0]
	dp[1] = int(math.Max(float64(nums[0]), float64(nums[1])))

	for i := 2; i < l; i++ {
		dp[i] = int(math.Max(float64(dp[i-1]), float64(dp[i-2]+nums[i])))
	}

	return dp[l-1]
}
