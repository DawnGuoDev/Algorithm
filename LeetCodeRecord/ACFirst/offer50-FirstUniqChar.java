package ACFirst;

import java.util.LinkedHashMap;
import java.util.Map;

class FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] map = new int[26];
        // 第一次遍历先计数
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        
        // 第二次遍历返回第一个
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) {
                map.put(ch, false);
            } else {
                map.put(ch, true);
            }
        }

        for (char ch : map.keySet()) {
            if (map.get(ch)) {
                return ch;
            }
        }        
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar fu = new FirstUniqChar();
        System.out.println(fu.firstUniqChar("abaccdeff"));
        System.out.println(fu.firstUniqChar(""));

        System.out.println(fu.firstUniqChar2("abaccdeff"));
        System.out.println(fu.firstUniqChar2(""));
    }


}
