package MethodFirst;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] res;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;

            if (carry == 0) {
                break;
            }
        }

        if (carry == 1) {
            res = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 1; i < digits.length + 1; i++) {
                res[i] = digits[i - 1];
            }

            return res;
        }

        return digits;
    }
}
