package MethodFirst;

class Exist {
    private boolean[][] marked;
    private int rows;
    private int columns;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.columns = board[0].length;

        this.marked = new boolean[this.rows][this.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (dfs(i, j, board, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int column, char[][] board, int wordIndex, String word) {
        if (row < 0 || row >= this.rows) {
            return false;
        }

        if (column < 0 || column >= this.columns) {
            return false;
        }

        if (this.marked[row][column] == true) {
            return false;
        }

        if (wordIndex == word.length() - 1) {
            return board[row][column] == word.charAt(wordIndex);
        }

        if (word.charAt(wordIndex) == board[row][column]) {
            this.marked[row][column] = true;
            
            if (dfs(row - 1, column, board, wordIndex + 1, word)) {
                return true;
            }

            if (dfs(row, column + 1, board, wordIndex + 1, word)) {
                return true;
            }

            if (dfs(row + 1, column, board, wordIndex + 1, word)) {
                return true;
            }

            if (dfs(row, column - 1, board, wordIndex + 1, word)) {
                return true;
            }
        }

        this.marked[row][column] =  false;

        return false;
    }
}
