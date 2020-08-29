package ACSecond;

class UniquePathsSecond {
    
    public int uniquePaths(int m, int n) {

        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }

        long re1 = 1;
        for (int i = 1; i <= n - 1; i++) {
            re1 *= i;
        }

        long re2 = 1;
        for (int i = m; i <= m + n - 2; i++) {
            re2 *= i;
        }

        return (int)(re2/re1);
    }

    public static void main(String[] args) {
        UniquePathsSecond up = new UniquePathsSecond();
        System.out.println(up.uniquePaths(1, 1));        
        System.out.println(up.uniquePaths(10, 10));        
    }
}