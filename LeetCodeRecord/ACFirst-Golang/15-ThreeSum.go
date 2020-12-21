package main

import (
	"sort"
)

type Ints []int

func (data Ints) Len() int {
	return len(data)
}

func (data Ints) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func (data Ints) Less(i, j int) bool {
	return data[i] < data[j]
}

func threeSum(nums []int) [][]int {
	res := [][]int{}
	numsLen := len(nums)

	if numsLen < 3 {
		return res
	}

	sort.Sort(Ints(nums))

	for i := 0; i < numsLen; i++ {
		if nums[i] > 0 {
			break
		}

		if i != 0 && nums[i] == nums[i-1] {
			continue
		}

		left := i + 1
		right := numsLen - 1

		for left < right {
			sum := nums[i] + nums[left] + nums[right]

			if sum == 0 {
				tempRes := []int{}
				tempRes = append(tempRes, nums[i])
				tempRes = append(tempRes, nums[left])
				tempRes = append(tempRes, nums[right])
				res = append(res, tempRes)

				for left < right && nums[left] == nums[left+1] {
					left++
				}

				for right > left && nums[right] == nums[right-1] {
					right--
				}

				left++
				right--
			} else if sum < 0 {
				left++
			} else {
				right--
			}
		}
	}

	return res
}
