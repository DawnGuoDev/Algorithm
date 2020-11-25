package main

func rotate(nums []int, k int) {
	len := len(nums) // nums 数组长度
	k = k % len      // k 取余

	for left, right := 0, len-1; left < right; {
		temp := nums[left]
		nums[left] = nums[right]
		nums[right] = temp

		left++
		right--
	}

	for left, right := 0, k-1; left < right; {
		temp := nums[left]
		nums[left] = nums[right]
		nums[right] = temp

		left++
		right--
	}

	for left, right := k, len-1; left < right; {
		temp := nums[left]
		nums[left] = nums[right]
		nums[right] = temp

		left++
		right--
	}
}

func rotate2(nums []int, k int) {
	len := len(nums)
	k = k % len
	count := 0

	for startIndex := 0; count < len; startIndex++ {
		curr := startIndex
		next := (curr + k) % len
		pre := nums[curr]
		temp := nums[next]
		nums[next] = pre
		curr = next
		pre = temp
		count++

		for curr != startIndex {
			next = (curr + k) % len
			temp = nums[next]
			nums[next] = pre
			curr = next
			pre = temp
			count++
		}
	}
}
