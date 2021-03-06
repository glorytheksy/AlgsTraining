package jianzhiOffer_first_time;

/**
 * 
 * @ClassName BitWiseOperation
 * @Description 位运算
 * @author 叶晓蒙
 * @Date 2018年3月13日 下午4:18:03
 * @version 1.0.0
 */
public class BitWiseOperation {
    
    
    /**
     * 基本运算：与&，或|，非~，异或^，左移<<，右移>>，无符号右移
     * 
     * 操作数只能为整形或者字符型数据
     */
    public void test() {
        int var_1 = 1;
        int var_2 = 0;
        int rs = var_1^var_2;
        System.out.println(rs);     
        
        char a = 23;
        char b = 3;
        int c = a<<3;
        System.out.println(c);
    }
    
    /**
     * 
     * @Description 统计一个二进制数中有多少个1
     * @param args
     */
    public int oneCount(int x) {
        int count = 0;
        
        int flag = 1;
        while(0 != flag) {
           if (0 != (flag & x)) {
               count++;
           }
           flag = (flag<<1);
        }
        return count;
    }
    
    public static double f(int n, int s) {
        if (s < n || s > n * 6) {
            return 0;
        }
        if (n == 1) {
            return 1d/6d;
        }
        if (s == n) {
            return 1d/Math.pow(6d, new Double(n));
        }
        if (s == n * 6) {
            return 1d/Math.pow(6d, new Double(n));
        }
        
        return f(n - 1, s - 1)/6d + f(n - 1, s - 2)/6d + f(n - 1, s - 3)/6d + f(n - 1, s - 4)/6d + f(n - 1, s - 5)/6d + f(n - 1, s - 6)/6d; 
        
    }
        
    public static void main(String[] args) {
//        BitWiseOperation bo = new BitWiseOperation();
//        bo.test();
//        System.out.println(bo.oneCount(14));
        System.out.println(f(2,9));
    }
    
}
