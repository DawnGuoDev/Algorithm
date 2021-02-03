package main

func kthSmallest(matrix [][]int, k int) int {
	row := len(matrix)

	left := matrix[0][0]
	right := matrix[row-1][row-1]

	for left < right {
		mid := left + ((right - left) >> 1)
		amount := count(matrix, mid, row)

		if amount >= k {
			right = mid
		} else if amount < k {
			left = mid + 1
		}
	}

	return left
}

// 返回小于等于 num 的数量
func count(matrix [][]int, num, len int) int {
	i := len - 1
	j := 0
	count := 0

	for i >= 0 && j < len {
		if matrix[i][j] <= num {
			count += (i + 1)
			j++
		} else {
			i--
		}
	}

	return count
}
