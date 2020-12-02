package main

func exchange(nums []int) []int {
	left := 0
	right := 0


	for right < len(nums) {
		if nums[right] & 1 == 1 {
			temp := nums[left]
			nums[left] = nums[right]
			nums[right] = temp	
			left++
		}
		
		right++
	}

	return nums
}

func exchange2(nums []int) []int {
	left := 0
	right := len(nums) - 1

	for left < right {
		for nums[left] & 1 == 1 && left < right {
			left++
		}
		
		for nums[right] & 1 == 0 && left < right {
			right--
		}

		temp := nums[left]
		nums[left] = nums[right]
		nums[right] = temp
		left++
		right--
	}

	return nums
}