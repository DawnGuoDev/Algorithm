package MethodFirst;

class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
