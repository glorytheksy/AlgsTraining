package jianzhiOffer;

import utils.Stack;

/**
 * 
 * @ClassName Problem22
 * @Description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。如：
 *              输入顺序：1、2、3、4、5，则4、5、3、2、1是其输出顺序，但4、3、5、1、2不是其输出顺序
 * @author yxmfi
 * @Date 2018年7月17日 上午9:16:09
 * @version 1.0.0
 */
public class Problem22 {
    
    public static boolean solution(int [] l1, int [] l2) {
        if (null == l1 || null == l2) {
            throw new RuntimeException("input is null");
        }
        if (l1.length != l2.length) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        
        while(!s1.isEmpty() || p1 < l1.length) {
            if (p1 < l1.length) {
                s1.push(l1[p1++]);
            }
            
            if (s1.peek() == l2[p2]) {
                s2.push(s1.pop());
                p2++;
            } else {
                if (p1 == l1.length) {
                    return false;
                }
            }
        }
        
        return (s1.isEmpty()) && (p1 == l1.length) && (p2 == l2.length);
    }
    
    public static void main(String[] args) {
//        int [] a = new int [] {1,2,3,4,5};
//        int [] b = new int [] {4,5,3,2,1};
        int [] a = new int [] {1};
        int [] b = new int [] {1};
        boolean rs = solution(a,b);
        System.out.println(rs);
    }
    

}
