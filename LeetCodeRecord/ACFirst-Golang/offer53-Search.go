package main

func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1

	low := 1
	high := 0

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			if mid == 0 || nums[mid-1] != target {
				low = mid
				break
			}
			right = mid - 1
		}
	}

	left = 0
	right = len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			if mid == len(nums)-1 || nums[mid+1] != target {
				high = mid
				break
			}

			left = mid + 1
		}
	}

	return high - low + 1
}
