package main

func generate(numRows int) [][]int {
	res := make([][]int, numRows)

	for i := 0; i < numRows; i++ {
		temp := make([]int, i+1)
		temp[0] = 0
		temp[i] = 0

		for j := 1; j < i; j++ {
			temp[j] = res[i-1][j-1] + res[i-1][j]
		}

		res[i] = temp
	}

	return res
}
