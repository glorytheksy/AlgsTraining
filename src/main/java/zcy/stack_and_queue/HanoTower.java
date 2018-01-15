package zcy.stack_and_queue;

import utils.Stack;

/**
 * 
 * @ClassName HanoTower
 * @Description 汉诺塔问题
 * @author 叶晓蒙
 * @Date 2017年8月23日 下午12:39:44
 * @version 1.0.0
 */
public class HanoTower {

    Stack A = new Stack();
    Stack B = new Stack();
    Stack C = new Stack();
    
    
    public HanoTower(Stack A, Stack B, Stack C) {        
        this.A = A;
        this.B = B;
        this.C = C;        
    }
    
    /**
     * 
     * @Description 该方法可行性可用归纳法证明
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public void move(int n, Stack A, Stack B, Stack C) {    
        
        if (0 >= n || n > A.getSize()) {
            throw new RuntimeException();
        }
        
        if (1 == n) {
            System.out.println("从" + A.getName() + "移动" + A.peek() + "到" + C.getName());
            C.push(A.pop());
            return;
        }
        
        move(n - 1, A, C, B);
        System.out.println("从" + A.getName() + "移动" + A.peek() + "到" + C.getName());
        C.push(A.pop());
        move(n - 1, B, A, C);
                        
    }
    
    public static void main(String[] args) {
        
    }
    
    
}
