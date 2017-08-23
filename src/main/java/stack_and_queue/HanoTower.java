package stack_and_queue;

import utils.Stack;

public class HanoTower {

    Stack A = new Stack();
    Stack B = new Stack();
    Stack C = new Stack();
    
    
    public HanoTower(Stack A, Stack B, Stack C) {        
        this.A = A;
        this.B = B;
        this.C = C;        
    }
    
    
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
