package jianzhiOffer_first_time;
//package commonly_used_intervew_problems.sorting.dynamic_programming;
//
///**
// * 
// * @ClassName DicePointsSumProblem
// * @Description given n dices, what is the probabilities of every possible summation of the points?
// * @author 叶晓蒙
// * @Date 2018年6月13日 下午5:31:15
// * @version 1.0.0
// */
//public class DicePointsSumProblem {
//        
//    /**
//     * assume that with n dices, the probability of summation as s is f(n,s),
//     * the we have, f(n, s) = f(n - 1, s - 1)/6 +
//     *                        f(n - 1, s - 2)/6 +
//     *                        f(n - 1, s - 3)/6 + 
//     *                        f(n - 1, s - 4)/6 + 
//     *                        f(n - 1, s - 5)/6 + 
//     *                        f(n - 1, s - 6)/6
//     */
//    public static double f(int n, int s) {
//        if (s < n || s > n * 6) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1d/6d;
//        }
//        if (s == n) {
//            return 1d/Math.pow(6d, new Double(n));
//        }
//        if (s == n * 6) {
//            return 1d/Math.pow(6d, new Double(n));
//        }        
//        return f(n - 1, s - 1)/6d + f(n - 1, s - 2)/6d + f(n - 1, s - 3)/6d + f(n - 1, s - 4)/6d + f(n - 1, s - 5)/6d + f(n - 1, s - 6)/6d;         
//    }
//    
//    /**
//     * a dynamic programming way to solve this problem
//     */
//    public static double solution(int n, int s) {
//        if (s < n || s > n * 6) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1d/6d;
//        }
//        if (s == n) {
//            return 1d/Math.pow(6d, new Double(n));
//        }
//        if (s == n * 6) {
//            return 1d/Math.pow(6d, new Double(n));
//        }  
//        
//        double [] temp_arr_1 = new double [s];    
//        double [] temp_arr_2 = new double [s];         
//
//        // here in case of  misunderstanding, we don't use the 0th element
//        temp_arr_1[1] = 1d/6d;
//        temp_arr_1[2] = 1d/6d;
//        temp_arr_1[3] = 1d/6d;
//        temp_arr_1[4] = 1d/6d;
//        temp_arr_1[5] = 1d/6d;
//        temp_arr_1[6] = 1d/6d;
//        
//        for (int i = 2; i <= n - 1; i++) {
//                        
//            for (int j = 1; j <= s-1; j++) {
//                temp_arr_2[j] = 
//            }
//        }
//        
//    }
//}
