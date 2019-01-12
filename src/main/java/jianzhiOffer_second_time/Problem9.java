package jianzhiOffer_second_time;

/**
 * @ClassName Problem9
 * @Description 斐波那契数列
 * @author pc
 * @Date 2018年7月12日 下午2:07:51
 * @version 1.0.0
 */
public class Problem9 {

    public static int solution(int n) {        
        if (0 == n || 1 == n) {
            return n;
        }
        
        int head = 0;
        int tail = 1;
        int temp = 0;
        
        for (int i = 2; i <= n; i++) {
            temp = head + tail;
            head = tail;
            tail = temp;
        }
        return tail;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
