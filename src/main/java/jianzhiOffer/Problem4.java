package jianzhiOffer;

/**
 * @ClassName Problem4
 * @Description 
 * @author pc
 * @Date 2018年7月11日 上午10:15:44
 * @version 1.0.0
 */
public class Problem4 {

   public static void solution(StringBuilder str) {
       if (null == str) {
           throw new RuntimeException("input is null!");
       }
       int origin_len = str.length();
       add_extra_space(str);
       
       int p1 = origin_len - 1;
       int p2 = str.length() - 1;
               
       while(p1 >= 0) {
           if (' ' == str.charAt(p1)) {
               str.setCharAt(p2 - 2, '%');
               str.setCharAt(p2 - 1, '2');
               str.setCharAt(p2, '3');
               p2 = p2 - 3;
           } else {
               str.setCharAt(p2, str.charAt(p1));
               p2--;
           }
           p1--;
       }
   }
    
   private static void add_extra_space(StringBuilder str) {
       int len = str.length();
       for (int i = 0; i < len; i++) {
           if (' ' == str.charAt(i)) {
               str.append("  ");
           }
       }       
   }
   
   public static void main(String[] args) {
       StringBuilder str = new StringBuilder("123213");
       solution(str);
       System.out.println(str);
   }
    
}
