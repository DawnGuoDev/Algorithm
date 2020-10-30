package MethodFirst;

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftMulti = new int[len];
        int[] rightMulti = new int[len];
        leftMulti[0] = 1;
        rightMulti[len - 1] = 1;

        for (int i = 1; i <= len - 1; i++) {
            leftMulti[i] = leftMulti[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMulti[i] = rightMulti[i + 1] * nums[i + 1];
        }

        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[i] = leftMulti[i] * rightMulti[i];
        }

        return output;
    }    
    
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];

        output[0] = 1;
        for (int i = 1; i <= len - 1; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            output[i] = output[i] * temp;
        }

        return output;
    }
}
