package zcy.stack_and_queue;

import utils.Stack;

public class StackSorting_v2 {

    public Stack stackSort(Stack s) {        
        if (null == s)
            return null;
        /* 模仿插入排序 */
        Stack help = new Stack();       
        while (!s.isEmpty()) {
            Integer cur = s.pop();            
            while (!help.isEmpty() && help.peek() >= cur ) {
                s.push(help.pop());
            }
            help.push(cur);
        }
        return help;
    }
    
    public static void main(String[] args) {
        StackSorting ss = new StackSorting();
        
        Stack s = new Stack();
        s.push(1);
        s.push(9);
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(4);
        
        s = ss.stackSort(s);
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
    
    
}
