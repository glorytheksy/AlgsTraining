package impl_of_Algorithms_from_Sedgewick;

import java.util.LinkedList;
/**
 * 
 * @ClassName PriorityQue
 * @Description 优先队列（最大值在堆顶端）
 * @author 叶晓蒙
 * @Date 2017年8月24日 上午9:11:23
 * @version 1.0.0
 */
public class PriorityQue {
    // 存储数据数组(第一个元素我们并不使用)
    private LinkedList<Integer> simHeap = new LinkedList<Integer>(){ {add(0);} }; 
    // 优先队列数据长度
    private int size = 0;
        
    public boolean isEmpty() {
        return (0 == size);
    }
    
    public int getSize() {
        return size;
    }
    
    public void push(int element) {
        simHeap.add(element);
        size++;
        swim(size);
    }
        
    public int poll() {
        if (size < 1) {
            throw new RuntimeException();
        }        
        int rs = simHeap.set(1, simHeap.get(size));
        simHeap.removeLast();
        size--;
        if (size >= 1)
            sink(1);
        return rs;
    }
    
    

    private void swim(int n) {
        if (size < n || n < 1){
            throw new RuntimeException();
        }

        if (simHeap.get(getSuper(n)) >= simHeap.get(n)) {
            return;
        }
        exch(getSuper(n), n);
        swim(getSuper(n));
    }
    
    private void sink(int n) {
        if (size < n || n < 1){
            throw new RuntimeException();
        }
        
        if ((n * 2  + 1) > size && (n * 2) > size) {
            return;
        }
        
        if ((n * 2) <= size && (n * 2 + 1) <= size) {
            int maxIndex = maxIndex(n * 2, n * 2 + 1); 
            if (simHeap.get(maxIndex) > simHeap.get(n)) {
                exch(maxIndex, n);
                sink(maxIndex);
            }
        }
        
        else if ((n * 2) <= size) {
            if (simHeap.get(n * 2) >= simHeap.get(n)) {
                exch(2 * n, n);
                sink(2 * n);
            }
        }

    }
    
    private void exch(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }
        Integer t = simHeap.get(m);
        simHeap.set(m, simHeap.get(n).intValue());
        simHeap.set(n, t.intValue());
    }
    
    /**
     * 
     * @Description 父节点索引
     * @param n
     * @return
     */
    private int getSuper(int n) {
        if (size < n || n < 1){
            throw new RuntimeException();
        }
        if (1 == n) 
            return 1;
        if (0 == n % 2)
            return n/2;
        else
            return ((n - 1)/2);        
    }
    
    /**
     * 
     * @Description 值较大者索引
     * @param m
     * @param n
     * @return
     */
    private int maxIndex(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }                
        return (simHeap.get(m) > simHeap.get(n)) ? m : n;
    }
    
    
    public static void main(String[] args) {
        
        PriorityQue pq = new PriorityQue();
        
        pq.push(2);
        pq.push(21);
        pq.push(32);
        pq.push(20);
        pq.push(12);
        pq.push(92);
        pq.push(99);
        pq.push(999);
        pq.push(9999);
        pq.push(888);
        pq.push(111);
        
        System.out.println(pq.simHeap);
        
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        
        System.out.println(pq.simHeap);
        
    }
}
