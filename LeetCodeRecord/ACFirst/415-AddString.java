package ACFirst;

class AddString {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carray = 0;
        StringBuffer res = new StringBuffer();

        while (i >= 0 || j >= 0) {  // 需要将两个字符串都遍历完，才算加法结束
            int n1 = i >= 0 ? num1.charAt(i) - '0': 0;   // 如果 i >= 0，那么则表示未遍历完 num1
            int n2 = j >= 0 ? num2.charAt(j) - '0': 0;
            int sum = n1 + n2 + carray;
            res.append(sum % 10);
            carray = sum / 10;
            i--;
            j--;
        }

        if (carray == 1) {
            res.append(1);
        }

        return new String(res.reverse());
    }
    
    public static void main(String[] args) {
        AddString as = new AddString();
        System.out.println(as.addStrings("123", "123"));
    }
}
