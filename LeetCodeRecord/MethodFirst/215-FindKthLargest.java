package MethodFirst;

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickFind(nums, 0, len - 1, k);

        return nums[k-1];
    }
    
    public void quickFind(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = left;
        int endNum = nums[right];
        while (j <= right) {
            if (nums[j] >= endNum) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            } else {
                j++;
            }
        }

        if (k == i) {
            return;
        } else if (k < i) {
            quickFind(nums, left, i - 2, k);
        } else {
            quickFind(nums, i, right, k);
        }
    }
}
