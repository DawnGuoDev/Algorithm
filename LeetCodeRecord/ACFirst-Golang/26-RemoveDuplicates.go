package main

func removeDuplicates(nums []int) int {
	i := 0
	j := 1

	for j < len(nums) {
		if nums[i] != nums[j] {
			nums[i+1] = nums[j]
			i++
			j++
		} else {
			j++
		}
	}

	return i + 1
}
