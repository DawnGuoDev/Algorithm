package ACFirst;

class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        StringBuffer sb;

        for (int i = 0; i < n - 1; i++) {
            sb = new StringBuffer();

            int j = 0;  // 相同字母的区域的开始指针
            int t = 0;  // 不断移动的指针
            while (t < res.length()) {
                if (res.charAt(t) != res.charAt(j)) {
                    sb.append(t - j);
                    sb.append(res.charAt(j));
                    j = t;
                }
                t++;
            }
            sb.append(t - j);
            sb.append(res.charAt(j));

            res = new String(sb);
        }

        return res;
    }

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        StringBuffer sb;

        for (int i = 0; i < n - 1; i++) {
            sb = new StringBuffer();

            int j = 0;  // 相同字母的区域的开始指针
            while (j < res.length()) {
                int t = j;
                while (t < res.length() && res.charAt(t) == res.charAt(j)) {
                    t++;
                }

                sb.append(t - j);
                sb.append(res.charAt(j));

                j = t;
            }

            res = new String(sb);
        }

        return res;
    }
    
    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(2));
        System.out.println(cas.countAndSay(5));
        System.out.println(cas.countAndSay2(2));
        System.out.println(cas.countAndSay2(5));
    }
}

