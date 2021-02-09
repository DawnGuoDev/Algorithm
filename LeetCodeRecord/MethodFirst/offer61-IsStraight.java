package MethodFirst;

import java.util.HashSet;
import java.util.Set;

class IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<Integer>();
        int max = -1;
        int min = 14;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (repeat.contains(num)) {
                return false;
            }
            
            max = Math.max(max, num);
            min = Math.min(min, num);

            repeat.add(num);
        }

        return max - min < 5;
    }    
}
