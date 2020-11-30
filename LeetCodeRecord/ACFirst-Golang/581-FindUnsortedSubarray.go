package main

import (
	"math"
	"sort"
)

func findUnsortedSubarray(nums []int) int {
	len := len(nums)
	left := len
	right := 0

	for i := 0; i < len; i++ {
		for j := i + 1; j < len; j++ {
			if nums[j] < nums[i] {
				if i < left {
					left = i
				}

				if j > right {
					right = j
				}
			}
		}
	}

	if left < right {
		return right - left + 1
	}

	return 0
}

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

func findUnsortedSubarray2(nums []int) int {
	len := len(nums)

	numsCopy := make([]int, len)
	copy(numsCopy, nums)

	sort.Sort(Ints(nums))

	left := len
	right := 0

	for i := 0; i < len; i++ {
		if nums[i] != numsCopy[i] {
			if i < left {
				left = i
			}

			if i > right {
				right = i
			}
		}
	}

	if left < right {
		return right - left + 1
	}

	return 0
}

func findUnsortedSubarray3(nums []int) int {
	stack := []int{}
	lenNums := len(nums)

	left := lenNums
	right := 0

	for i := 0; i < lenNums; i++ {
		// 注意：这里需要是 for 循环，意思是遍历到一个值之后，需要把栈中所有小于这个值的值都给弹出
		for len(stack) != 0 && nums[stack[len(stack)-1]] > nums[i] {
			if left > stack[len(stack)-1] {
				left = stack[len(stack)-1]
			}

			stack = stack[:len(stack)-1]
		}

		stack = append(stack, i)
	}

	stack = []int{}
	for i := lenNums - 1; i >= 0; i-- {
		for len(stack) != 0 && nums[stack[len(stack)-1]] < nums[i] {
			if right < stack[len(stack)-1] {
				right = stack[len(stack)-1]
			}

			stack = stack[:len(stack)-1]
		}

		stack = append(stack, i)
	}

	if left < right {
		return right - left + 1
	}

	return 0
}

func findUnsortedSubarray4(nums []int) int {
	lenNums := len(nums)

	left := lenNums
	right := 0
	flag := 0
	min := math.MaxInt32
	max := math.MinInt32

	// 从左往右先寻找不规则区域的最小值
	for i := 1; i < lenNums; i++ {
		if flag == 0 && nums[i-1] > nums[i] {
			flag = 1
			min = nums[i]
		}

		if flag != 0 && min > nums[i] {
			min = nums[i]
		}
	}

	// 找出左边界
	for i := 0; i < lenNums; i++ {
		if min < nums[i] {
			left = i
			break
		}
	}

	// 从右往左先找到不规则区域的最大值
	flag = 0
	for i := lenNums - 2; i >= 0; i-- {
		if flag == 0 && nums[i+1] < nums[i] {
			flag = 1
			max = nums[i]
		}

		if flag != 0 && max < nums[i] {
			max = nums[i]
		}
	}

	// 找出右边界
	for i := lenNums - 1; i >= 0; i-- {
		if max > nums[i] {
			right = i
			break
		}
	}

	if left < right {
		return right - left + 1
	}

	return 0
}
