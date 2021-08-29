package Top200;

class MaxProduct {
    public int maxProduct(int[] nums) {
        // dp 数组
        int[][] dp = new int[nums.length][2];

        // base case
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        // 动态规划迭代
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(nums[i], nums[i] * dp[i - 1][0]), nums[i] * dp[i - 1][1]);
            dp[i][1] = Math.min(Math.min(nums[i], nums[i] * dp[i - 1][0]), nums[i] * dp[i - 1][1]);
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }

        return max;
    } 
    
    public static void main(String[] args) {
        MaxProduct mpd = new MaxProduct();
        System.out.println(mpd.maxProduct(new int[]{2, 3, -2, 4}));
    }
}