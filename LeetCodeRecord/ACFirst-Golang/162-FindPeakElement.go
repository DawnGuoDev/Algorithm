package main

func findPeakElement(nums []int) int {
	numsLen := len(nums)
	left := 0
	right := numsLen - 1

	for left < right {
		mid := left + ((right - left) >> 1)

		if mid > 0 && mid < numsLen-1 && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1] {
			return mid
		} else if mid < numsLen-1 && nums[mid] < nums[mid+1] {
			left = mid + 1
		} else {
			right = mid
		}
	}

	return left
}
