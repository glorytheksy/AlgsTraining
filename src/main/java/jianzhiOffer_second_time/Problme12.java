package jianzhiOffer_second_time;

/**
 * @ClassName Problme12
 * @Description 打印1到n位数的最大数字
 * @author pc
 * @Date 2018年7月12日 下午3:52:21
 * @version 1.0.0
 */
public class Problme12 {
    
    public static void solution(int n) {
        if (0 >= n) {
            return;
        }
        StringBuilder number = new StringBuilder("1");
        while(number.length() <= n) {
            System.out.println(number);
            number = addOne(number);            
        }
    }
    
    public static StringBuilder addOne(StringBuilder number) {
        if (number.length() == 1 && number.charAt(0) == '0') {
            return new StringBuilder("1");
        }
        int carry = 1;
        int pos = number.length() - 1;
        char val = 0;
        while (pos >= 0 && carry > 0) {            
            val = number.charAt(pos);
            if ('9' == val) {
                number.setCharAt(pos, '0');
            } else {
                val = (char)(val + 1);
                number.setCharAt(pos, val);
                carry = 0;
            }
            pos--;
        }
        if (pos < 0 && carry > 0) {
            return new StringBuilder("1").append(number);
        }        
        return number;
    }
    
    public static void permutation(int n) {
        
    }
    
    
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("0");
        solution(3);
    }
}
