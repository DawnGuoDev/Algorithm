package main

func searchMatrix(matrix [][]int, target int) bool {
	rows := len(matrix)
	if rows == 0 {
		return false
	}
	columns := len(matrix[0])

	rowNum := 0
	columnNum := columns - 1

	for rowNum < rows && columnNum >= 0 {
		if target > matrix[rowNum][columnNum] {
			rowNum++
		} else if target < matrix[rowNum][columnNum] {
			columnNum--
		} else {
			return true
		}
	}

	return false
}
