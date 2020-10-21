package  MethodFirst;

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int columns = matrix[0].length;

        int rowNum = 0;
        int colNum = columns - 1;
        while (rowNum < rows && colNum >= 0) {
            if (target > matrix[rowNum][colNum]) {
                rowNum ++;
            } else if (target < matrix[rowNum][colNum]) {
                colNum --;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    
    }
}