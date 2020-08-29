package ACFirst;

class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }

        // dp 数组
        int[] dp = new int[nums.length];

        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 动态规划转移
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    /**
     * 空间优化版本
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }


        // base case
        int num1 = nums[0];
        int num2 = Math.max(nums[0], nums[1]);
        int max = num2;

        // 动态规划转移
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(num1 + nums[i], num2);
            num1 = num2;
            num2 = max;
        }

        return max;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));        
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));        
        System.out.println(rob.rob(new int[]{}));        

        System.out.println(rob.rob2(new int[]{1, 2, 3, 1}));        
        System.out.println(rob.rob2(new int[]{2, 7, 9, 3, 1}));        
        System.out.println(rob.rob2(new int[]{}));        
    }
}