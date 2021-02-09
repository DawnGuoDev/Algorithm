package MethodFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] v1, int[] v2) {
                // if (v1[0] < v2[0]) {
                //     return 1;
                // } else if (v1[0] > v2[0]) {
                //     return -1;
                // }

                // return v1[1] - v2[1];

                return v1[0] == v2[0] ? v1[1]-v2[1] : v2[0] - v1[0];
            }
        });
        
        List<int[]> res = new ArrayList<int[]>();
        for (int[] p : people) {
            if (res.size() <= p[1]) {
                res.add(p);
            } else {
                res.add(p[1], p);
            }
        }

        return res.toArray(new int[people.length][2]);
    }    
}
