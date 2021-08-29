package main

func countSubstrings(s string) int {
	sLen := len(s)
	if sLen <= 1 {
		return sLen
	}

	dp := make([][]bool, sLen)
	for i := 0; i < sLen; i++ {
		dp[i] = make([]bool, sLen)
	}

	count := sLen
	for i := 0; i < sLen; i++ {
		dp[i][i] = true
	}

	for i := sLen - 1; i >= 0; i-- {
		for j := i + 1; j < sLen; j++ {
			if s[i] == s[j] {
				if j-i <= 2 {
					dp[i][j] = true
				} else {
					dp[i][j] = dp[i+1][j-1]
				}

				if dp[i][j] {
					count++
				}
			} else {
				dp[i][j] = false
			}
		}
	}

	return count
}
