package main

var visited [][]bool
var rows int
var columns int

func exist(board [][]byte, word string) bool {
	rows = len(board)
	if rows == 0 {
		return false
	}
	columns = len(board[0])

	visited = make([][]bool, rows)

	for i := 0; i < rows; i++ {
		visited[i] = make([]bool, columns)
	}

	for i := 0; i < rows; i++ {
		for j := 0; j < columns; j++ {
			if dfs(board, i, j, word, 0) {
				return true
			}
		}
	}

	return false
}

func dfs(board [][]byte, row, column int, word string, index int) bool {
	if row < 0 || row >= rows {
		return false
	}

	if column < 0 || column >= columns {
		return false
	}

	if visited[row][column] {
		return false
	}

	if board[row][column] != word[index] {
		return false
	}

	if index == len(word)-1 {
		return true
	}

	visited[row][column] = true

	if dfs(board, row+1, column, word, index+1) {
		return true
	}

	if dfs(board, row-1, column, word, index+1) {
		return true
	}

	if dfs(board, row, column+1, word, index+1) {
		return true
	}

	if dfs(board, row, column-1, word, index+1) {
		return true
	}

	visited[row][column] = false

	return false
}
