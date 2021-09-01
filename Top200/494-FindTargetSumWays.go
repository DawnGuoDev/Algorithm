package main

import "math"

func findTargetSumWays(nums []int, target int) int {
	numsLen := len(nums)

	if numsLen == 1 {
		if math.Abs(float64(nums[0])) != math.Abs(float64(target)) {
			return 0
		}

		return 1
	}

	sum := 0
	for _, num := range nums {
		sum += num
	}

	if target > sum {
		return 0
	}

	if (sum+target)%2 == 1 {
		return 0
	}

	target = (sum + target) >> 1
	dp := make([]int, target+1)
	dp[0] = 1
	for i := 0; i < numsLen; i++ {
		for j := target; j >= nums[i]; j-- {
			dp[j] += dp[j-nums[i]]
		}
	}

	return dp[target]
}
