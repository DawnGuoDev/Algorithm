package ACFirst;

class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        // dp 数组
        int[] dp = new int[nums.length];

        // base case
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    
                    if (dp[i] == 3) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    // 双指针方法
    public boolean increasingTriplet2(int[] nums){
        if (nums.length <= 2) {
            return false;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {  // 这边要取等于，针对这种情况 [1, 1, 1, 1, 1]
                min1 = nums[i];
            } else if (nums[i] <= min2) {   // 同上
                min2 = nums[i];
            } else {
                return true;
            }
        }
        
        return false;
    }

    public boolean increasingTriplet3(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;  
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min1) {
                min1 = nums[i];
            } else if (nums[i] > min1 && nums[i] < min2){
                min2 = nums[i];
            } else if (nums[i] > min2) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        IncreasingTriplet it = new IncreasingTriplet();
        System.out.println(it.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(it.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(it.increasingTriplet2(new int[]{5,4,3,2,1}));
        System.out.println(it.increasingTriplet3(new int[]{5,4,3,2,1}));
        System.out.println(it.increasingTriplet3(new int[]{1,1,1,1,1}));
    }
    
}