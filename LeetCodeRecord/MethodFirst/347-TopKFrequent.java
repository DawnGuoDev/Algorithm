package MethodFirst;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer v1, Integer v2) {
                return map.get(v1) - map.get(v2);
            }
        });

        // 先 hash 统计一下频率
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 小顶堆，寻找频率最高的 k 个数
        for (int num : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                int tmp = pq.peek();
                if (map.get(num) > map.get(tmp)) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - i - 1] = pq.poll();
        }

        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] v1, int[] v2) {
                return v1[1] - v2[1];
            }
        });

        // 先 hash 统计一下频率
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 小顶堆，寻找频率最高的 k 个数
        for (int num : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(new int[]{num, map.get(num)});
            } else {
                int[] tmp = pq.peek();
                if (map.get(num) > tmp[1]) {
                    pq.poll();
                    pq.offer(new int[]{num, map.get(num)});
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - i - 1] = pq.poll()[0];
        }

        return res;
    } 

}
