package jianzhiOffer_second_time;

import data_structure.Queue;

/**
 * 
 * @ClassName Problem7
 * @Description 两个队列实现一个栈
 * @author pc
 * @Date 2018年7月11日 下午3:59:17
 * @version 1.0.0
 */
public class Problem7_sub {
        
    public class myStack {
        
        private Queue<Integer> q1;
        
        private Queue<Integer> q2;
        
        public void add(int num) {
            if (q1.isEmpty()) {
                q2.add(num);
            } else {
                q1.add(num);
            }
        }
        
        public int pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                throw new RuntimeException();
            }
            if (q1.isEmpty()) {
                while (1 != q2.getSize()) {
                    q1.add(q2.poll());
                }
                return q2.poll().intValue();
            } else {
                while (1 != q1.getSize()) {
                    q2.add(q1.poll());
                }
                return q1.poll().intValue();
            }
        }
        
    }
    
}
