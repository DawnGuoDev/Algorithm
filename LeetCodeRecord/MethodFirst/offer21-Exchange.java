package MethodFirst;

class Exchange {

    // 快慢双指针
    public int[] exchange(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }

    // 首尾双指针
    public int[] exchange2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while ((nums[left] & 1) == 1 && left < right) {
                left ++;
            }    

            while ((nums[right] & 1) == 0 && left < right) {
                right --;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}

