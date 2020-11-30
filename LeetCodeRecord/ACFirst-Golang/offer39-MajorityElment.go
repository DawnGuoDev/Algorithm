package main

func majorityElment(nums []int) int {
	num := 0
	votes := 0

	for i := 0; i < len(nums); i++ {
		if votes == 0 {
			num = nums[i]
		}

		if num == nums[i] {
			votes++
		} else {
			votes--
		}
	}

	return num
}
