package leetcode.algs;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LongestSubstringWithoutRepeatingCharacters
 * @Description Given a string, find the length of the longest substring without repeating characters.
 * @author yxmfight
 * @Date 2019年11月5日 上午10:40:55
 * @version 1.0.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int solution(String str) {
        if (null == str) {
            return -1;
        }
        if (1 == str.length()) {
            return 1;
        }
        
        /**
         * 思路：起始位置 p1, p2
         *       
         */
        Set<Character> set = new HashSet<Character>();
        
        int p1 = 0;
        int p2 = 1;
        int maxLen = 0;
        int curLen = 0;
        
        while (p2 < str.length() && p1 <= p2) {            
            if (!set.contains(new Character(str.charAt(p2)))) {
                p2++;
                curLen++;
            } else {
                p1 = getRepeatPos(str, p1, str.charAt(p2)) + 1;
                curLen = p2 - p1 + 1;
                p2++;
            }
            
            if (maxLen < curLen) {
                maxLen = curLen;
            }
        }
        
        return maxLen;                
    }
    
    private int getRepeatPos(String str, int start, char c) {
        return -1;
    }
}
