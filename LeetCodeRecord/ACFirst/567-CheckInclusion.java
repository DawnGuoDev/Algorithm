package ACFirst;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26]; // 其实这也是 hash table，因为符合 hash table 的思想 
        int[] s2Map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Map[hash(s1.charAt(i))] ++;
            s2Map[hash(s2.charAt(i))] ++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(s1Map, s2Map)) {
                return true;
            }

            s2Map[hash(s2.charAt(i + s1.length()))] ++;
            s2Map[hash(s2.charAt(i))] --;
        }

        return match(s1Map, s2Map);
    }

    public boolean match(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        
        return true;
    }
    public int hash(char ch) {
        return ch - 'a';
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Map[hash(s1.charAt(i))]++;
            s2Map[hash(s2.charAt(i))]++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                count ++;
            }
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) {
                return true;
            }

            int hashNum1 = hash(s2.charAt(i + s1.length()));
            int hashNum2 = hash(s2.charAt(i));
            s2Map[hashNum1] ++;

            if (s2Map[hashNum1] == s1Map[hashNum1]) {
                count ++;
            } else if (s2Map[hashNum1] == s1Map[hashNum1] + 1) {
                count --;
            }

            s2Map[hashNum2]--;
            if (s2Map[hashNum2] == s1Map[hashNum2]) {
                count ++;
            } else if (s2Map[hashNum2] + 1 == s1Map[hashNum2]) {
                count --;
            }
        }

        return count == 26;
    }

    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        System.out.println(ci.checkInclusion("ab", "eidbaooo"));
        System.out.println(ci.checkInclusion("ab", "eidboaoo"));
        System.out.println(ci.checkInclusion2("ab", "eidbaooo"));
        System.out.println(ci.checkInclusion2("ab", "eidboaoo"));
    }
}
