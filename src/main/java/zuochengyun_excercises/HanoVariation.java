package zuochengyun_excercises;

import data_structure_basic.Stack;

/**
 * 
 * @ClassName HanoVariation
 * @Description 汉诺塔问题（修改为第一个塔和第三个塔不可直接交换内容）
 * @author pc
 * @Date 2017年8月23日 下午12:28:55
 * @version 1.0.0
 */
public class HanoVariation {
    
    Stack A = new Stack();
    Stack B = new Stack();
    Stack C = new Stack();
        
    public HanoVariation(Stack A, Stack B, Stack C) {        
        this.A = A;
        this.B = B;
        this.C = C;        
    }
    
    public void move(int n, Stack A, Stack B, Stack C) {    
        
        if (0 >= n || n > A.getSize()) {
            throw new RuntimeException();
        }
        
        if (1 == n) {
            System.out.println("从" + A.getName() + "移动" + A.peek() + "到" + B.getName());
            B.push(A.pop());
            System.out.println("从" + B.getName() + "移动" + B.peek() + "到" + C.getName());
            C.push(B.pop());
            return;
        }
        
        move(n - 1, A, B, C);
        System.out.println("从" + A.getName() + "移动" + A.peek() + "到" + B.getName());
        B.push(A.pop());
        move(n - 1, C, B, A);
        System.out.println("从" + B.getName() + "移动" + B.peek() + "到" + C.getName());
        C.push(B.pop());
        move(n - 1, A, B, C);
                        
    }
    
    
}
