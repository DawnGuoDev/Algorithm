package ACFirst;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int max = 1;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }

            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.println(lols.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lols.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lols.lengthOfLongestSubstring("pwwkew"));
    }
}