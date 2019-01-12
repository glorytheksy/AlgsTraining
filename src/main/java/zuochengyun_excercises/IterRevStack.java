package zuochengyun_excercises;

import utils.Stack;

public class IterRevStack {


    public static Integer getAndRmvBottom(Stack s) {
        if (null == s) {
            return null;
        }
        
        if (1 == s.getSize()) {
            return s.pop();
        } else {
            Integer temp = s.pop();            
            Integer rs = getAndRmvBottom(s);
            s.push(temp);
            return rs;
        }
    }
        
    public static void revStack(Stack s) {
        if (null == s){
            return;
        }
        
        if (1 == s.getSize()) {
            return;
        } else {
            Integer temp = getAndRmvBottom(s);  
            revStack(s);
            s.push(temp);
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(6);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
