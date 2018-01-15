package zcy.stack_and_queue;

import utils.Stack;

/**
 * 
 * @ClassName StackSorting
 * @Description 栈元素排序（可借助另外一个栈，不可用别的数据结构）
 * @author yxmfi
 * @Date 2017年8月21日 下午11:53:33
 * @version 1.0.0
 */
public class StackSorting {
    
    public Stack stackSort(Stack s) {        
        if (null == s)
            return null;
        /* 模仿插入排序 */
        Stack help = new Stack();       
        while (!s.isEmpty()) {
            Integer cur = s.pop();
            join(s,help,cur);
        }
        return help;
    }
    
    public void join(Stack s, Stack help, Integer cur) {
        if (null == s || null == help || null == cur) {
            return;
        }        
        int shiftCnt = 0;
        while (!help.isEmpty() && help.peek() >= cur ) {
            s.push(help.pop());
            shiftCnt++;            
        }
        help.push(cur);
        /* 下面这部分是多余的 */
        for (int i = 0; i<shiftCnt ; i++){
            help.push(s.pop());
        }
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
