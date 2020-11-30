package main

func findRepeatNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		for i != nums[i] {
			if nums[i] == nums[nums[i]] {
				return nums[i]
			}
			temp := nums[i]
			nums[i] = nums[temp]
			nums[temp] = temp
		}
	}

	return -1
}
