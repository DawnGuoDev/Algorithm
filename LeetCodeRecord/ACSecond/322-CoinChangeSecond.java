package ACSecond;

import java.util.LinkedList;
import java.util.Queue;

class CoinChangeSecond {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(amount);
        visited[amount] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int coin : coins) {
                    int temp = num - coin;
                    
                    if (temp < 0 || visited[temp] == true) {
                        continue;
                    }

                    if (temp == 0) {
                        return count;
                    }

                    queue.offer(temp);
                    visited[temp] = true;
                }
            } 
            count ++;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        CoinChangeSecond cc = new CoinChangeSecond();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
    }
}