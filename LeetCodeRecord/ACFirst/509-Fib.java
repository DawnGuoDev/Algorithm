package ACFirst;

class Fib {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }
        // dp 数组
        int[] dp = new int[N+1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
   }
    
   public int fib2(int N) {
       if (N == 0) {
           return 0;
       }
       
       if (N == 1) {
           return 1;
       }

       int num1 = 0;
       int num2 = 1;
       int sum = 0;
       for (int i = 2; i <= N; i++) {
           sum = num1 + num2;
           num1 = num2;
           num2 = sum;
       }

       return sum;
   }

   public int fib3(int N) {
       if (N == 0 || N == 1) {
           return N;
       }

       return fib3(N-1) + fib3(N-2);
   }

   
   public int fib4(int N) {
       int[] mem = new int[N+1];

       return fibRe(N, mem);
   }

   public int fibRe(int N, int[] mem) {
        if (N == 0 || N == 1) {
            return N;
        }
        if (mem[N] != 0) {
            return mem[N];
        }

        mem[N] = fibRe(N-1, mem) + fibRe(N-2, mem);

        return mem[N];
   }


   public int fib5(int N) {
        return (int)((Math.pow((1+Math.sqrt(5))/2, N) - Math.pow((1-Math.sqrt(5))/2, N))/Math.sqrt(5));
   }

   public int fib6(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        int[][] result = new int[][]{{1, 1}, {1, 0}};
        
        this.fibMat(result, N - 1);

        return result[0][0];
   }

   public void fibMat(int[][] mat, int N) {
        if (N <= 1) {
            return;
        }

        fibMat(mat, N / 2);
        multiply(mat, mat);

        if (N % 2 == 1) {
            multiply(mat, new int[][]{{1, 1}, {1, 0}});
        }
   }
   
   public void multiply(int[][] mat1, int[][] mat2) {
       int x = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
       int y = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
       int z = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
       int t = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
       
       mat1[0][0] = x;
       mat1[0][1] = y;
       mat1[1][0] = z;
       mat1[1][1] = t;
   }

   public static void main(String[] args) {
        Fib f = new Fib();
        System.out.println(f.fib6(0));
        System.out.println(f.fib6(3));
        System.out.println(f.fib6(4));
   }
}