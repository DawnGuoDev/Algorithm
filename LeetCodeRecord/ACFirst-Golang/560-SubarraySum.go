package main

func subarraySum(nums []int, k int) int {
	numsLen := len(nums)
	count := 0

	for i := 0; i < numsLen; i++ {
		sum := 0
		for j := i; j < numsLen; j++ {
			sum += nums[j]

			if sum == k {
				count++
			}
		}
	}

	return count
}

func subarraySum2(nums []int, k int) int {
	numsLen := len(nums)
	preSum := make([]int, numsLen+1)
	count := 0

	preSum[0] = 0
	for i := 0; i < numsLen; i++ {
		preSum[i+1] = preSum[i] + nums[i]
	}

	for i := 0; i < numsLen; i++ {
		for j := i + 1; j <= numsLen; j++ {
			if preSum[j]-preSum[i] == k {
				count++
			}
		}
	}

	return count
}

func subarraySum3(nums []int, k int) int {
	hashMap := make(map[int]int)
	hashMap[0] = 1
	preSum := 0
	count := 0

	for i := 0; i < len(nums); i++ {
		preSum += nums[i]

		if elem, ok := hashMap[preSum-k]; ok == true {
			count += elem
		}

		if elem, ok := hashMap[preSum]; ok == true {
			hashMap[preSum] = elem + 1
		} else {
			hashMap[preSum] = 1
		}
	}

	return count
}
