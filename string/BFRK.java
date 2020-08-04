package string;

public class BFRK {
    
    /**
     * BF 算法实现字符串匹配
     * @param mString
     * @param sString
     * @return
     */
    public int bf(String mString, String sString) {
        int mLen = mString.length();
        int sLen = sString.length();
        char[] m = mString.toCharArray();
        char[] s = sString.toCharArray();

        for (int i = 0; i <= mLen-sLen; i++) {
            int j = 0;
            for (; j < sLen && m[i+j] == s[j]; j++) {
                
            }

            if (j == sLen) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 以 26 次方的方式计算 hash 值
     * @param s
     * @param sLen
     * @param table
     * @return
     */
    public long hashString(char[] s, int sLen, long[] table) {
        long hashNum = 0;
        for (int i = 0; i < sLen; i++) {
            hashNum += (s[i] - 'a')*table[sLen-1-i];
        }

        return hashNum;
    }

    /**
     * RK 算法实现字符串匹配
     * @param mString
     * @param sString
     * @return
     */
    public int rk(String mString, String sString) {
        int mLen = mString.length();
        int sLen = sString.length();
        char[] m = mString.toCharArray();
        char[] s = sString.toCharArray();
        long[] hashStrings = new long[mLen];

        long[] table = new long[sLen];
        long m26 = 1;
        
        // 先对 26 次方的结果进行缓存 
        for (int i = 0; i < sLen; i++) {
            table[i] = m26;
            m26 *= 26;
        }

        // 先计算模式串的 hash 值
        long sHashNum = hashString(s, sLen, table);
        hashStrings[0] = hashString(m, sLen, table);

        // 这边使用了公式之间的关联计算 hash 值，实际上可以使用
        for (int i = 0; i <= mLen-sLen; i++) {
            if (sHashNum == hashStrings[i]) {
                // 在 hash 值相等的情况下再判断字符串相等，以防冲突
                int j;
                for (j = 0; j < sLen && s[j] == m[i+j]; j++) {
                
                }

                if (j == sLen) {
                    return i;
                }
            }

            if ( i == mLen-sLen) {
                break;
            }

            hashStrings[i+1] = (hashStrings[i] - table[sLen-1]*(m[i]-'a'))*26 + table[0]*(m[i+sLen]-'a'); 
        }        
        
        return -1;
    }

    public static void main(String[] args) {
        BFRK bfrk = new BFRK();
        System.out.println(bfrk.bf("4321234327497328", "123")); 
        System.out.println(bfrk.rk("dasdqweewq", "ad"));
    }
}