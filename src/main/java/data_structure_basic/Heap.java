package data_structure_basic;

import java.util.LinkedList;

/**
 * 
 * @ClassName Heap
 * @Description heap, max on the top
 *              （by heap, we mean a data structure ，not the garbage recycle in java）
 * @author 叶晓蒙
 * @Date 2018年2月6日 上午8:49:59
 * @version 1.0.0
 */
public class Heap {
    
    // the length of heap
    private int size = 0;

    /* heap list (we don't use the 0th element) */
    @SuppressWarnings("serial")
    private LinkedList<Integer> heapList = new LinkedList<Integer>() {
        {
            add(0);
        }
    };
    
    /**
     * @Description is the heap empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (0 == size);
    }
    
    /**
     * @Description the size of heap
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * @Description add element to the tail of the heap, 
     *              and the heap will adjust itself to 
     *              keep its right order.
     * @param element
     */
    public void push(int element) {
        heapList.add(element);
        size++;
        swim(size);
    }

    /**
     * @Description poll one element from the top of the heap,
     *              and the heap will adjust itself to 
     *              keep its right order.
     * @return
     */
    public int poll() {
        if (size < 1) {
            throw new RuntimeException();
        }
        int rs = heapList.set(1, heapList.get(size));
        heapList.removeLast();
        size--;
        if (size >= 1)
            sink(1);
        return rs;
    }

    /**
     * @Description adjust the heap bottom up  from the nth element   
     * @param n
     */
    private void swim(int n) {
        if (size < n || n < 1) {
            throw new RuntimeException();
        }

        if (heapList.get(getParent(n)) >= heapList.get(n)) {
            return;
        }
        exch(getParent(n), n);
        swim(getParent(n));
    }

    /**
     * @Description adjust the heap top down from the nth element
     * @param n
     */
    private void sink(int n) {
        if (size < n || n < 1) {
            throw new RuntimeException();
        }

        if ((n * 2 + 1) > size && (n * 2) > size) {
            return;
        }

        if ((n * 2) <= size && (n * 2 + 1) <= size) {
            int maxIndex = maxIndex(n * 2, n * 2 + 1);
            if (heapList.get(maxIndex) > heapList.get(n)) {
                exch(maxIndex, n);
                sink(maxIndex);
            }
        }

        else if ((n * 2) <= size) {
            if (heapList.get(n * 2) >= heapList.get(n)) {
                exch(2 * n, n);
                sink(2 * n);
            }
        }
    }

    /**
     * @Description swap the value of the No.m and No.n elements
     * @param m
     * @param n
     */
    private void exch(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }
        Integer t = heapList.get(m);
        heapList.set(m, heapList.get(n).intValue());
        heapList.set(n, t.intValue());
    }

    /**
     * @Description get parent element of the nth elements 
     *              the amazing attribute of heap structure !
     * @param n
     * @return
     */
    private int getParent(int n) {
        if (size < n || n < 1) {
            throw new RuntimeException();
        }
        if (1 == n)
            return 1;
        if (0 == n % 2)
            return n / 2;
        else
            return ((n - 1) / 2);
    }

    /**
     * @Description return the index of which element has bigger value
     * @param m
     * @param n
     * @return
     */
    private int maxIndex(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }
        return (heapList.get(m) > heapList.get(n)) ? m : n;
    }
    
    
}
