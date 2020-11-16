package main

func rotate(matrix [][]int) {
	rows := len(matrix)
	columns := len(matrix[0])

	for i := 0; i < rows-1; i++ {
		for j := i + 1; j < columns; j++ {
			temp := matrix[i][j]
			matrix[i][j] = matrix[j][i]
			matrix[j][i] = temp
		}
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < columns/2; j++ {
			temp := matrix[i][j]
			matrix[i][j] = matrix[i][columns-1-j]
			matrix[i][columns-1-j] = temp
		}
	}
}

func rotate2(matrix [][]int) {
	len := len(matrix)

	for row := 0; row < len/2; row++ {
		newLen := len - row*2

		for j := 0; j < newLen-1; j++ {
			temp := matrix[row][row+j]
			matrix[row][row+j] = matrix[len-1-row-j][row]
			matrix[len-1-row-j][row] = matrix[len-1-row][len-row-1-j]
			matrix[len-1-row][len-row-1-j] = matrix[row+j][len-1-row]
			matrix[row+j][len-1-row] = temp
		}
	}
}
