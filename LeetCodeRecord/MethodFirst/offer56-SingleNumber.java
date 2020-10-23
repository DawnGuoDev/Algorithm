package MethodFirst;

class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += (num & 1);
                num >>= 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            counts[i] = counts[i] % 3;
        }

        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i];
        }
        
        return res;
    }
}
