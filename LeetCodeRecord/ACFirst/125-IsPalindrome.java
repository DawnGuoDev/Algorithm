package ACFirst;

class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                right --;
                left ++;
            }
        }
        
        return true;
    }    

    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(ip.isPalindrome("race a car"));
        System.out.println(ip.isPalindrome(""));
    }
}
