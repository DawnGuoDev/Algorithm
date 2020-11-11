package MethodFirst;

class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        
        while (j < nums.length) {
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }

            j++;
        }

        j = i;
        while (j < nums.length) {
            if (nums[j] == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }

            j++;
        }
    }
    
    public void sortColors2(int[] nums) {
        // [0, p1) 0
        // [p1, p2) 1
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;

                p1++;
                p2++;
            } else if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                
                p2 ++;
            }

            i++;
        }
    }
}