package MethodFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            // String key = chs.toString();
            String key = new String(chs);
            List list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            int[] tempRes = new int[26];
            for (char ch : chs) {
                tempRes[ch - 'a']++;
            }

            StringBuffer strBuffer =  new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (tempRes[i] == 0) {
                    continue;
                }

                strBuffer.append((char)(i+'a') + "" + tempRes[i]);
            }

            String key = strBuffer.toString();

            List list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}