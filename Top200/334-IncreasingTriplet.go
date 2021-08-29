package main

import "math"

func increasingTriplet(nums []int) bool {
	l := len(nums)

	if l <= 2 {
		return false
	}

	minmin := math.MaxInt64
	min := math.MaxInt64

	for i := 0; i < l; i++ {
		if nums[i] <= minmin {
			minmin = nums[i]
		} else if nums[i] <= min {
			min = nums[i]
		} else {
			return true
		}
	}

	return false
}
