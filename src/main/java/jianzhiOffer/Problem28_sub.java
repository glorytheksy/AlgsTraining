package jianzhiOffer;

/**
 * 
 * @ClassName Problem28_sub
 * @Description 字符串组合问题
 * @author yxmfight
 * @Date 2018年7月17日 下午3:10:22
 * @version 1.0.0
 */
public class Problem28_sub {
    
    public static void combo(String prefix, String s) {
      int N = s.length();

      System.out.println(prefix);

      for (int i = 0 ; i < N ; i++)
        combo(prefix + s.charAt(i), s.substring(i+1));
    }
    

    
    public static void solution(char [] a, int start, int ) {
        int N = a.length - start;
        print(a, start);
        
        for (int i = 1 ; i < N ; i++) {
            exch(a, start + 1, start + i);            
            solution(a, )
        }
    }
    
    private static void print(char [] a, int end) {
        for (int i = 0; i <= end; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    
    private static void exch(char [] a, int p1, int p2) {
        char x = a[p1];
        a[p1] = a[p2];
        a[p2] = x;        
    }
    
    public static void main(String[] args) {
        
    }
        
}
