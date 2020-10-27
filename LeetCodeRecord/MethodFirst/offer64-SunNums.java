package MethodFirst;

class SunNums {
    private int sum = 0;

    public int sumNums(int n) {
        boolean temp = n > 1 && sumNums(n - 1) > 0;

        sum += n;

        return sum;
    }
}
