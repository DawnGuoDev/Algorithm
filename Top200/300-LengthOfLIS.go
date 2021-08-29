package main

func lengthOfLIS(nums []int) int {
	l := len(nums)

	dp := make([]int, l)

	dp[0] = 1

	maxOut := 1
	for i := 1; i < l; i++ {
		maxIn := 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && maxIn < dp[j]+1 {
				maxIn = dp[j] + 1
			}
		}
		dp[i] = maxIn
		if maxIn > maxOut {
			maxOut = maxIn
		}
	}

	return maxOut
}
