package ACSecond;

class Maxprofit2Second {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int i = 0;
        int count = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            min = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            max = prices[i];
            
            count = count + (max - min);
        }

        return count;
    }

    public static void main(String[] args) {
        Maxprofit2Second mp = new Maxprofit2Second();
        System.out.println(mp.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(mp.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(mp.maxProfit(new int[]{2, 2}));
    }
}