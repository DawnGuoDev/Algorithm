package ACFirst;

class ReplaceSpace {
    public String replaceSpace(String s) {
        int sLen = s.length();
        char[] sNew = new char[3 * sLen];
        int size = 0;

        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == ' ') {
                sNew[size++] = '%';
                sNew[size++] = '2';
                sNew[size++] = '0';
            } else {
                sNew[size++] = s.charAt(i);
            }
        }

        return new String(sNew, 0, size);
    }

    public String replaceSpace2(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace("We are happy."));
        System.out.println(rs.replaceSpace2("We are happy."));
    }
}