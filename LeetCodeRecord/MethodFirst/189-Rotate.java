package MethodFirst;

class Rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        int count = 0;
        for (int startIndex = 0; count < len; startIndex++) {             
            int currIndex = startIndex;
            int preNum = nums[currIndex];
            do {
                int nextIndex = (currIndex + k) % len;
                int tempNum = nums[nextIndex];
                nums[nextIndex] = preNum;
                currIndex = nextIndex;
                preNum = tempNum;
                count++;
            } while (currIndex != startIndex);
        }
    }    

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 整个数组翻转
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            right--;
            left++;
        }

        k = k % len;
        
        // 翻转前半部，也就是 [0-k)
        left = 0;
        right = k - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            right--;
            left++;
        }
        
        // 翻转后半部
        left = k;
        right = len - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            right--;
            left++;
        }
    }
}
