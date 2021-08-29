package main

import "math"

func maxSubArray(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}

	dp := make([]int, l)

	dp[0] = nums[0]

	max := nums[0]
	for i := 1; i < l; i++ {
		dp[i] = int(math.Max(float64(nums[i]+dp[i-1]), float64(nums[i])))
		if max < dp[i] {
			max = dp[i]
		}
	}

	return max
}
