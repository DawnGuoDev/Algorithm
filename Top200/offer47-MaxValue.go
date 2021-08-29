package main

import "math"

func maxValue(grid [][]int) int {
	lenRow := len(grid)
	if lenRow == 0 {
		return 0
	}

	lenCol := len(grid[0])

	dp := make([][]int, lenRow)
	for i := 0; i < lenRow; i++ {
		dp[i] = make([]int, lenCol)
	}

	dp[0][0] = grid[0][0]
	for i := 1; i < lenRow; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}
	for i := 1; i < lenCol; i++ {
		dp[0][i] = dp[0][i-1] + grid[0][i]
	}

	for i := 1; i < lenRow; i++ {
		for j := 1; j < lenCol; j++ {
			dp[i][j] = int(math.Max(float64(dp[i-1][j]), float64(dp[i][j-1]))) + grid[i][j]
		}
	}

	return dp[lenRow-1][lenCol-1]
}
