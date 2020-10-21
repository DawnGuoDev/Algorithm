package MethodFirst;

class FindMin {
    public int findMin(int[] nums) {
        int len = nums.length;
        
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            } else {
                int index = left;
                for (int i = left + 1; i < right; i++) {
                    if (nums[i] < nums[index]) {
                        index = i;
                    }
                }    
                
                return nums[index];
            }
        }

        return nums[left];
    }

    
}
