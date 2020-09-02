package ACFirst;

class ReverseWords {
    public String reverseWords(String s) {
        String sTemp = s.trim();
        String[] words = sTemp.split(" ");
        StringBuffer result = new StringBuffer();    
        
        for (int i = words.length - 1; i >=0; i--) {
            if (words[i].equals("") || words[i].equals(" ")) {
                continue;
            }
            result.append(words[i] + " ");
        }    

        return new String(result).trim();
    }

    public String reverseWords2(String s) {
        int sLen = s.length();
        StringBuffer result = new StringBuffer();
        
        int i = sLen - 1;
        int j = i;
        
        while (i >= 0) {
            while (i >=0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return new String(result).trim();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords("the sky is blue"));
        System.out.println(rw.reverseWords("  hello world!   "));
        System.out.println(rw.reverseWords("a good   example"));

        System.out.println(rw.reverseWords2("the sky is blue"));
        System.out.println(rw.reverseWords2("  hello world!   "));
        System.out.println(rw.reverseWords2("a good   example"));
    }
}
