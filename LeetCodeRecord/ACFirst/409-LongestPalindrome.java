package ACFirst;

class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] count = new int[58];
        for (char ch : s.toCharArray()) {
            count[ch - 'A']++;
        } 

        int max = 0;
        for (int num : count) {
            max += num - (num & 1);
        }
        
        return max < s.length() ? max + 1 : max;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[58];
        for (char ch : s.toCharArray()) {
            count[ch - 'A'] ++;
        }

        int max = 0;
        for (int num : count) {
            if (num % 2 == 0) {
                max += num;
            } else if (num % 2 == 1 && max % 2 == 0){
                max += num;
            } else if (num % 2 == 1 && max % 2 == 1) {
                max += num - 1;
            } 
        }
        
        return max;
    }

    public int longestPalindrome3(String s) {
        int[] count = new int[58];
        for (char ch : s.toCharArray()) {
            count[ch - 'A'] ++;
        }

        int max = 0;
        for (int num : count) {
            max += num /2 * 2;
            if (num % 2 == 1 && max % 2 == 0) {
                max ++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestPalindrome409 lp = new LongestPalindrome409();
        System.out.println(lp.longestPalindrome("abccccdd"));
        System.out.println(lp.longestPalindrome2("abccccdd"));
        System.out.println(lp.longestPalindrome3("abccccdd"));
    }
}