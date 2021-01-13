package main

func canJump(nums []int) bool {
	rightMost := 0

	for i := 0; i < len(nums); i++ {
		if i > rightMost {
			break
		}

		right := i + nums[i]
		if right > rightMost {
			rightMost = right
		}

		if rightMost >= len(nums)-1 {
			return true
		}
	}

	return false
}
