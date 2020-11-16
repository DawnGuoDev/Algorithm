package main

func spiraOrder(matrix [][]int) []int {
	res := []int{}

	rows := len(matrix)
	if rows == 0 {
		return res
	}
	columns := len(matrix[0])

	rowTop := 0
	rowBottom := rows - 1
	columnLeft := 0
	columnRight := columns - 1

	for rowTop <= rowBottom && columnLeft <= columnRight {
		// 从左到右
		for i := columnLeft; i <= columnRight; i++ {
			res = append(res, matrix[rowTop][i])
		}
		rowTop++
		if rowTop > rowBottom {
			break
		}

		// 从上到下
		for i := rowTop; i <= rowBottom; i++ {
			res = append(res, matrix[i][columnRight])
		}
		columnRight--
		if columnRight < columnLeft {
			break
		}

		// 从右到左
		for i := columnRight; i >= columnLeft; i-- {
			res = append(res, matrix[rowBottom][i])
		}
		rowBottom--
		if rowBottom < rowTop {
			break
		}

		// 从下到上
		for i := rowBottom; i >= rowTop; i-- {
			res = append(res, matrix[i][columnLeft])
		}
		columnLeft++
		if columnLeft > columnRight {
			break
		}
	}

	return res
}
