package main

func findDuplicate(nums []int) int {
	left := 1
	right := len(nums) - 1

	for left < right {
		mid := left + ((right - left) >> 1)

		count := 0
		for _, num := range nums {
			if num <= mid {
				count++
			}
		}

		if count > mid {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}
