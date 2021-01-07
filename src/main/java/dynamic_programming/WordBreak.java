package dynamic_programming;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(wordDict);
        
        if (s.isEmpty()) {
            if (set.contains("")) {
                return true;
            }
            return false;
        }

        // dp[i] 表示s的前i个元素是否可以由set内的单词构成
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        // wordDict内单词最长长度
        int maxLen = 0;
        for (String e : wordDict) {
            if (e.length() > maxLen) {
                maxLen = e.length();
            }
        }

        // 从dp[1]开始计算，dp[i]对应 s[i-1]
        for (int i = 1; i <= s.length(); i++) {
            boolean tempRes = false;

            for (int j = 1; j <= Math.min(maxLen, i); j++) {
                try {
                    if (dp[i - j] && set.contains(s.substring(i - j, i))) {
                        tempRes = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(i);
                    System.out.println(j);
                    throw new RuntimeException("error");
                }

            }
            dp[i] = tempRes;

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "200";
        List<String> list = new ArrayList<String>();
        list.add("200");

        System.out.println(solution.wordBreak(s, list));

    }

}
