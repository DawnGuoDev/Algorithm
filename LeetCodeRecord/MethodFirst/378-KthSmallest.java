package MethodFirst;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] v1, int[] v2) {
                return v1[0] - v2[0];
            }
        });

        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 1; i < k; i++) {
            int[] tmp = pq.poll();
            if (tmp[2] < len - 1) {
                pq.offer(new int[]{matrix[tmp[1]][tmp[2] + 1], tmp[1], tmp[2]+1});
            }
            
        }

        return pq.poll()[0];
    }
}