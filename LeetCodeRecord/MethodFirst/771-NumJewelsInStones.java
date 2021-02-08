package MethodFirst;

import java.util.HashMap;
import java.util.Map;

class NumJewelsInStones {
    public int numJewelInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int count = 0;
        for (int i = 0; i < jewels.length(); i ++) {
            char ch =  jewels.charAt(i);
            if (map.containsKey(ch)) {
                count += map.get(ch);
            }
        }

        return count;
    }
}
