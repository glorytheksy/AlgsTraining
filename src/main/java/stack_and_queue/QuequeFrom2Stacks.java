package stack_and_queue;

/**
 * 
 * @ClassName QuequeFrom2Stacks
 * @Description 两个栈构成的队列
 * @author 叶晓蒙
 * @Date 2017年8月16日 上午8:07:30
 * @version 1.0.0
 */
public class QuequeFrom2Stacks {
    
    // 正序栈
    private Stack normalOrder = new Stack();
    // 倒序栈
    private Stack reverseOrder = new Stack();
    // 长度
    private int size;
    
    /**
     * 
     * @Description 压入element
     * @param element
     */
    public void push(Integer element) {
        this.normalOrder.push(element);
    }
    
    /**
     * 
     * @Description 输出最先进队列的数据
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
