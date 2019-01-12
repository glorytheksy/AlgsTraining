package jianzhiOffer_second_time;

/**
 * 
 * @ClassName Problem46
 * @Description 
 * @author pc
 * @Date 2018年7月5日 下午4:57:19
 * @version 1.0.0
 */
public class Problem46 {

    public static int solution(int n) {
        int sum = n;
        // 运用and语句代替if语句
        boolean ans = (n>0)  &&   (  (sum+=solution(n-1))>0  );
        return sum;        
    }
            
    public static void main(String[] args) {
        System.out.println(solution(10)); 
    }
        
}
