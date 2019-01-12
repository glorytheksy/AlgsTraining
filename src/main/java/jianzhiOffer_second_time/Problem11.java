package jianzhiOffer_second_time;

/**
 * @ClassName Problem11
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 
 * @author pc
 * @Date 2018年7月12日 下午3:22:47
 * @version 1.0.0
 */
public class Problem11 {

   public static double solution(double x, int n) {
       if (0 == x) {
           return x;
       }
       if (0 == n) {
           return 1;
       }
       if (1 == n) {
           return x;
       }       
       if (n < 0) {
           throw new RuntimeException("error input");
       }
       
       int mod = n%2;
       if (1 == mod) {
           double a = solution(x, n/2);
           return x * a * a;
       } else {
           double a = solution(x, n/2);
           return a * a;
       }
   }
   
   public static void main(String[] args) {
       System.out.println(solution(3d, 5));
   }
    
    
}
