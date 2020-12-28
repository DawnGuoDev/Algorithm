package main

import "fmt"

func bSearch(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] == value {
			return mid
		} else if nums[mid] < value {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return -1
}

func bSearchFirst(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] < value {
			left = mid + 1
		} else if nums[mid] > value {
			right = mid - 1
		} else {
			if mid == 0 || nums[mid] != nums[mid-1] {
				return mid
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}

func bSearchLast(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] < value {
			left = mid + 1
		} else if nums[mid] > value {
			right = mid - 1
		} else {
			if mid == len(nums)-1 || nums[mid] != nums[mid+1] {
				return mid
			} else {
				left = mid + 1
			}
		}
	}

	return -1
}

func bSearchFirstGE(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] < value {
			left = mid + 1
		} else {
			if mid == 0 || nums[mid-1] < value {
				return mid
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}

func bSearchLastLE(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		// fmt.Println(mid)

		if nums[mid] > value {
			right = mid - 1
		} else {
			if mid == len(nums)-1 || nums[mid+1] > value {
				return mid
			} else {
				left = mid + 1
			}
		}
	}

	return -1
}

func bSearchFirstG(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] <= value {
			left = mid + 1
		} else {
			if mid == 0 || nums[mid-1] <= value {
				return mid
			}
			right = mid - 1
		}
	}

	return -1
}

func bSearchLastL(nums []int, value int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) >> 1)

		if nums[mid] >= value {
			right = mid - 1
		} else {
			if mid == len(nums)-1 || nums[mid+1] >= value {
				return mid
			}
			left = mid + 1
		}
	}

	return -1
}

func main() {
	// nums := []int{1, 3, 4, 7, 10, 13, 16}
	// fmt.Println(bSearch(nums, 3))
	// fmt.Println(bSearch(nums, 7))
	// fmt.Println(bSearch(nums, 10))
	// nums := []int{1, 3, 3, 3, 13, 16, 16, 16}
	// fmt.Println(bSearchFirst(nums, 3))
	// fmt.Println(bSearchFirst(nums, 16))
	// fmt.Println(bSearchFirst(nums, 13))

	// nums := []int{1, 3, 3, 3, 13, 16, 16, 16}
	// fmt.Println(bSearchLast(nums, 3))
	// fmt.Println(bSearchLast(nums, 16))
	// fmt.Println(bSearchLast(nums, 13))

	// nums := []int{1, 3, 4, 7, 10, 13, 16, 20}
	// fmt.Println(bSearchFirstGE(nums, 2))
	// fmt.Println(bSearchFirstGE(nums, 15))
	// fmt.Println(bSearchFirstGE(nums, 13))

	// nums := []int{1, 3, 4, 7, 10, 13, 16, 20}
	// fmt.Println(bSearchLastLE(nums, 2))
	// fmt.Println(bSearchLastLE(nums, 31))
	// fmt.Println(bSearchLastLE(nums, 13))

	// nums := []int{1, 3, 4, 7, 10, 13, 16, 20}
	// fmt.Println(bSearchFirstG(nums, 2))
	// fmt.Println(bSearchFirstG(nums, 31))
	// fmt.Println(bSearchFirstG(nums, 13))

	nums := []int{1, 3, 4, 7, 10, 13, 16, 20}
	fmt.Println(bSearchLastL(nums, 2))
	fmt.Println(bSearchLastL(nums, 31))
	fmt.Println(bSearchLastL(nums, 13))
}
