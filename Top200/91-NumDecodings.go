package main

func numDecodings(s string) int {
	sLen := len(s)
	if sLen == 0 {
		return 0
	}

	if s[0]-'0' == 0 {
		return 0
	}

	dp := make([]int, sLen+1)

	dp[0] = 1
	dp[1] = 1

	// dp[i] 表示，i 个字符的情况下有多少种情况
	for i := 2; i < sLen+1; i++ {
		num1 := s[i-2] - '0'
		num2 := s[i-1] - '0'

		sum := num1*10 + num2

		if num2 != 0 {
			dp[i] += dp[i-1]
		}

		if sum >= 10 && sum <= 26 {
			dp[i] += dp[i-2]
		}
	}

	return dp[sLen]
}
