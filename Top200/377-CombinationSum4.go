package main

func combinationSum4(nums []int, target int) int {
	l := len(nums)

	if l == 0 {
		return 0
	}

	dp := make([]int, target+1)
	dp[0] = 1

	for i := 1; i <= target; i++ {
		for j := 0; j < l; j++ {
			if nums[j] <= i {
				dp[i] += dp[i-nums[j]]
			}
		}
	}

	return dp[target]
}
