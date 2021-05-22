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
	
	/**
	 * 动态规划解法
	 * @param s
	 * @return
	 */
    public String longestPalindrome(String s) {
        if (null == s) {
            return null;
        }
        if (s.isEmpty()) {
            return "";
        }

        boolean [][] mat = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            mat[i][i] = true;
        }

        String longest = s.substring(s.length() - 1, s.length());
        int longestLen = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
            	/* 首尾相同 */
             if (s.charAt(i) == s.charAt(j)) {
                	/* 相邻 */
                	if (j == i + 1) {
                		mat[i][j] = true;
                		if (2 > longestLen) {
                            longestLen = 2;
                            longest = s.substring(i,j+1);
                		}
                	/* 不相邻 */
                	} else {
                		mat[i][j] = mat[i+1][j-1];
                        if (true == mat[i+1][j-1] && (j-i+1+2 > longestLen)) {
                            longestLen = j - i + 1 + 2;
                            longest = s.substring(i,j+1);
                        }
                	}
                /* 首尾不同 */
                } else {
                    mat[i][j] = false;
                }
            }
        }

        System.out.println("longestLen: " + longestLen);
        System.out.println("longest: " + longest);
        return longest;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromeSubseq solution = new LongestPalindromeSubseq();
        System.out.println(solution.longestPalindrome(s));
    }
    
}