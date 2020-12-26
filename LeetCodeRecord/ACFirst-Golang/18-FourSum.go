package main

import "sort"

type Ints []int

func (data Ints) Len() int {
	return len(data)
}

func (data Ints) Less(i, j int) bool {
	return data[i] < data[j]
}

func (data Ints) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func fourSum(nums []int, target int) [][]int {
	res := [][]int{}
	numsLen := len(nums)

	if numsLen < 4 {
		return res
	}

	sort.Sort(Ints(nums))

	for i := 0; i < numsLen; i++ {
		if i != 0 && nums[i] == nums[i-1] {
			continue
		}

		for j := i + 1; j < numsLen; j++ {
			if j != i+1 && nums[j] == nums[j-1] {
				continue
			}

			left := j + 1
			right := numsLen - 1

			for left < right {
				sum := nums[i] + nums[j] + nums[left] + nums[right]

				if sum == target {
					tempRes := []int{}
					tempRes = append(tempRes, nums[i])
					tempRes = append(tempRes, nums[j])
					tempRes = append(tempRes, nums[left])
					tempRes = append(tempRes, nums[right])

					res = append(res, tempRes)

					for left < right && nums[left] == nums[left+1] {
						left++
					}

					for left < right && nums[right] == nums[right-1] {
						right--
					}

					left++
					right--
				} else if sum < target {
					left++
				} else {
					right--
				}
			}
		}
	}

	return res
}
