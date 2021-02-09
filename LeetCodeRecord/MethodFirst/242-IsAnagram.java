package MethodFirst;

import java.lang.reflect.Array;
import java.util.Arrays;

class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sch = s.toCharArray();
        Arrays.sort(sch);
        char[] tch = t.toCharArray();
        Arrays.sort(tch);

        return new String(sch).compareTo(new String(tch)) == 0;
    }

    public boolean Anagram2(String s, String t) {
        int[] counts = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
