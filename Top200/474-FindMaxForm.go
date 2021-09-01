package main

import "math"

func findMaxForm(strs []string, m int, n int) int {
	strsLen := len(strs)
	counts0 := make([]int, strsLen)
	counts1 := make([]int, strsLen)

	for i := 0; i < strsLen; i++ {
		count := countStr(strs[i])
		counts0[i] = count[0]
		counts1[i] = count[1]
	}

	dp := make([][]int, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([]int, n+1)
	}

	for i := 0; i < strsLen; i++ {
		for j := m; j >= counts0[i]; j-- {
			for k := n; k >= counts1[i]; k-- {
				dp[j][k] = int(math.Max(float64(dp[j][k]), float64(dp[j-counts0[i]][k-counts1[i]]+1)))
			}
		}
	}

	return dp[m][n]
}

func countStr(str string) []int {
	count0 := 0
	count1 := 0
	for _, c := range str {
		if c == '0' {
			count0++
		} else {
			count1++
		}
	}

	return []int{count0, count1}
}
