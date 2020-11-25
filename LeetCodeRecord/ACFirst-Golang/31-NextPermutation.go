package main

func nextPermutation(nums []int) {
	i := len(nums) - 2
	j := len(nums) - 1
	k := len(nums) - 1

	for i >= 0 {
		if nums[i] < nums[j] {
			break
		}

		i--
		j--
	}

	if i >= 0 {
		for k >= j {
			if nums[k] > nums[i] {
				temp := nums[k]
				nums[k] = nums[i]
				nums[i] = temp
				break
			}
			k--
		}
	}

	i = len(nums) - 1
	for i > j {
		temp := nums[i]
		nums[i] = nums[j]
		nums[j] = temp

		i--
		j++
	}
}
