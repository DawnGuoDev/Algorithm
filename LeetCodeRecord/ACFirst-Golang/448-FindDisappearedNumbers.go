package main

import (
	"math"
)

func findDisappearedNumbers(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		num := int(math.Abs(float64(nums[i])))
		nums[num-1] = -int(math.Abs(float64(nums[num-1])))
	}

	res := []int{}
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			res = append(res, i+1)
		}
	}

	return res
}
