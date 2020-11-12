package MethodFirst;

class Rotate2 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        
        for (int times = 0; times < len /2; times++) {
            int tempLen = len - 1 - 2 * times;
            for (int j = 0; j < tempLen; j++) {
                int temp = matrix[times][times + j];
                matrix[times][times + j] = matrix[len - 1 - times - j][times];
                matrix[len - 1 - times - j][times] = matrix[len - 1 - times][len - 1 - times - j];
                matrix[len - 1 - times][len - 1 - times - j] = matrix[times + j][len - 1 - times];
                matrix[times + j][len - 1 - times] = temp;
            }
        }
    }    

    public void rotate2(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
