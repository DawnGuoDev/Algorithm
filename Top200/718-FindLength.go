package main

func findLength(nums1 []int, nums2 []int) int {
	len1 := len(nums1)
	len2 := len(nums2)

	dp := make([][]int, len1)
	for i := 0; i < len1; i++ {
		dp[i] = make([]int, len2)
	}

	max := 0
	for i := 0; i < len1; i++ {
		if nums1[i] == nums2[0] {
			dp[i][0] = 1
			max = 1
		}
	}

	for i := 0; i < len2; i++ {
		if nums2[i] == nums1[0] {
			dp[0][i] = 1
			max = 1
		}
	}

	for i := 1; i < len1; i++ {
		for j := 1; j < len2; j++ {
			if nums1[i] == nums2[j] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = 0
			}

			if max < dp[i][j] {
				max = dp[i][j]
			}
		}
	}

	return max
}
