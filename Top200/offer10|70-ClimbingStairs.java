package ACFirst;

class ClimbingStaris {

    public int climbStairs(int n) {
        
        int[] counts = new int[n+1];    // dp 数组

        // base case
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i <= n; i++) {
            counts[i] = counts[i-1] + counts[i-2];
        }

        return counts[n];    
    }

    /**
     * 空间优化版本
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        //base case
        int count1 = 1;
        int count2 = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = count1 + count2;
            count1 = count2;
            count2 = sum;
        }

        return sum;
    }
    
    
    public static void main(String[] args) {
        ClimbingStaris cs = new ClimbingStaris();
        System.out.println(cs.climbStairs(3));
    }
}