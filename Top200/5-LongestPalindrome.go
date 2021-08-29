package main

func longestPalindrome(s string) string {
	sLen := len(s)
	if sLen == 1 {
		return s
	}

	dp := make([][]bool, sLen)
	for i := 0; i < sLen; i++ {
		dp[i] = make([]bool, sLen)
	}

	for i := 0; i < sLen; i++ {
		dp[i][i] = true
	}

	begin := 0
	maxLen := 1
	for i := sLen - 1; i >= 0; i-- {
		for j := i + 1; j < sLen; j++ {
			if s[i] == s[j] {
				if j-i <= 2 {
					dp[i][j] = true
				} else {
					dp[i][j] = dp[i+1][j-1]
				}

				if dp[i][j] && maxLen <= (j-i) {
					begin = i
					maxLen = j - i + 1
				}
			} else {
				dp[i][j] = false
			}
		}
	}

	return s[begin : begin+maxLen]
}
