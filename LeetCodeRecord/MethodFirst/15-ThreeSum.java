package MethodFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }

            if ( i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    
                    while (left < right && nums[left] == nums[left+1]) {
                        left ++;
                    }

                    while (left < right && nums[right] == nums[right-1]) {
                        right --;
                    }
                    
                    left ++;
                    right--;
                } else if (sum < 0) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return res;
    }    
}
