package MethodFirst;

class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];

        for (int num : nums) {
            if (count[num] == 1) {
                return num;
            } else {
                count[num] = 1;
            }
        }

        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;                
            }
        }

        return -1;
    }
}
