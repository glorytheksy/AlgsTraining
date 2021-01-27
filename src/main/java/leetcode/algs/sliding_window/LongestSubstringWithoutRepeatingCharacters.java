package leetcode.algs.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName LongestSubstringWithoutRepeatingCharacters
 * @Description 这题道理简单，但细节太烦了
 * @author yxmfi
 * @Date 2021年1月23日 下午10:53:28
 * @version 1.0.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * 
     * @Description 解法1：这种解法其实有点绕弯子了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        if (1 == s.length()) {
            return 1;
        }
        
        int curMax = 1;
        Set<String> set = new HashSet<String>();
        
        int lt = 0;
        int rt = 0;
        set.add("" + s.charAt(lt));
        while (lt <= rt && rt < s.length() - 1) {
            while (rt < s.length() - 1) {
                rt++;
                if (set.contains("" + s.charAt(rt))) {
                    break;
                }
                set.add("" + s.charAt(rt));
                if (rt - lt + 1 > curMax) {
                    curMax = rt - lt + 1;
                }
            } 
            
            while (lt < rt) {
                if (s.charAt(lt) == s.charAt(rt)) {
                    lt++;
                    break;
                } else {
                    set.remove("" + s.charAt(lt));
                    lt++;
                }
            }
        }
        return curMax;
    }
    
    
//    public int lengthOfLongestSubstring2(String s) {
//        if (null == s || s.isEmpty()) {
//            return 0;
//        }
//        if (1 == s.length()) {
//            return 1;
//        }
//        
//        int curMax = 1;
//        Set<Character> set = new HashSet<Character>();
//        
//        int lt = 0;
//        int rt = 0;
//        set.add(s.charAt(lt));
//        for (int i = 0; i < s.length(); i++) {
//            lt = i;
//            /* rt移动到第一个不符合要求的位置或者末尾 */
//            while (rt < s.length() - 1) {
//                if (set.contains(s.charAt(rt))) {
//                    break;
//                } else {
//                    set.add(s.charAt(rt));
//                    rt++;
//                }
//            }
//            /* 求这时的长度 */
//            // 排除末尾不符合要求的可能性
//            if (set.contains(s.charAt(rt - 1))) {
//                curMax = Math.max(curMax, rt - 1 - lt + 1);
//                if (s.charAt(rt) != s.charAt(lt)) {
//                    set.remove(s.charAt(lt));
//                }             
//                
//                if () {
//                    
//                }
//                
//            } else {
//                // 符合要求，则一定是末尾
//                curMax = Math.max(curMax, rt - lt + 1);
//                set.remove(s.charAt(lt));
//            }
//        }
//        return curMax;
//    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        System.out.println(solution.lengthOfLongestSubstring("pwwke"));
        
    }
    
}
