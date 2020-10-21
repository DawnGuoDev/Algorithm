package MethodFirst;

class MyPow {
    public double myPow(double x, int n) {
        if (x  == 0.0d) {
            return 0.0d;
        }

        long num = n;
        if (num < 0) {
            num = -num;
            x = 1 / x;
        }
        
        double res = 1.0;
        while (num > 0) {
            if ((num & 1) == 1) {
                res *= x;
            }

            x = x * x;
            num = num >> 1;
        }

        return res;
    }
}
