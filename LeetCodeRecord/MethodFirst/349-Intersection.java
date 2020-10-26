package MethodFirst;

import java.lang.reflect.Array;
import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<Integer>();
        for (int num : nums1) {
            nums1Set.add(num);
        }

        Set<Integer> resSet = new HashSet<Integer>();
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                resSet.add(num);
            }
        }
        
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            res[i++] = num;
        }

        return res;
    }    
}
