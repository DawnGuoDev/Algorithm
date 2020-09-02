package ACFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> record = new HashSet<>();
        HashSet<String> out = new HashSet<>();
        int LEN = 10;

        for (int i = 0; i < s.length() - LEN + 1; i++) {
            if (record.contains(s.substring(i, i + LEN))) {
                out.add(s.substring(i, i + LEN));
            } else {
                record.add(s.substring(i, i + LEN));
            }
        } 
        
        return new ArrayList<>(out);
    } 

    public List<String> findRepeatedDnaSequences2(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int LEN = 10;
        
        for (int i = 0; i < s.length() - LEN + 1; i++) {
            String temp = s.substring(i, i + LEN);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        List<String> list = new ArrayList<>();
        for (String s1String : map.keySet()) {
            if (map.get(s1String) > 1) {
                list.add(s1String);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences frds = new FindRepeatedDnaSequences();
        List<String> ss = frds.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : ss) {
            System.out.println(s);
        }
        List<String> ss2 = frds.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : ss2) {
            System.out.println(s);
        }

    }
    
}
