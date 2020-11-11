package MethodFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> merge = new ArrayList<int[]>();

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (i == 0 || merge.get(merge.size() - 1)[1] < left) {
                merge.add(intervals[i]);
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(right, merge.get(merge.size() - 1)[1]);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }    
}
