package zuochengyun_excercises;

import data_structure.Stack;

/**
 * 
 * @ClassName QuequeFrom2Stacks
 * @Description ����ջ���ɵĶ���
 * @author Ҷ����
 * @Date 2017��8��16�� ����8:07:30
 * @version 1.0.0
 */
public class QuequeFrom2Stacks {
    
    // ����ջ
    private Stack normalOrder = new Stack();
    // ����ջ
    private Stack reverseOrder = new Stack();
    // ����
    private int size;
    
    /**
     * 
     * @Description ѹ��element
     * @param element
     */
    public void push(Integer element) {
        this.normalOrder.push(element);
    }
    
    /**
     * 
     * @Description ������Ƚ����е�����
     * @return
     */
    public Integer poll() {
        if (this.isEmpty()) {
            throw new RuntimeException();
        }
        
        if (this.reverseOrder.isEmpty()) {
            while(!this.normalOrder.isEmpty()) {
                this.reverseOrder.push(this.normalOrder.pop());
            }
        }        
        return this.reverseOrder.pop();        
    }
    
    public boolean isEmpty() {        
        return this.normalOrder.isEmpty() && this.reverseOrder.isEmpty();        
    }
    
    
    public static void main(String[] args) {
        QuequeFrom2Stacks qf = new QuequeFrom2Stacks();
        
        qf.push(1);
        qf.push(2);
        qf.push(3);
        qf.push(4);
        qf.push(5);
        qf.push(6);
        qf.push(7);
        
        System.out.println(qf.poll());
        System.out.println(qf.poll());
        System.out.println(qf.poll());
        System.out.println(qf.poll());
        System.out.println(qf.poll());
        
    }
    
}
