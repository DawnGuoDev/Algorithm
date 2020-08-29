package ACFirst;

class CanPartition {
    
    public boolean canPartition(int[] nums) {
        
        // 计算总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 奇数肯定不能拆分
        if (sum % 2 == 1) {
            return false;
        }

        // dp 数组
        sum = sum >> 1;
        boolean[] dp = new boolean[sum + 1];
        
        // base case
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];   // 同样需要考虑取或不取
                
                if (dp[sum] == true) {
                    return true;
                }
            }
        }
        
        return dp[sum];
    }

    public boolean canPartition2(int[] nums) {
        // 计算总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 如果是奇数，那肯定不能拆分
        if (sum % 2 == 1) {
            return false;
        }

        // dp 数组
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];

        // base case 
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= sum / 2; j++) {
            if (j == nums[0]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                // 取 item i
                if (j - nums[i] >= 0 && dp[i-1][j - nums[i]] == true) {
                    dp[i][j] = true; 
                } else if (dp[i-1][j] == true){
                    dp[i][j] =  true;
                }

                if (dp[i][sum / 2] == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CanPartition cp = new CanPartition();
        // System.out.println(cp.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(cp.canPartition(new int[]{23,13,11,7,6,5,5}));
        System.out.println(cp.canPartition2(new int[]{23,13,11,7,6,5,5}));
    }
}