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

	if l == 2 {
		return int(math.Max(float64(nums[0]), float64(nums[1])))
	}

	dp1 := make([]int, l)
	dp2 := make([]int, l)

	dp1[0] = nums[0]
	dp1[1] = int(math.Max(float64(nums[0]), float64(nums[1])))

	dp2[0] = 0
	dp2[1] = nums[1]
	dp2[2] = int(math.Max(float64(nums[1]), float64(nums[2])))

	for i := 2; i < l-1; i++ {
		dp1[i] = int(math.Max(float64(dp1[i-1]), float64(dp1[i-2]+nums[i])))
		dp2[i+1] = int(math.Max(float64(dp2[i]), float64(dp2[i-1]+nums[i+1])))
	}

	return int(math.Max(float64(dp1[l-2]), float64(dp2[l-1])))
}
