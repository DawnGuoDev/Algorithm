package ACSecond;

class MaxProductSecond {
    public int maxProduct(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        // dp 数组
        int[][] dp = new int[nums.length][2];

        // base case
        dp[0][0] = nums[0]; // 0 表示最大值
        dp[0][1] = nums[0]; // 1 表示最小值

        // 动态规划迭代
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(nums[i], nums[i] * dp[i - 1][0]), nums[i] * dp[i - 1][1]);
            dp[i][1] = Math.min(Math.min(nums[i], nums[i] * dp[i - 1][0]), nums[i] * dp[i - 1][1]);
            
            max = Math.max(dp[i][0], max);
        }

        return max;
    } 

    public static void main(String[] args) {
        MaxProductSecond mp = new MaxProductSecond();
        System.out.println(mp.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(mp.maxProduct(new int[]{-2, 0, -1}));
    }
    
}