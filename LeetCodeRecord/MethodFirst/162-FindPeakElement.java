package MethodFirst;

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = ((j - i) >> 1) + i;
            if ((mid - 1) >= 0 && (mid + 1) < nums.length && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if ((mid + 1) < nums.length && nums[mid + 1] > nums[mid]){
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return i;
    }  
}
