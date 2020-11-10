package MethodFirst;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return i;
    }    

    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public int missingNumber3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == mid) {
                left =  mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
