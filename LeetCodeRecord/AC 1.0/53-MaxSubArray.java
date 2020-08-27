class MaxSubArray {
    
    public int maxSubArray(int[] nums) {
        // dp 数组
        int[] dp = new int[nums.length];

        // base case
        dp[0] = nums[0];

        // 动态规划迭代
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            if (max < dp[i]) {
                max = dp[i];                
            }
        }

        return max;
    }

    /**
     * 分治法求解
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int[] result = this.subArray(nums, 0, nums.length - 1);

        return Math.max(Math.max(Math.max(result[0], result[1]), result[2]), result[3]);
    
    }

    public int[] subArray(int[] nums, int begin, int end) {
        if (begin >= end) {
            return new int[]{nums[begin], nums[begin], nums[begin], nums[begin]};
        }        

        int middle = ((end - begin) >> 1) + begin;
        int[] result1 = this.subArray(nums, begin, middle);
        int[] result2 = this.subArray(nums, middle + 1, end);

        int leftMax = Math.max(result1[0], result1[2] + result2[0]);
        int rightMax = Math.max(result2[1], result2[2] + result1[1]);
        int sum = result1[2] + result2[2];
        int middleMax = Math.max(Math.max(result1[3], result2[3]), result1[1] + result2[0]);
        
        return new int[]{leftMax, rightMax, sum, middleMax};
    }
    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        System.out.println(msa.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(msa.maxSubArray2(new int[]{31,-41,59,26,-53,58,97,-93,-23,84}));
    }
}