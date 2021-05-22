package zuochengyun_excercises;

import data_structure_basic.Stack;
import data_structure_basic.StackForInt;

public class StackSorting_v2 {

    public StackForInt stackSort(StackForInt s) {        
        if (null == s)
            return null;
        /* 模仿插入排序 */
        StackForInt help = new StackForInt();       
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
        
        StackForInt s = new StackForInt();
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
