package leetcode.algs.sliding_window;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
       int len = s.length();
        
       Set<Character> set = new HashSet<Character>();
       Set<Character> rest = new HashSet<Character>();
       for (Character ele : t.toCharArray()) {
           rest.add(ele);
           set.add(ele);
       }
       Map<Character, Integer> contained = new HashMap<Character, Integer>();

       contained.put(s.charAt(0), 1);
       if (rest.contains(s.charAt(0))) {
           rest.remove(s.charAt(0));
       }
       
       String min = "hjkjfhjfhfhjfhjfhf";
       int rt = 1;
       for (int lt = 0; lt < len; lt++) {
           while (rt < len && !rest.isEmpty()) {
               if (rest.contains(s.charAt(rt))) {
                   rest.remove(s.charAt(rt));
               }
               
               if (contained.containsKey(s.charAt(rt))) {
                   contained.put(s.charAt(rt), contained.get(s.charAt(rt)) + 1);
               } else {
                   contained.put(s.charAt(rt), 1);
               }
               if (rt < len - 1 && !rest.isEmpty()) rt++;
           }
           
           if (rest.isEmpty()) {
               if (min.length() > rt - lt + 1) {
                   min = s.substring(lt, rt+1);
               }
           }
           
           if (null != contained.get("C") && 1 == contained.get("C")) {
               System.out.println("asdf");
           }
           
           try {
               if (null != contained.get(s.charAt(lt)) && 1 == contained.get(s.charAt(lt))) {
                   contained.remove(s.charAt(lt));
                   if (set.contains(s.charAt(lt))) {
                       rest.add(s.charAt(lt));
                   }
               } else {
                   contained.put(s.charAt(lt), contained.get(s.charAt(lt)) - 1);
               }
           } catch (Exception e) {
               System.out.println("lt:" + lt);
               System.out.println("rt:" + rt);
               System.out.println("con:" + contained);
               System.out.println("rest:" + rest);
               System.out.println("set:" + set);
           }
       }
       
       return min;
    }
    
    
    public static void main(String[] args) {
        
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
    
}
