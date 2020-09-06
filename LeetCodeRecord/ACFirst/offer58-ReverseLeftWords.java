package ACFirst;

class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s.length() <= n) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        ReverseLeftWords rlw = new ReverseLeftWords();
        System.out.println(rlw.reverseLeftWords("abcdefg", 2));
        System.out.println(rlw.reverseLeftWords("lrloseumgh", 6));
    }
}