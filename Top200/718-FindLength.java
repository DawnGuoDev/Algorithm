package Top200;

class FindLength {
    public int findLength(int[] A, int[] B) {
        // dp 数组
        int[][] dp = new int[A.length][B.length];

        // 初始化
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        } 

        for (int i = 0; i < B.length; i++) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
                max = 1;
            }
        }

        // dp 迭代
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public int findLength2(int[] A, int[] B) {
        
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int num = find(A, i, B, 0, Math.min(B.length, A.length - i));
            if (num > max) {
                max = num;
            }
        }

        for (int i = 1; i < B.length; i++) {
            int num = find(A, 0, B, i, Math.min(A.length, B.length - i));
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public int find(int[] A, int ABegin, int[] B, int BBegin, int len) {
       
        int max = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (A[ABegin + i] == B[BBegin + i]) {
                k++;
            } else {
                k = 0;
            }
            if (max < k) {
                max = k;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindLength fl = new FindLength();
        System.out.println(fl.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(fl.findLength2(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(fl.findLength2(new int[]{5, 14, 53, 80, 48}, new int[]{50, 47, 3, 80, 83}));
    }
}