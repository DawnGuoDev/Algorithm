package main

func findKthLargest(nums []int, k int) int {
	numsLen := len(nums)
	
	if numsLen == 0 || numsLen < k {
		return -1
	}

	quickPick(nums, 0, numsLen - 1, k)

	return nums[k-1]
}

func quickPick(nums []int, left, right, k int) {
	if left >= right {
		return
	}

	i := left
	j := left
	pivot := nums[right]

	for j <= right {
		if nums[j] >= pivot {
			temp := nums[i]
			nums[i] = nums[j]
			nums[j] = temp
			i++
		}
		j++
	}

	if i == k {
		return
	}

	quickPick(nums, left, i - 2, k)
	quickPick(nums, i, right, k)
}