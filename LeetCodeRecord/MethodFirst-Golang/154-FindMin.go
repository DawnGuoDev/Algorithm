func findMin(nums []int) int {
	length := len(nums)
	
	left := 0
	right := length - 1

	for left < right {
		mid :=  left + (right - left) / 2
		
		if nums[mid] > nums[right] {
			left = mid + 1
		} else if nums[mid] < nums[right] {
			right = mid
		} else {
			index := left
			for i := left; i < right; i++ {
				if nums[index] > nums[i] {
					index = i
				}
			}

			return nums[index]
		}
	}

	return nums[left]
}