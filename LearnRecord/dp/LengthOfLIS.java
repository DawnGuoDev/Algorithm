package dp;

/**
 * LeetCode-300
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        // base case 
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        // 动态规划转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {  
                max = dp[i];
            }
        }
        return max;
    }  
    


    public static void main(String[] args) {
        LengthOfLIS lis = new LengthOfLIS();

        System.out.println(lis.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}