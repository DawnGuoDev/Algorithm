package ACSecond;

class FibSecond {

    public int fib(int N) {
       return (int)((Math.pow((1+ Math.sqrt(5)) / 2, N) - Math.pow((1 - Math.sqrt(5)) / 2, N)) / Math.sqrt(5)); 
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        
        int[][] mat = new int[][]{{1, 1}, {1, 0}};

        fibRe(mat, N - 1);
        return mat[0][0];
    }

    public void fibRe(int[][] mat, int n) {
        if (n <= 1) {
            return;
        }

        fibRe(mat, n / 2);
        multiMat(mat, mat);

        if (n % 2 == 1) {
            multiMat(mat, new int[][]{{1, 1}, {1, 0}});
        }
    }

    public void multiMat(int[][] mat1, int[][] mat2) {
        int re00 = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int re01 = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int re10 = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int re11 = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
        
        mat1[0][0] = re00;
        mat1[0][1] = re01;
        mat1[1][0] = re10;
        mat1[1][1] = re11;
    }
    public static void main(String[] args) {
        FibSecond fib = new FibSecond();
        System.out.println(fib.fib(0));
        System.out.println(fib.fib(2));
        System.out.println(fib.fib(3));

        System.out.println(fib.fib2(0));
        System.out.println(fib.fib2(2));
        System.out.println(fib.fib2(3));
    }
}