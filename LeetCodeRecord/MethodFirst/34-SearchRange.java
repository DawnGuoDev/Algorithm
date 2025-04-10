package MethodFirst;

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // 先找右边界
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        if(j < 0 || nums[j] != target) {
            return new int[]{-1, -1};
        }

        i = 0;
        j = nums.length - 1;
        // 找左边界
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        int left = j;

        return new int[]{left + 1, right - 1};
    }
}
