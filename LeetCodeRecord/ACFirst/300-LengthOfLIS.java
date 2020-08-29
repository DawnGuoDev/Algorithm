package ACFirst;

class LengthOfLIS {
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // dp 数组
        int[] dp = new int[nums.length];
         
        // base case
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 动态规划迭代
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }
    
    /**
     * 贪心 + 二分查找
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // increasing 数组
        int[] inc = new int[nums.length];
        inc[0] = nums[0];
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > inc[end]) {
                inc[end + 1] =  nums[i];
                end ++;
            } else {    // 二分查找的方式，找到第一个大于 nums[i] 的数
                int middle = end >> 1;
                int beginTemp = 0;
                int endTemp = end;
                while (beginTemp < endTemp) {
                    if (inc[middle] < nums[i]) {
                        beginTemp = middle + 1;
                    } else {
                        endTemp = middle;
                    }

                    middle = ((endTemp - beginTemp) >> 1) + beginTemp;
                }

                inc[beginTemp] = nums[i];
            }
        }

        return end + 1;
    }
    public static void main(String[] args) {
        LengthOfLIS lol = new LengthOfLIS();
        System.out.println(lol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lol.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(lol.lengthOfLIS2(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}