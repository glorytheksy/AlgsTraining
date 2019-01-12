package jianzhiOffer_second_time;

import jianzhiOffer_first_time.SortUtils;

/**
 * @ClassName Permutation
 * @Description 
 * @author yxmfight
 * @Date 2018年7月13日 上午11:19:32
 * @version 1.0.0
 */
public class Permutation {

    public static void solution(int [] a) {
        if (null == a) {
            throw new RuntimeException("input is null!");
        }
        permutation(a, 0);        
    }
    
    private static void permutation(int [] a, int pos) {
        if (pos ==  a.length) {
            print(a);
            return;
        }
        
        
        for (int i = pos; i < a.length; i++) {
            SortUtils.exch(a, pos, i);
            permutation(a, pos + 1);
            SortUtils.exch(a, pos, i);
        }
    }
    
    private static void print(int [] a) {
        for (int e : a) {
            System.out.print(e);            
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int a [] = new int [] {1,2,3,4};
        solution(a);
    }
            
}
