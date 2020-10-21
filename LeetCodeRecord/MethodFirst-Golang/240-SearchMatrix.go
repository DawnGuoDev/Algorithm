func findNumberIn2DArray(matrix [][]int, target int) bool {
	rows := len(matrix);
	if (rows == 0) {
		return false;
	}
	columns := len(matrix[0])

	for rowNum, colNum := 0, columns - 1; rowNum < rows && colNum >= 0; {
		if matrix[rowNum][colNum] > target {
			colNum --	
		} else if matrix[rowNum][colNum] < target {
			rowNum ++
		} else {
			return true
		}
	}

	return false
}