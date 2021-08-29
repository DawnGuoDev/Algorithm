package main

import "math"

func maximalSquare(matrix [][]byte) int {
	lenRow := len(matrix)
	if lenRow == 0 {
		return 0
	}

	lenCol := len(matrix[0])
	if lenCol == 0 {
		return 0
	}

	dp := make([][]int, lenRow)
	for i := 0; i < lenRow; i++ {
		dp[i] = make([]int, lenCol)
	}

	max := 0
	for i := 0; i < lenRow; i++ {
		for j := 0; j < lenCol; j++ {
			if matrix[i][j] == '1' {
				dp[i][j] = 1
				max = 1
			}
		}
	}

	for i := 1; i < lenRow; i++ {
		for j := 1; j < lenCol; j++ {
			if matrix[i][j] == '1' {
				dp[i][j] = int(math.Min(math.Min(float64(dp[i-1][j-1]), float64(dp[i-1][j])), float64(dp[i][j-1]))) + 1
				max = int(math.Max(float64(max), float64(dp[i][j])))
			}
		}
	}

	return max * max
}
