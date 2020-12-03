package main

func moveZeroes(nums[] int) {
	numsLen := len(nums)
	
	if numsLen == 0 {
		return
	}

	quickMove(nums, 0, len(nums) - 1)
}


func quickMove(nums []int, left, right int) {
	if left >= right {
		return
	}

	i := left
	j := left

	for j <= right {
		if nums[j] != 0 {
			temp := nums[i]
			nums[i] = nums[j]
			nums[j] = temp
			i++
		}
		j++
	}
}