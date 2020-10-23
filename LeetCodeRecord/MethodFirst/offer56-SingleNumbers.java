package MethodFirst;

class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        int div = 1;
        while ((ret & div) == 0) {
            div <<= 1;
        }

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & div) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }    

}
