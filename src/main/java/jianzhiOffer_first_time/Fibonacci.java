package jianzhiOffer_first_time;

/**
 * 
 * @ClassName Fibonacci
 * @Description 生成斐波那契数列
 * @author 叶晓蒙
 * @Date 2018年3月12日 下午5:23:41
 * @version 1.0.0
 */
public class Fibonacci {
    
     /**
      * 递归解法（略）
      */
    
    /**
     * memorize解法
     */
    public int fibonacci(int N) {
        if (N <= 0) {
            throw new RuntimeException("error");
        }
        int [] memo = new int [N]; 
        memo[1] = 1;
        memo[2] = 2;
        return fibonacci(N,memo);
    }
    
    private int fibonacci(int N, int [] memo) {
        if (1 == N || 2 == N) {
            return N;
        }
        
        if (0 == memo[N - 1]) {
            memo[N - 1] = fibonacci(N - 1);
        }
        if (0 == memo[N - 2]) {
            memo[N - 2] = fibonacci(N - 2);
        }
        return memo[N - 1] + memo[N - 2];        
    }
        
    /**
     * 斐波那契数列的动态规划属于最简单的一类，我们只需要考虑一个变量
     */
    public int fibonacci_dp(int N) {
        if (1 == N || 2 == N) {
            return N;
        }
        
        int formmer_val = 1;
        int latter_val = 2;
        int temp = 0;
        for (int i = 3; i < N + 1; i++) {
            temp = formmer_val + latter_val;
            formmer_val = latter_val;
            latter_val = temp;
        }
        
        return temp;
    }
    

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        
        System.out.println(test.fibonacci_dp(3));
        System.out.println(test.fibonacci_dp(4));
        System.out.println(test.fibonacci_dp(5));
        System.out.println(test.fibonacci_dp(6));
        
    }
}
