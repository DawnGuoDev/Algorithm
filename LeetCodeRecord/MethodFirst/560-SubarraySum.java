package MethodFirst;

import java.util.HashMap;
import java.util.Map;

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i + 1; j <= nums.length; j++) {
                sum += nums[j - 1];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }    

    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSums = new int[len + 1];

        preSums[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left + 1; right <= len; right++) {
                if (preSums[right] - preSums[left] == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public int subarraySum3(int[] nums, int k) {
        int preSum = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            } 

            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }

        return count;
    }
}
