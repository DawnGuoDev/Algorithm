package MethodFirst;

import java.util.Comparator;
import java.util.PriorityQueue;

class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });

        for (int i = 0; i < len; i++) {
            queue.offer(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        
        return res;
    }    

    public int[] getLeastNumbers2(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        quick(arr, 0, len - 1, k - 1);
        
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    public void quick(int[] arr, int left, int right, int k) {
        int splitIndex = split(arr, left, right);
        if (splitIndex == k) {
            return;
        } else if (splitIndex < k) {
            quick(arr, splitIndex + 1, right, k);
        } else {
            quick(arr, left, splitIndex - 1, k);
        }
    }

    public int split(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int num = arr[right];

        while (i < j) {
            while (arr[i] <= num && i < j) {
                i ++;
            }
            
            while (arr[j] >= num && i < j) {
                j --;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] =  temp;
        }
        
        arr[right] = arr[i];
        arr[i] = num;

        return i;
    }
}
