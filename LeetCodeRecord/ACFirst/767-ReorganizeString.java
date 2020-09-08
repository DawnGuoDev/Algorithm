package ACFirst;

class ReorganizeString {
    public String reorganizeString(String S) {
        int[] map = new int[26];
        char[] chs = S.toCharArray();
        char[] res = new char[S.length()];

        // 求各字符的情况
        for (char ch : chs) {
            map[ch - 'a'] ++;
        }
        
        // 找字符最大的情况
        int max = 0;    // 记录数量最大的字符的数量
        char maxCh = 0;  // 记录最大字符
        for (int i = 0; i < 26; i++) {
            if (map[i] > max) {
                max = map[i];
                maxCh = (char)(i + 'a');
            }
        }

        // max 比 chs.length/2 都要大的话，那么是不存在的
        if (max > ((chs.length + 1) >> 1)) {
            return "";
        }
        
        int m = 0;  // 记录存放的位置
        for (int i = 0; i < max; i++) {
            res[m] = maxCh;
            m += 2;
        }

        map[maxCh - 'a'] = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map[i]; j++) {
                char ch = (char)('a' + i);
                if (m >= chs.length) {
                    m = 1;
                }
                res[m] = ch;
                m += 2;
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("aab"));
        System.out.println(rs.reorganizeString("aaab"));
        System.out.println(rs.reorganizeString("abbabbaaab"));
    }

}