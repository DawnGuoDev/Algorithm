package main

func twoSum(nums []int, target int) []int {
	numsLen := len(nums)
	if numsLen == 0 || numsLen == 1 {
		return []int{}
	}

	left := 0
	right := numsLen - 1
	sum := nums[left] + nums[right]

	for left < right {
		if sum < target {
			sum -= nums[left]
			sum += nums[left+1]
			left++
		} else if sum > target {
			sum -= nums[right]
			sum += nums[right-1]
			right--
		} else {
			return []int{nums[left], nums[right]}
		}
	}

	return []int{}
}
