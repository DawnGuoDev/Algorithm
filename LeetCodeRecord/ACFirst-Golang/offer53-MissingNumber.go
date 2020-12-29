package main

func missingNumber(nums []int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] == mid {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return left
}
