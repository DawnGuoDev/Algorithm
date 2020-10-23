package MethodFirst;

import java.util.ArrayList;

class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        ArrayList<int[]> res = new ArrayList<>();

        while (left <= (target >> 1)) {
            if (sum < target) {
                sum += right;
                right ++;
            } else if (sum > target){
                sum -= left;
                left ++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);

                sum -= (left + left + 1);
                left += 2;
                sum += right;
                right++;       
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
