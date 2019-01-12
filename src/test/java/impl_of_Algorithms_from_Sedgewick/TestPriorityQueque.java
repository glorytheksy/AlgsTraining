package impl_of_Algorithms_from_Sedgewick;

import org.junit.Test;

import algorithms.sort.PriorityQue;

public class TestPriorityQueque {

    @Test
    public void test() {

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
        
        System.out.println(pq.getSimHeap());
        
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        
        System.out.println(pq.getSimHeap());
        
    }
    
}
