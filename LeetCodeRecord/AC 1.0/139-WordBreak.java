import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        int maxStrLen= 0;
        boolean[] dp = new boolean[s.length() + 1];
        
        // 记录最长字符串的长度
        for (String str : wordSet) {
            if (str.length() > maxStrLen) {
                maxStrLen = str.length();
            }
        }

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0 && (i - j) <= maxStrLen; j--) {
                dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> list = new LinkedList<String>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wb.wordBreak("catsandog", list));
        // System.out.println("leetcode".substring(0, 1));
    }
}