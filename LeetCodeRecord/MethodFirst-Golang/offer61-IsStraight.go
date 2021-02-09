package main

import "sort"

func isStraight(nums []int) bool {
	sort.Ints(nums)

	maxValue := -1
	minValue := 14
	pre := -1

	for _, value := range nums {
		if value == 0 {
			continue
		}

		if maxValue < value {
			maxValue = value
		}

		if minValue > value {
			minValue = value
		}

		if pre == value {
			return false
		}
		pre = value
	}

	return maxValue-minValue < 5
}
