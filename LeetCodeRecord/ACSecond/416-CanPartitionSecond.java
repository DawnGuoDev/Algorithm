package ACSecond;

class CanPartitionSecond {
    
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;

        // dp 数组
        boolean[] dp = new boolean[sum + 1];

        // base case
        dp[0] = true;
        
        // 动态规划迭代
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];

                if (dp[sum]) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        CanPartitionSecond cp = new CanPartitionSecond();
        System.out.println(cp.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(cp.canPartition(new int[]{1, 2, 3, 5}));
    }
}