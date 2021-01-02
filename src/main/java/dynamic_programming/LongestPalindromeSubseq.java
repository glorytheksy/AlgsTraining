package dynamic_programming;

/**
 * 
 * @ClassName LongestPalindromeSubseq
 * @Description 最长回文子串
 * @author yxmfi
 * @Date 2021年1月2日 上午11:57:50
 * @version 1.0.0
 */
public class LongestPalindromeSubseq {

    public String longestPalindrome(String s) {

        int [][] mat = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            mat[i][i] = 1;
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    
                } else {
                    
                }
            }
        }
        
        
        return null;
    }
    
    
    
}
