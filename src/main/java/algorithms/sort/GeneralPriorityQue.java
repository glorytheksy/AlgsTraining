package algorithms.sort;

import java.util.LinkedList;
/**
 * 
 * @ClassName GeneralPriorityQue
 * @Description 利用泛型泛化了优先队列
 * @author yxmfi
 * @Date 2017年8月27日 下午4:42:57
 * @version 1.0.0
 * @param <Key>
 */
public class GeneralPriorityQue<Key extends Comparable<Key>> {
        
    // 存储数据数组(第一个元素我们并不使用)
    @SuppressWarnings({"unchecked", "serial" })
    private LinkedList<Key> simHeap = new LinkedList<Key>() {{add(((Key[])new Comparable [1])[0]);}};

    // 优先队列数据长度
    private int size = 0;
    
    public LinkedList<Key> getSimHeap() {
        return simHeap;
    }

    public void setSimHeap(LinkedList<Key> simHeap) {
        this.simHeap = simHeap;
    }
    

    public boolean isEmpty() {
        return (0 == size);
    }

    public int getSize() {
        return size;
    }

    public void push(Key element) {
        simHeap.add(element);
        size++;
        swim(size);
    }

    public Key poll() {
        if (size < 1) {
            throw new RuntimeException();
        }
        Key rs = simHeap.set(1, simHeap.get(size));
        simHeap.removeLast();
        size--;
        if (size >= 1)
            sink(1);
        return rs;
    }
    
    
    
    
    
    
    

    private void swim(int n) {
        if (size < n || n < 1) {
            throw new RuntimeException();
        }

        if (less(simHeap.get(n), simHeap.get(getSuper(n))) || equal(simHeap.get(n), simHeap.get(getSuper(n)))) {
            return;
        }
        exch(getSuper(n), n);
        swim(getSuper(n));
    }

    private void sink(int n) {
        if (size < n || n < 1) {
            throw new RuntimeException();
        }

        if ((n * 2 + 1) > size && (n * 2) > size) {
            return;
        }

        if ((n * 2) <= size && (n * 2 + 1) <= size) {
            int maxIndex = maxIndex(n * 2, n * 2 + 1);
            if (less(simHeap.get(n), simHeap.get(maxIndex))) {
                exch(maxIndex, n);
                sink(maxIndex);
            }
        }

        else if ((n * 2) <= size) {
            if (less(simHeap.get(n), simHeap.get(n * 2)) || equal(simHeap.get(n), simHeap.get(n * 2))) {
                exch(2 * n, n);
                sink(2 * n);
            }
        }
    }

    private void exch(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }
        Key t = simHeap.get(m);
        simHeap.set(m, simHeap.get(n));
        simHeap.set(n, t);
    }

    /**
     * @Description 父节点索引
     * @param n
     * @return
     */
    private int getSuper(int n) {
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
     * @Description 值较大者索引
     * @param m
     * @param n
     * @return
     */
    private int maxIndex(int m, int n) {
        if (m > size || n > size) {
            throw new RuntimeException();
        }        
        return (less(simHeap.get(n), simHeap.get(m))) ? m : n;
    }

    private boolean less(Key k1, Key k2) {
        return (k1.compareTo(k2) < 0);
    }
    
    private boolean equal(Key k1, Key k2) {
        return (0 == (k1.compareTo(k2)));
    }
}
