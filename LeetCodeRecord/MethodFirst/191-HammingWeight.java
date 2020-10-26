package MethodFirst;

class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res ++;
            }
            
            n >>= 1;
        }

        return res;
    }
    
    public int hammingWeight2(int n) {
        int res = 0;

        while (n != 0) {
            n &= (n-1);
            res ++;
        }

        return res;
    }
}