package leetcode.algs.string;
/**
 * 
 * @author glorythesky
 * 最长回文子序列
 * 
 * 回文题目的一维化不易理解，所以还是用二维化吧，写出来再说
 * 
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
    	if (null == s) {
    		return 0;
    	}
    	if (1 == s.length()) {
    		return 1;
    	}
//    	StringBuilder builder = new StringBuilder(s);
    	char[] txt = s.toCharArray();
    	
    	int [][] arr = new int[s.length()][s.length()];
    	for (int i=0; i<s.length(); i++) {
    		arr[i][i] = 1;
    	}
    	
    	for (int layer=1; layer<s.length(); layer++) {
    		int i = 0;
    		int j = layer;
    		
			for (; i<s.length()-layer; i++, j++) {
				if (txt[i] == txt[j]) {
					arr[i][j] = arr[i+1][j-1] + 2;
				} else {
					arr[i][j] = this.max(arr[i+1][j], arr[i][j-1]);
				}
			}
    	}
    	return arr[0][s.length() - 1];
    }
    
    private int max(int a, int b) {
    	if (a > b ) {
    		return a;
    	} else {
    		return b;
    	}
    }
	
    public static void main(String[] args) {
		LongestPalindromeSubseq obj = new LongestPalindromeSubseq();
		String s = "s2s2s2s2s2s2s2s2sss22ss";
		System.out.println(obj.longestPalindromeSubseq(s));
	}
}
