package main

import "math"

func maxProduct(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}

	dpMin := make([]int, l)
	dpMax := make([]int, l)

	dpMin[0] = nums[0]
	dpMax[0] = nums[0]

	max := nums[0]
	for i := 1; i < l; i++ {
		dpMax[i] = int(math.Max(math.Max(float64(dpMin[i-1]*nums[i]), float64(dpMax[i-1]*nums[i])), float64(nums[i])))
		dpMin[i] = int(math.Min(math.Min(float64(dpMin[i-1]*nums[i]), float64(dpMax[i-1]*nums[i])), float64(nums[i])))
		if dpMax[i] > max {
			max = dpMax[i]
		}
	}

	return max
}
