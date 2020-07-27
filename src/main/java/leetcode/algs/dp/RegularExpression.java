package leetcode.algs.dp;

public class RegularExpression {
	
	public boolean isMatch(String text, String pattern) {
	    if (text.length() != pattern.length()) 
	        return false;
	    for (int j = 0; j < pattern.size(); j++) {
	        if (pattern[j] != text[j])
	            return false;
	    }
	    return true;
	}
	
	

}
