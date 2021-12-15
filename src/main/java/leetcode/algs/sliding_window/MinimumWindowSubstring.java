package leetcode.algs.sliding_window;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.javafx.util.Utils;

import org.omg.PortableInterceptor.INACTIVE;
import utils.CommonUtils;

public class MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
       int len = s.length();
        
       Set<Character> rest = new HashSet<Character>();
       for (Character ele : t.toCharArray()) { rest.add(ele); }
       Map<Character, Integer> contained = new HashMap<Character, Integer>();
       
       int minLen = Integer.MAX_VALUE;
       String minStr = "";
       
       int lt = 0;
       int rt = 0;
       while (rt < len) {
           char rt_char = s.charAt(rt);
           rt++;
           CommonUtils.mapAdd(contained, rt_char);
           CommonUtils.setRemove(rest, rt_char);
           System.out.println("window: lt" + lt + ", rt: " + rt);
           
           while (rest.isEmpty() && lt <= rt - 1) {
               char lt_char = s.charAt(lt);
               if (minLen > (rt - 1 - (lt - 1) + 1)) {
                   minStr = s.substring(lt - 1, rt - 1 + 1);
                   minLen = minStr.length();
               }
               lt++;
               if (contained.containsKey(lt_char)) {
                   if (1 == contained.get(lt_char)) {
                       contained.remove(lt_char);
                       rest.add(lt_char);
                   } else {
                       contained.put(lt_char, contained.get(lt_char) - 1);
                   }
               }
           }
       }
       return minStr;
    }
        
    public static void main(String[] args) {
        
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "a";
        String t = "a";
        System.out.println(solution.minWindow(s, t));
        
                
    }
    
}
