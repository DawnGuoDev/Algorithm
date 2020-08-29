package ACSecond;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class WorkBreakSecond {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        if (sLen <= 0) {
            return true;
        }

        Set<String> ss = new HashSet<String>(wordDict);
         
        // dp 数组
        boolean[] dp = new boolean[sLen + 1];
        int maxLen = 0;
        for (String string: ss) {
            if (string.length() > maxLen) {
                maxLen = string.length();
            }
        }

        // base case
        dp[0] = true;

        // 动态规划迭代 
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = i - 1; j >= i - maxLen && j >= 0; j--) {
                if (ss.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        } 

        return dp[sLen];
    }
    
    public static void main(String[] args) {
        WorkBreakSecond wb = new WorkBreakSecond();
        List<String> l = new LinkedList<String>();
        l.add("leet");
        l.add("code");
        System.out.println(wb.wordBreak("leetcode", l));
    }
}