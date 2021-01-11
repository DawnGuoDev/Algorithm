package main

import (
	"math"
	"sort"
)

type NewInt []int

func (data NewInt) Len() int {
	return len(data)
}

func (data NewInt) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func (data NewInt) Less(i, j int) bool {
	return data[i] < data[j]
}

func threeSumClosest(nums []int, target int) int {
	numsLen := len(nums)
	sort.Sort(NewInt(nums))

	minGap := 20001
	sum := 0
	for i := 0; i < numsLen-2; i++ {
		left := i + 1
		right := numsLen - 1
		for left < right {
			tempSum := nums[i] + nums[left] + nums[right]
			tempGap := int(math.Abs(float64(tempSum - target)))

			if tempGap == 0 {
				return tempSum
			}

			if tempGap < minGap {
				minGap = tempGap
				sum = tempSum
			}

			if target > tempSum {
				left++
			} else if target < tempSum {
				right--
			}
		}
	}

	return sum
}
