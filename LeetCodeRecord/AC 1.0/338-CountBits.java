import java.util.Arrays;

class CountBits {
    
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        
        // 动态规划迭代
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i % 2);
        }

        return dp;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i-1)] + 1;
        }

        return dp;
    }

    public int[] countBits3(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i *= 2) {
            for (int j = 0; j < i && (j + i) <= num; j++) {
                dp[j + i] = dp[j] + 1;
            }
        }
        
        return dp;
    } 

    public static void main(String[] args) {
        CountBits cb = new CountBits();
        System.out.println(Arrays.toString(cb.countBits2(5)));
        System.out.println(Arrays.toString(cb.countBits3(5)));
    }

}