package main

import "math"

func canPartition(nums []int) bool {
	l := len(nums)
	if l == 0 || l == 1 {
		return false
	}

	sum := 0
	for i := 0; i < l; i++ {
		sum += nums[i]
	}

	if sum%2 != 0 {
		return false
	}

	sum = sum >> 1
	dp := make([]int, sum+1)

	dp[0] = 0

	for i := 0; i < l; i++ {
		for j := sum; j >= nums[i]; j-- {
			dp[j] = int(math.Max(float64(dp[j-nums[i]]+nums[i]), float64(dp[j])))
		}
		if dp[sum] == sum {
			return true
		}
	}

	return false
}
