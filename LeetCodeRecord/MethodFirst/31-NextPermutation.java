package MethodFirst;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;

        while (i >= 0) {
            if (nums[i] < nums[j])  {
                break;
            }
            
            i--;
            j--;
        }

        if (i >= 0) {
            while (k >= j) {
                if (nums[k] > nums[i]) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;

                    break;
                }

                k--;
            }
        }
    
        i = nums.length - 1;
        while (j < i) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            j++;
            i--;
        }
    }  
}
