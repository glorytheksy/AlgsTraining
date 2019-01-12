package jianzhiOffer_second_time;

/**
 * @ClassName Problem10
 * @Description 请实现一个函数,输入一个整数,输出该数二进制表示1的个数
 * @author pc
 * @Date 2018年7月12日 下午2:47:21
 * @version 1.0.0
 */
public class Problem10 {
    
    /**
     * 熟悉下位运算:
     * 
     * m << n : m左移n位，最左边的n位被丢弃
     * m >> n : m右移n位，最右边的n位被丢弃
     *          如果m无符号，用0填写左边n位
     *          有符号，用符号位填写左边n位          
     */
    
    public static int solution(int num) {
        int count = 0;
        int and_helper = 1;
        for (int i = 0; i < 32; i++) {
            if (0 != (num & and_helper)) {
                count++;
            }
            and_helper = and_helper * 2;
        }
        return count;        
    }
    
    public static int solution2(int num) {
        /* 减1的意义：最右边的1变成0 */
        int count = 0;
        while(0 != num) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
    
          
    public static void main(String[] args) {
        System.out.println(solution2(-4));
        
    }
}
