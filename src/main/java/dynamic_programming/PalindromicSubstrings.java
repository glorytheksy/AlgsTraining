package dynamic_programming;

public class PalindromicSubstrings {
	
    public int countSubstrings(String s) {
    	int len = s.length();
    	if (null == s || 0 == len) {
    		return 0;
    	}
    	
    	
    	int res = 0;
    	
    	for (int i = 0; i < len; i++) {
    		res++;
    		for (int j = 1; j <= Math.min(i, len-1-i); j++) {
    			if (s.charAt(i - j) == s.charAt(i + j)) {
    				res++;
    			} else {
    				break;
    			}
    		}
    		
    		if (i < len - 1 && s.charAt(i) == s.charAt(i+1)) {
    			res++;
        		for (int j = 1; j <= Math.min(i, len-2-i); j++) {
        			if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
        				res++;
        			} else {
        				break;
        			}
        		}
    		}
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		PalindromicSubstrings solution = new PalindromicSubstrings();
		String s = "aaa";
		
		System.out.println(solution.countSubstrings(s));
	}

}
