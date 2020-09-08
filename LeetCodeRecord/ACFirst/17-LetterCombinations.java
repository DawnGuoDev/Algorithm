package ACFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }

        Map<Character, String> keyMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        StringBuffer combination = new StringBuffer();
        
        getCombinations(keyMap, res, digits, 0, combination);
        return res;
    }
    
    public void getCombinations(Map<Character, String> keyMap, List<String> res, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            res.add(combination.toString());
            return;
        }

        char ch = digits.charAt(index);
        String s = keyMap.get(ch);

        for (int i = 0; i < s.length(); i++) {
            combination.append(s.charAt(i));
            getCombinations(keyMap, res, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        List<String> ls =  lc.letterCombinations("23");
        for (String s : ls) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}